package com.example.mathtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    ConstraintLayout layout;
    TextView v1;
    TextView v2;
    TextView v3;
    TextView v4;
    TextView quest;
    //TextView ;
    SharedPreferences sharedPreferences;
    TextView answer1;
    TextView answer2;
    TextView answer3;
    TextView answer4;
    TextView question;
    TextView time;
    TextView score;
    int count=0;
    int total=0;
    int max=50;
    int result;
    int indexResult;
    String rightAnswer;
    String timeShow;
    String countTotal;
    ArrayList<TextView>option=new ArrayList<>();
    boolean gameOver=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = findViewById(R.id.Backgoround);
        v1=findViewById(R.id.textVar1);
        Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.varsanim);
        v1.startAnimation(animation);



        quest=findViewById(R.id.textQuestion);
        Animation animationQ = AnimationUtils.loadAnimation(MainActivity.this, R.anim.zoomin);
        quest.startAnimation(animationQ);

        v2=findViewById(R.id.textVar2);
        Animation animation2 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.test);
        v2.startAnimation(animation2);

        v3=findViewById(R.id.textVar3);
        Animation animation3 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.varsanim);
        v3.startAnimation(animation3);

        v4=findViewById(R.id.textVar4);
        Animation animation4 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.test);
        v4.startAnimation(animation4);

        time=findViewById(R.id.textViewTimer);
        Animation animationTime = AnimationUtils.loadAnimation(this, R.anim.lefttoright);
        time.startAnimation(animationTime);

        score=findViewById(R.id.textView2Score);
        Animation animationScore = AnimationUtils.loadAnimation(this, R.anim.lefttoright);
        score.startAnimation(animationScore);

        answer1=findViewById(R.id.textVar1);
        answer2=findViewById(R.id.textVar2);
        answer3=findViewById(R.id.textVar3);
        answer4=findViewById(R.id.textVar4);
        question=findViewById(R.id.textQuestion);
        time=findViewById(R.id.textViewTimer);
        score=findViewById(R.id.textView2Score);
        option.add(answer1);
        option.add(answer2);
        option.add(answer3);
        option.add(answer4);
        generateQuestion();
        for (int i=0;i<4;i++){
            if (i==indexResult){
                option.get(i).setText(Integer.toString(result));

            }
            else{option.get(i).setText(generateWrogeAnswer());}
        }
        CountDownTimer countDownTimer= new CountDownTimer(5000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeShow=countTime(millisUntilFinished);
                time.setText(timeShow);

            }

            @Override
            public void onFinish() {
                gameOver=true;
                sharedPreferences=getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor ed=sharedPreferences.edit();
                int record=sharedPreferences.getInt(getString(R.string.key),0);
                if (record<count){ record=count;
                ed.putInt("key",count);
                ed.apply();
                 }

                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("max",count);
                intent.putExtra("record",record);
                startActivity(intent);


            }
        };
        countDownTimer.start();




    }

    private  void generateQuestion(){
      //  layout.setBackgroundColor(1);
        int x=(int)(Math.random()*max);
        int y=(int)(Math.random()*max);
        int sign= (int)Math.random()*3;
        switch (sign){
            case 0:result=x+y;
                rightAnswer=Integer.toString(x) +" "+"+ "+ Integer.toString(y);
            break;
            case 1:result=x-y;
                rightAnswer=Integer.toString(x) +" "+"- "+ Integer.toString(y);
            break;
            case 2:result=x*y;
                rightAnswer=Integer.toString(x) +" "+"* "+ Integer.toString(y);
            break;
        }
        //result=x+y;
        //rightAnswer=Integer.toString(x) +" "+"+ "+ Integer.toString(y);
        question.setText(rightAnswer);
        indexResult=(int)(Math.random()*4);


    }
    private String generateWrogeAnswer(){
        int x=0;
        do{ x=(int)(Math.random()*10-5);
        x=result+x; }
        while (x==result);
        return Integer.toString(x);
    }
    private String countTime(long millisec){
        int seconds=(int)(millisec/1000);
        int min =seconds/60;
        int sec=seconds%60;
        String resultTime=String.format(Locale.getDefault(),"%02d:%02d",min,sec);
        return resultTime;

    }


    public void Next(View view) {
        if(gameOver==false) {
        TextView text=(TextView)view;
        int answer=Integer.parseInt(text.getText().toString());
        if(answer==result){count++;

        } //else {
            //layout.setBackgroundColor(250);
        //}

        total++;
        countTotal=Integer.toString(count)+" / "+Integer.toString(total);
        score.setText(countTotal);
        generateQuestion();
        for (int i=0;i<4;i++){
            if (i==indexResult){
                option.get(i).setText(Integer.toString(result));

            }
            else{option.get(i).setText(generateWrogeAnswer());}
        }


        }
    }
}
