package com.Rijeet_Mukaffi.todolist;


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
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final List<String> list = new ArrayList<>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addtask);
        final ListView Task_List =findViewById(R.id.list);
        final TextAdapter adapter = new TextAdapter();
// ASDFGH
  // aust pera de keno
  // GIT
        adapter.setData(list);
        Task_List.setAdapter(adapter);

        final Button newTaskButton = findViewById(R.id.Addtask);
        newTaskButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                EditText taskInput = new EditText( MainActivity.this);
                TextView b =new TextView( MainActivity.this);



            }

        });
    }

    class TextAdapter extends BaseAdapter {
        List<String> list = new ArrayList<>();
        void setData(List<String> mList){
            list.clear();
            list.addAll(mList);
            notifyDataSetChanged();
        }
        @Override

        public int getCount(){
            return list.size();
        }
        @Override
        public Object getItem(int position)
        {     return null;
        }

        @Override

        public long getItemId(int position)
        {     return 0;
        }


        @Override

        public View getView(int position, View convertView, ViewGroup parent)
        {
            LayoutInflater inflater = (LayoutInflater)
                    MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowView = inflater.inflate(R.layout.tasklist, parent,  false);
            TextView textview = rowView.findViewById(R.id.Task);
            textview.setText(list.get(position));
            return rowView;
        }
    }
}