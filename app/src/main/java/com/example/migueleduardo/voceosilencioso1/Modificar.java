package com.example.migueleduardo.voceosilencioso1;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class Modificar extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    String cpapa;
    FirebaseUser usuario;
    public final static String correoPapa = "correo_padra";
    public final static String idPapa = "id_padre";
    public DatabaseReference databaseReference;
    ListView listView;
    List<InformacionAlta> personas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);
        firebaseAuth = FirebaseAuth.getInstance();
        listView = (ListView) findViewById(R.id.listViewPersonas);
        personas = new ArrayList<>();
        if (firebaseAuth.getCurrentUser() == null) {
            finish();
            Intent regreso = new Intent(Modificar.this, MainActivity.class);
            startActivity(regreso);
        }

        usuario = firebaseAuth.getCurrentUser();
        cpapa = usuario.getUid().toString().trim();
        databaseReference = FirebaseDatabase.getInstance().getReference(usuario.getUid());

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //aqui creamos el QR

            }
        });






//mantiene presionado la celda y hace que salga la pantalla de actualización
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                InformacionAlta pers = personas.get(i);



                Toast.makeText(getApplicationContext(),"Aqui esta el id cuando lo presionas"+pers.getIdusuariobebe(),Toast.LENGTH_LONG).show();
                showUpdateDialog(pers.getNombre(), pers.getApellidos(), pers.getCelular(), pers.getMarcaauto(), pers.getNombreauto(), pers.getColor(), pers.getMatricula(),pers.getIdusuariobebe(),pers.getNombredelniño());

                return false;
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                personas.clear();
                for (DataSnapshot personasnap : dataSnapshot.getChildren()) {
                    InformacionAlta persona = personasnap.getValue(InformacionAlta.class);
                    personas.add(persona);

                }
                listaPersonasModificar adapte = new listaPersonasModificar(Modificar.this, personas);
                listView.setAdapter(adapte);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void showUpdateDialog(String nombre, String apellidos, String celular, String marca, String nombreauto, String color, String matricula, final String idfinal,String nombredelabendicion ) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater layoutInflater = getLayoutInflater();
        final View dialogView = layoutInflater.inflate(R.layout.update_dialog, null);
        dialogBuilder.setView(dialogView);

         final String iddeveritas = idfinal;
        final EditText editnombredelniño = (EditText) dialogView.findViewById(R.id.updbebe);
        final EditText editnombre = (EditText) dialogView.findViewById(R.id.updnombre);
        final EditText editapellido = (EditText) dialogView.findViewById(R.id.updapellido);
        final EditText editcelular = (EditText) dialogView.findViewById(R.id.updtelefono);
        final EditText editmarcaauto = (EditText) dialogView.findViewById(R.id.updmarca);
        final EditText editnombreauto = (EditText) dialogView.findViewById(R.id.updnombreauto);
        final EditText editcolor = (EditText) dialogView.findViewById(R.id.updcolor);
        final EditText editmatricula = (EditText) dialogView.findViewById(R.id.updmatricula);
        final Button botonactualizar = (Button) dialogView.findViewById(R.id.btnactualizar);
        final Button delete = (Button)dialogView.findViewById(R.id.btneliminar);

        dialogBuilder.setTitle("Actualizar informacion");
        final AlertDialog alertDialog = dialogBuilder.create();
        Toast.makeText(getApplicationContext(), "Aqui esta la variable cpapa "+cpapa, Toast.LENGTH_LONG).show();
        alertDialog.show();
        botonactualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = databaseReference.getKey().toString().trim(); // este es el hijo del usuario pertenece al sujeto agregado o manejado en cuestion
                String nombre = editnombre.getText().toString().trim();
                String nombredelbebecito = editnombredelniño.getText().toString().trim();
                String apellido = editapellido.getText().toString().trim();
                String celular = editcelular.getText().toString().trim();
                String marcaauto = editmarcaauto.getText().toString().trim();
                String nombreauto = editnombreauto.getText().toString().trim();
                String color = editcolor.getText().toString().trim();
                String matricula = editmatricula.getText().toString().trim();
                String correodepapa = usuario.getEmail();
                String mamadas= iddeveritas;
                if(!TextUtils.isEmpty(id)&&!TextUtils.isEmpty(nombre)&&!TextUtils.isEmpty(apellido)&&!TextUtils.isEmpty(celular)&&!TextUtils.isEmpty(marcaauto)&&!TextUtils.isEmpty(nombreauto)&&!TextUtils.isEmpty(color)&&!TextUtils.isEmpty(matricula)&&!TextUtils.isEmpty(correodepapa)) {
                    Toast.makeText(getApplicationContext(), "CPAPA: "+id+ " mamadas: "+idfinal, Toast.LENGTH_LONG).show();

                    updatepersona(id, nombre, apellido, celular, marcaauto, nombreauto, color, matricula, correodepapa, idfinal,nombredelbebecito);
                    alertDialog.dismiss();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Te falta llenar campos", Toast.LENGTH_LONG).show();
                }

            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference borrarpersona = FirebaseDatabase.getInstance().getReference(cpapa).child(idfinal);
                borrarpersona.removeValue();
                Toast.makeText(getApplicationContext(),"Ruta eliminada",Toast.LENGTH_LONG).show();
                alertDialog.dismiss();

            }
        });

    }


    private boolean updatepersona(String id, String nombre, String apellido, String celular, String marcaauto, String nombreauto, String color, String matricula, String correodepapa,String id2, String bendicion) {
        Toast.makeText(getApplicationContext(),"Aqui miguel"+ cpapa +" y de ahi sigue en la ruta "+id2, Toast.LENGTH_LONG).show();
        DatabaseReference dbreference = FirebaseDatabase.getInstance().getReference(cpapa).child(id2);


        InformacionAlta info = new InformacionAlta(nombre, apellido, matricula, nombreauto, celular, marcaauto, color, id2, correodepapa,bendicion,"iddelaescuela");

       dbreference.setValue(info);
        Toast.makeText(getApplicationContext(), "Información actualizada", Toast.LENGTH_LONG).show();
        return true;
    }
}

