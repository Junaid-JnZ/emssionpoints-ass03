package com.example.mc_task3_BCSF18A511;

import static android.graphics.Color.parseColor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity implements View.OnClickListener{

    Button nextBtn;
    TextView alphabet, correctAns;
    TextView questionNo;
    QuestionPool questionPool;
    Question q;
    Button op1,op2,op3,op4;
    int defaultColor;
    int correctColor;
    int wrongColor;
    boolean flag = false;
    int count = 1;
    private MediaPlayer correctSoundMediaPlayer;
    private MediaPlayer wrongSoundMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        // media player
        correctSoundMediaPlayer = MediaPlayer.create(this,R.raw.correct);
        wrongSoundMediaPlayer = MediaPlayer.create(this,R.raw.wrong);
        // color initlization
        defaultColor = parseColor("#78432C");
        correctColor = parseColor("#0f8425");
        wrongColor = parseColor("#b71249");
        nextBtn = findViewById(R.id.nextBtn);
        alphabet = findViewById(R.id.arabicLetter);
        correctAns = findViewById(R.id.correctAns);
        questionNo = findViewById(R.id.questionNo);
        op1 = findViewById(R.id.op1);
        op2 = findViewById(R.id.op2);
        op3 = findViewById(R.id.op3);
        op4 = findViewById(R.id.op4);
        nextBtn.setOnClickListener(this);
        op1.setOnClickListener(this);
        op2.setOnClickListener(this);
        op3.setOnClickListener(this);
        op4.setOnClickListener(this);

        questionPool = new QuestionPool();
        q = questionPool.getRandomQuestion();
        alphabet.setText(q.letter);
        op1.setText(q.op1);
        op2.setText(q.op2);
        op3.setText(q.op3);
        op4.setText(q.op4);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.nextBtn:
                count++;
                if(count<=10)
                {
                    String s = "Question: " + count + "/10";
                    questionNo.setText(s);
                    q = questionPool.getRandomQuestion();
                    alphabet.setText(q.letter);
                    op1.setText(q.op1);
                    op2.setText(q.op2);
                    op3.setText(q.op3);
                    op4.setText(q.op4);
                    flag = false;
                    resetColor();
                    correctAns.setText("");
                }
                else
                {
                    Intent intent = new Intent(MainActivity4.this, MainActivity5.class);
                    startActivity(intent);
                }
                break;
            case R.id.op1:
                if(flag==false)
                {
                    changeBtnColors(op1,isCorrectAnswer(op1.getText().toString()));
                    correctAns.setText("Correct: " + q.correctOption.toUpperCase());
                    flag = true;
                }
                break;
            case R.id.op2:
                if(flag==false)
                {
                    changeBtnColors(op2,isCorrectAnswer(op2.getText().toString()));
                    correctAns.setText("Correct: " + q.correctOption.toUpperCase());
                    flag = true;
                }
                break;
            case R.id.op3:
                if(flag==false)
                {
                    changeBtnColors(op3,isCorrectAnswer(op3.getText().toString()));
                    correctAns.setText("Correct: " + q.correctOption.toUpperCase());
                    flag = true;
                }
                break;
            case R.id.op4:
                if(flag==false)
                {
                    changeBtnColors(op4,isCorrectAnswer(op4.getText().toString()));
                    correctAns.setText("Correct: " + q.correctOption.toUpperCase());
                    flag = true;
                }
                break;
        }
    }
    void changeBtnColors(Button btn, boolean dec)
    {
        if(dec==true)
        {
            correctSoundMediaPlayer.start();
            btn.setBackgroundColor(correctColor);
        }
        else
        {
            wrongSoundMediaPlayer.start();
            btn.setBackgroundColor(wrongColor);
        }
    }
    void resetColor()
    {
        op1.setBackgroundColor(defaultColor);
        op2.setBackgroundColor(defaultColor);
        op3.setBackgroundColor(defaultColor);
        op4.setBackgroundColor(defaultColor);
    }

    boolean isCorrectAnswer(String ans)
    {
        return ans==q.correctOption;
    }

}