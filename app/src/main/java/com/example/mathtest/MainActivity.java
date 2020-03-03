package com.example.mathtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView answer1;
    TextView answer2;
    TextView answer3;
    TextView answer4;
    TextView question;
    int result;
    int indexResalt;
    int wrongAnswer;
    ArrayList<TextView>option=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        answer1=findViewById(R.id.textVar1);
        answer2=findViewById(R.id.textVar2);
        answer3=findViewById(R.id.textVar3);
        answer4=findViewById(R.id.textVar4);
        question=findViewById(R.id.textQuestion);
        option.add(answer1);
        option.add(answer2);
        option.add(answer3);
        option.add(answer4);

    }
    
}
