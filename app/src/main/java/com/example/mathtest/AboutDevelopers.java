package com.example.mathtest;


import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class AboutDevelopers extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.aboutdevelopers);
        Intent intent=getIntent();
        String text=intent.getStringExtra("name");
    }

}
