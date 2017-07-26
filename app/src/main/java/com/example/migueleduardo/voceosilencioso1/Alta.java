package com.example.migueleduardo.voceosilencioso1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Alta extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    private EditText nombre;
    private EditText apellidos;
    private EditText celular;
    private EditText marca;
    private EditText nombreauto;
    private EditText colorauto;
    private EditText matriculaauto;
    private Button guardar;
    private Button salir;
    private EditText nombredelniño;
    String correo,prueba;
    private DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta);
        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser()==null){
            finish();
            Intent regreso = new Intent(Alta.this,MainActivity.class);
            startActivity(regreso);
        }
        FirebaseUser usuario = firebaseAuth.getCurrentUser();
          prueba = usuario.getUid().toString().trim();
        correo = usuario.getEmail().toString().trim();
        databaseReference = FirebaseDatabase.getInstance().getReference(prueba);


        nombredelniño = (EditText)findViewById(R.id.txtnombrenino);
        nombre = (EditText)findViewById(R.id.txtnombre);
        apellidos = (EditText)findViewById(R.id.txtapellido);
        celular = (EditText)findViewById(R.id.txtcelular);
        marca = (EditText)findViewById(R.id.txtmarcaauto);
        nombreauto = (EditText)findViewById(R.id.txtnombreauto);
        colorauto = (EditText) findViewById(R.id.txtcolor);
        matriculaauto = (EditText) findViewById(R.id.txtmatricula);
        guardar = (Button) findViewById(R.id.btnGuardar);
        salir = (Button) findViewById(R.id.btnsalir);


        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre1 = nombre.getText().toString().trim();
                String apellidos1 = apellidos.getText().toString().trim();
                String celular1 = celular.getText().toString().trim();
                String marca1 = marca.getText().toString().trim();
                String nombreauto1 = nombreauto.getText().toString().trim();
                String colorauto1 = colorauto.getText().toString().trim();
                String matriculaauto1 = matriculaauto.getText().toString().trim();
                String correito = correo;
                String nombredelbebe = nombredelniño.getText().toString().trim();





                if(!TextUtils.isEmpty(nombre1)&& !TextUtils.isEmpty(apellidos1)&&!TextUtils.isEmpty(celular1)&&!TextUtils.isEmpty(marca1)&&!TextUtils.isEmpty(nombreauto1)&&!TextUtils.isEmpty(colorauto1)&&!TextUtils.isEmpty(matriculaauto1)){
                    String id = databaseReference.push().getKey();
                    String userid = databaseReference.child(id).getKey().toString().trim();
                    InformacionAlta infoalta = new InformacionAlta(nombre1,apellidos1,celular1,marca1,nombreauto1,colorauto1,matriculaauto1,id,correito,nombredelbebe,"idescuelaparaverficar");
                    databaseReference.child(id).setValue(infoalta);
                    Toast.makeText(getApplicationContext(),"usuario bebe id: "+id+ " user id= "+userid,Toast.LENGTH_LONG).show();
                Toast.makeText(Alta.this, "Información agregada, puedes añadir otro usuario",Toast.LENGTH_LONG).show();
                    Toast.makeText(getApplicationContext(),userid,Toast.LENGTH_LONG).show();
                nombre.setText("");
                apellidos.setText("");
                celular.setText("");
                marca.setText("");
                nombreauto.setText("");
                colorauto.setText("");
                matriculaauto.setText("");
                    nombredelniño.setText("");

                }
                else{
                    Toast.makeText(Alta.this, "Te falta llenar un campo",Toast.LENGTH_LONG).show();
                }



            }
        });

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regresar = new Intent( Alta.this, Principal.class);
                startActivity(regresar);
            }
        });

    }
}
