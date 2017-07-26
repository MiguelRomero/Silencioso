package com.example.migueleduardo.voceosilencioso1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class agregar_ninos extends AppCompatActivity {
    TextView correopapa;
    EditText nino_a_agregar;
    Button btnagregar_nino;
    EditText matricula_nino;
    String correoUsuario;
    String nombrePersona;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_ninos);
        correopapa = (TextView)findViewById(R.id.txtnombrePersonaEncargada);
        matricula_nino = (EditText)findViewById(R.id.txtmatriculanino);
        nino_a_agregar = (EditText)findViewById(R.id.editninosarecoger);
        btnagregar_nino = (Button)findViewById(R.id.btnagregarnino);


        Intent intent = getIntent();
        correoUsuario = intent.getStringExtra("idPapa");
        nombrePersona = intent.getStringExtra("nombrePersona");

        correopapa.setText(nombrePersona);
       // aqui se van a añadir niños despues



    }

}
