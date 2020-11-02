package com.example.myworkoutpal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CountDownTimer cTimer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startTimer();
    }

    void startTimer() {
        cTimer = new CountDownTimer(30000, 1000) {
            private TextView countdown = findViewById(R.id.countdown);

            @Override
            public void onTick(long millisUntilFinished ) {
                countdown.setText(Long.toString(millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {
                cancel();
            }
        };
        cTimer.start();
    }
}