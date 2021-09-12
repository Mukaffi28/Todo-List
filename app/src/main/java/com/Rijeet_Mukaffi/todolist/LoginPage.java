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

public class LoginPage extends AppCompatActivity {
    EditText email,password;
    ImageView login;
    TextView creatAccpage;
    ProgressBar progressBar;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        email =findViewById(R.id.usernameeditText);
        password =findViewById(R.id.passwordEdittext);

        fAuth=FirebaseAuth.getInstance();
        login=findViewById(R.id.Loginbutton);
        creatAccpage=findViewById(R.id.createAccountTextinlogin);
        progressBar=findViewById(R.id.progressBar2);

        login.setOnClickListener(v -> {
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


            //authentical the user

            fAuth.signInWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull  Task<AuthResult> task) {
                    if(task.isSuccessful()){


                        Toast.makeText(LoginPage.this, "Logged in SuccessFully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        progressBar.setVisibility(View.INVISIBLE);

                    }else {
                        Toast.makeText(LoginPage.this, "Error! "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.INVISIBLE);

                    }
                }
            });

        });

        creatAccpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Registration.class));
            }
        });

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email.setText(" ");

            }
        });


    }
}