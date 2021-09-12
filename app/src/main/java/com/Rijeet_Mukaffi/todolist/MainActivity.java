package com.Rijeet_Mukaffi.todolist;


import android.content.Intent;
import android.os.Bundle;


import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity {
    ImageView add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.home_page);

        add =findViewById(R.id.addrem);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Taskadd.class));
            }
        });


    }

    public  void coustomButtonClick(View v){


        startActivity(new Intent(getApplicationContext(),Taskadd.class));



    }
    public  void coustomShowButtonClick(View v){


        startActivity(new Intent(getApplicationContext(),ShowAllTask.class));



    }




            }

      


