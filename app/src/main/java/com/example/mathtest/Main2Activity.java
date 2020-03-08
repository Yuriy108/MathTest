package com.example.mathtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView textViewResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent=getIntent();
        int result=intent.getIntExtra("max",0);
        int record=intent.getIntExtra("record",0);
        String score= String.format("Youre score %s\n Max score %s", result,record);
        textViewResult=findViewById(R.id.textViewMax);
        textViewResult.setText(score);


    }

    public void restart(View view) {
        Intent intent= new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
