package com.example.android.yinga;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    int score=0  ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void displayScoreAndMessage(View view){
        score=0;
        score = scoreCounter();
        String remark ="";
        switch (score){
            case 0:
            remark="Better luck next time";
            break;
            case 1:
                remark="One point for you";
                break;
            case 2:
                remark="Two points for you";
                break;
            case 3:
                remark="Not bad";
                break;
            case 4:
                remark="Great!";
                break;
            case 5:
                remark="So close!";
                break;
            case 6:
                remark="Brilliant!";
                break;
        }
        String scoreText = "Score : " + score+ "\n" + remark ;
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, scoreText, duration);
        toast.setGravity(Gravity.CENTER_HORIZONTAL&Gravity.CENTER_VERTICAL, 0, -100);
        toast.show();
         }

    int scoreCounter() {
        RadioButton q1Answer = (RadioButton) findViewById(R.id.Q1_answer);
        EditText q2Answer = (EditText) findViewById(R.id.Q2_answer);
        EditText q3Answer = (EditText) findViewById(R.id.Q3_answer);
        CheckBox q4Answer1 = (CheckBox)findViewById(R.id.Q4_answer1);
        CheckBox q4Answer2 = (CheckBox)findViewById(R.id.Q4_answer2);
        RadioButton q5Answer = (RadioButton) findViewById(R.id.Q5_answer);
        boolean answer1=q1Answer.isChecked();
        String answer2=q2Answer.getText().toString().toUpperCase();
        String answer3 =q3Answer.getText().toString().toUpperCase();
        boolean answer4_1 = q4Answer1.isChecked();
        boolean answer4_2 = q4Answer2.isChecked();
        boolean answer5=q5Answer.isChecked();
        for (int i=0;i<6 ; i++){
            if(i == 0){
                if (answer1){
                    score+=1;
                }
            }
            else if(i == 1){
                if (answer2.equals("ADIDAS")){
                    score+=1;
                }
            }
            else if(i == 2){
                if (answer3.equals("RONALDO")){
                    score+=1;
                }
            }
            else if(i == 3){
                if (answer4_1 && answer4_2){
                    score+=2;
                }
                else if (answer4_1  || answer4_2){
                    score+=1;
                }
            }
            else if(i == 4){
                if (answer5){
                    score+=1;
                }
            }

        }
        return score;
        }

    }

