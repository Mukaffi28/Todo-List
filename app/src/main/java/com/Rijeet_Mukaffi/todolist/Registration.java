package com.Rijeet_Mukaffi.todolist;


import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class Registration extends AppCompatActivity {
    EditText name,email,password,phone;
    TextView login;
    Button sign;
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
    }
}