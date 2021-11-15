package com.example.mc_task3_BCSF18A511;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button githubBtn;
    Button runBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        githubBtn = findViewById(R.id.githubBtn);
        runBtn = findViewById(R.id.runBtn);
        githubBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Uri webpage = Uri.parse("https://github.com/AhsanRiaz9/MC-Task3-BCSF18A511");
                Intent intent = new Intent(Intent.ACTION_VIEW,webpage);
                startActivity(intent);
            }
        });
        runBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}