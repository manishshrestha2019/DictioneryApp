package com.example.dictioneryapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private Button btnSub;
    private ListView listView;

    public static final String conversation[]={
            "Namaste", "Hello",
            "K Cha? ", "How are you?",
            "Yeta Aaunush", "Come Here",
            "Kata Jane?", "Where are you going?"

    };
    private Map<String,String> dictionery;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listView);



        dictionery=new HashMap<>();
        for(int i=0;i<conversation.length;i+=2){
            dictionery.put(conversation[i],conversation[i+1]);
        }
        ArrayAdapter dictoneryAdapter=new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                new ArrayList<String>(dictionery.keySet())
        );
        listView.setAdapter(dictoneryAdapter);
       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               String nepali=parent.getItemAtPosition(position).toString();
               String english=dictionery.get(nepali);

               Intent intent =new Intent(MainActivity.this,SecondActivity.class);
               intent.putExtra("english",english);
               startActivity(intent);
           }
       });
    }
}
