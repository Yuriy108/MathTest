package com.example.mathtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    TextView textViewResult;
    Button b1;
    TextView max;
    String text1;
    String text2;
    String text3;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        text1="Создатель - Лапой Омкаром, ученик 9-мат класса УВК-лицея №100";
        text2="2";
        text3="3";
        b1=findViewById(R.id.button);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.sample_anim);
        b1.startAnimation(animation);

        max=findViewById(R.id.textViewMax);
        Animation animationMax = AnimationUtils.loadAnimation(this, R.anim.sample_anim);
        max.startAnimation(animationMax);


        Intent intent=getIntent();
        int result=intent.getIntExtra("max",0);
        int record=intent.getIntExtra("record",0);
        String score= String.format("Youre score %s\n Max score %s", result,record);
        textViewResult=findViewById(R.id.textViewMax);
        textViewResult.setText(score);



    }

    public boolean onCreateOptionsMenu(Menu menu) {


        getMenuInflater().inflate(R.menu.testmenu, menu);
        return true;
    }

    public void restart(View view) {
        Intent intent= new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void developers (View view) {
        Intent intent1= new Intent(this,AboutDevelopers.class);
        startActivity(intent1);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch(id){
            case R.id.action_settings :
                Intent intent=new Intent(Main2Activity.this,AboutDevelopers.class);
                intent.putExtra("name",text1);
                startActivity(intent);
                return true;
            case R.id.open_settings:
                Toast.makeText(Main2Activity.this,"open",Toast.LENGTH_LONG).show();

                return true;
            case R.id.save_settings:
                Toast.makeText(Main2Activity.this,"save",Toast.LENGTH_LONG).show();

                return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
