package com.example.dictioneryapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private TextView tvOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);

        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            String english=bundle.getString("english");
            tvOutput=findViewById(R.id.tvOutput);
            tvOutput.setText(english);

        }
        else{
            Toast.makeText(this,"No Meaning",Toast.LENGTH_SHORT);
        }
    }
}
