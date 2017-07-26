package com.example.migueleduardo.voceosilencioso1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Principal extends AppCompatActivity {
        private FirebaseAuth firebaseAuth;
        private TextView emaiview;
        private Button alta;
        private Button modificar;
        private Button  salir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() == null){
            finish();
            Intent regresa = new Intent(Principal.this,MainActivity.class);
            startActivity(regresa);
        }
        salir = (Button) findViewById(R.id.btnloggout);
        modificar = (Button)findViewById(R.id.btnmodificar);
        final FirebaseUser usuario = firebaseAuth.getCurrentUser();
        alta = (Button) findViewById(R.id.btnalta);
        emaiview = (TextView) findViewById(R.id.textView);
        emaiview.setText("Bienvenido "+usuario.getEmail());
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.signOut();
                Intent main = new Intent(Principal.this,MainActivity.class);
                startActivity(main);
            }
        });
        alta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent alta = new Intent(Principal.this, Alta.class);
                startActivity(alta);
            }
        });
        modificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent modificar = new Intent(Principal.this, Modificar.class);
                startActivity(modificar);

            }
        });
    }
}
