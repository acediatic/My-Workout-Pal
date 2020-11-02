package com.example.myworkoutpal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

public class TimerGo extends AppCompatActivity {
    private Timer cTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_go);

        ConstraintLayout timer_layout = (ConstraintLayout) findViewById(R.id.timer_layout);
        timer_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cTimer.toggle();
            }
        });

        Intent intent = getIntent();
        int length = intent.getIntExtra("timerLength", 0);
        startTimer(length);
    }

    void startTimer(int timerLength) {
        timerLength *= 1000; // convert to ms
        TextView countdownText = findViewById(R.id.countdown_time);
        cTimer = new Timer(timerLength, 100, countdownText);
    }
}