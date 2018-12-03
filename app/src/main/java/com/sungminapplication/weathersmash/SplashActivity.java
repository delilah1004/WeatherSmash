package com.sungminapplication.weathersmash;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    //스플래쉬 화면
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        MakeThread();


    }

    public void MakeThread(){
        //스레드 생성
        Thread WaitginTrhead = new Thread()
        {
            @Override
            public void run() {
                try {
                    //2초 일시정지
                    sleep(2000);
                    //화면 넘기기
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        //스레드 시작
        WaitginTrhead.start();
    }
}