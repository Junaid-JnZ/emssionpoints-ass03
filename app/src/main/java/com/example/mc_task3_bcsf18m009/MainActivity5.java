package com.example.mc_task3_BCSF18A511;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity5 extends AppCompatActivity implements View.OnClickListener {

    ProgressBar progressBar;
    Button shareBtn, gotoHomeBtn;
    int totalCorrectQ = 6;
    int totalWrongQ = 3;
    int totalQuestion = 10;
    int totatAttemptedQ = 9;
    int totalUnAttempted = 1;
    TextView totalAttempted,totalCorrect,totalWrong,percentage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        progressBar = findViewById(R.id.progressBar);
        shareBtn = findViewById(R.id.shareBtn);
        gotoHomeBtn = findViewById(R.id.gotoHomeBtn);

        totalAttempted = findViewById(R.id.totalAttempted);
        totalCorrect = findViewById(R.id.totalCorrect);
        totalWrong = findViewById(R.id.totalWrong);
        percentage = findViewById(R.id.percentage);

        progressBar.setMax(10);
        progressBar.setProgress(3);
        totalAttempted.setText("Total Attempted: " + totatAttemptedQ);
        totalCorrect.setText("Total Correct: " + totalCorrectQ);
        totalWrong.setText("Total Wrong: " + totalWrongQ);
        percentage.setText("Percentage: " + (totalCorrectQ*100/totalQuestion) + "%");
        shareBtn.setOnClickListener(this);
        gotoHomeBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.shareBtn:
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                String shareMarksDetails = "Your Marks Details are: \n" +
                        "Total Question " + totalQuestion + "\n" +
                        "Total Attempted: " + totatAttemptedQ + "\n" +
                        "Total Un-Attempted: " + totalUnAttempted +"\n" +
                        "Marks: "  + totalCorrectQ + " / " + totalQuestion;
                sendIntent.putExtra(Intent.EXTRA_TEXT, shareMarksDetails);
                sendIntent.setType("text/plain");
                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
                break;
            case R.id.gotoHomeBtn:
                Intent intent = new Intent(MainActivity5.this,MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}