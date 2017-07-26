package com.example.migueleduardo.voceosilencioso1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private Button btnLogin;
    private EditText txtUser;
    private EditText txtPass;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth = FirebaseAuth.getInstance();



        if(firebaseAuth.getCurrentUser()!=null){
            finish();
            Intent Principal2 = new Intent(MainActivity.this,Principal.class);
            startActivity(Principal2);
        }



        btnLogin = (Button)findViewById(R.id.btnlogin);
        txtPass = (EditText) findViewById(R.id.txtpassword);
        txtUser = (EditText)findViewById(R.id.txtemail);







        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String contraseña = txtPass.getText().toString().trim();
                String email = txtUser.getText().toString().trim();
                if(TextUtils.isEmpty(email)){
                    Toast.makeText(MainActivity.this,"Falta el correo electronico",Toast.LENGTH_LONG).show();
                }else if(TextUtils.isEmpty(contraseña)){
                    Toast.makeText(MainActivity.this,"Falta la contraseña ",Toast.LENGTH_LONG).show();

                }else {
                   ingreso(email,contraseña);
                    //----
                    Toast.makeText(MainActivity.this,"Datos completos ",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
    public void ingreso(String email, String contraseña){
        String mail,contra;
        mail = email;
        contra = contraseña;
        firebaseAuth.signInWithEmailAndPassword(mail,contra)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            finish();
                            Intent principal = new Intent(MainActivity.this,Principal.class);
                            startActivity(principal);
                        }else{
                            Toast.makeText(MainActivity.this, "No extistes en la base de datos",Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}
