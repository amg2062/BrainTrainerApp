package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView sumTextView;
    ArrayList<Integer> answers= new ArrayList<Integer>();
    int locationOfCorrectAns;
    TextView displayAnswer;
    int score=0;
    int noOfQuestions=0;
    TextView scoreTextView;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    TextView timerTextView;
    Button playAgainButton;


    public void playAgain(View view){
        playAgainButton.setVisibility(View.INVISIBLE);
        button0.setVisibility(View.VISIBLE);
        button1.setVisibility(View.VISIBLE);
        button2.setVisibility(View.VISIBLE);
        button3.setVisibility(View.VISIBLE);
        timerTextView.setVisibility(View.VISIBLE);
        scoreTextView.setVisibility(View.VISIBLE);
        playAgainButton.setText("PLAY AGAIN!!");
        score=0;
        noOfQuestions=0;
        timerTextView.setText("30s");
        createNewQuestion();
        scoreTextView.setText(Integer.toString(score)+"/"+Integer.toString(noOfQuestions));
        displayAnswer.setText(" ");
        new CountDownTimer(30100,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                timerTextView.setText(String.valueOf(millisUntilFinished/1000)+"s");

            }

            @Override
            public void onFinish() {
                displayAnswer.setText("TIME OVER!!!");
                playAgainButton.setVisibility(View.VISIBLE);
                button0.setVisibility(View.INVISIBLE);
                button1.setVisibility(View.INVISIBLE);
                button2.setVisibility(View.INVISIBLE);
                button3.setVisibility(View.INVISIBLE);
            }
        }.start();
    }



    public void chooseAnswer(View view  ){


        if(Integer.toString(locationOfCorrectAns).equals(view.getTag().toString())){
            displayAnswer.setText("CORRECT ANSWER");
            score++;
        }else{
            displayAnswer.setText("WRONG ANSWER!!");
        }
        noOfQuestions++;
        scoreTextView.setText(Integer.toString(score)+"/"+Integer.toString(noOfQuestions));
        createNewQuestion();
    }

    public void createNewQuestion(){
        Random rand=new Random();
        int a= rand.nextInt(21);
        int b= rand.nextInt(21);
        sumTextView.setText(Integer.toString(a)+"+"+Integer.toString(b));

        locationOfCorrectAns= rand.nextInt(4);
        answers.clear();
        for (int i=0;i<4;i++){
            if(i==locationOfCorrectAns){
                answers.add(a+b);
            }else{
                int wrongAns= rand.nextInt(41);
                while(wrongAns==a+b ){
                    wrongAns= rand.nextInt(41);
                }
                answers.add(wrongAns);
            }
        }
        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sumTextView=findViewById(R.id.sumTextView);

         button0=findViewById(R.id.button0);
         button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        scoreTextView=findViewById(R.id.scoreTextView);
        displayAnswer=findViewById(R.id.textView4);
        timerTextView=findViewById(R.id.timerTextView);
        playAgainButton=findViewById(R.id.playAgainButton);


        button0.setVisibility(View.INVISIBLE);
        button1.setVisibility(View.INVISIBLE);
        button2.setVisibility(View.INVISIBLE);
        button3.setVisibility(View.INVISIBLE);
        timerTextView.setVisibility(View.INVISIBLE);
        scoreTextView.setVisibility(View.INVISIBLE);




    }


}