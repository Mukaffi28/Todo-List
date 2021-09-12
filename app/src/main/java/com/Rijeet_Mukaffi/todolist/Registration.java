package com.Rijeet_Mukaffi.todolist;



import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

import com.google.firebase.auth.FirebaseAuth;

public class Registration extends AppCompatActivity {
    EditText name,email,password,phone;
    TextView login;
    ImageView sign;
    FirebaseAuth fAuth;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        name =findViewById(R.id.editTextTextPersonNamereg);
        email =findViewById(R.id.emailReg);
        password =findViewById(R.id.passwordreg);
        phone =findViewById(R.id.phonoreg);
        login=findViewById(R.id.CreateAccountText);
        sign=findViewById(R.id.signup);

        fAuth=FirebaseAuth.getInstance();
        progressBar=findViewById(R.id.progressBarreg);

        sign.setOnClickListener(v -> {
            String Email= email.getText().toString().trim();
            String Password =password.getText().toString().trim();
            if(TextUtils.isEmpty(Email)){
                email.setError("Email is require");
                return;

            }
            if(TextUtils.isEmpty(Password)){
                password.setError("Password is requied ");
                return;

            }
            if(Password.length()<6){
                password.setError("Password must be more than 6 character");
                return;

            }
            progressBar.setVisibility(View.VISIBLE);
            if(fAuth.getCurrentUser()!=null)
          /*  {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();

            }*/

            // register fireBase

            fAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){

                        Toast.makeText(Registration.this, "User Created", Toast.LENGTH_SHORT).show();
                       startActivity(new Intent(getApplicationContext(),LoginPage.class));

                    }
                    else
                        Toast.makeText(Registration.this, "Error! "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),LoginPage.class));
            }
        });


    }
}