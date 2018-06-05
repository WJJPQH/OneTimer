package com.example.com.onetimer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import java.util.Timer;
import java.util.TimerTask;

public class GuidanceActivity extends AppCompatActivity {
    private Timer timer;
    private int time = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_guidance);
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                for (int i = 0; i < 3 ; i++) {
                    time--;
                    if (time==0){
                        Intent intent = new Intent(GuidanceActivity.this,MainActivity.class);
                        startActivity(intent);
                    }
                }
            }
        },3000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
