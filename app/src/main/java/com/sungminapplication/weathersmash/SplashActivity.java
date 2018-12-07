package com.sungminapplication.weathersmash;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Switch;

//스플래쉬 화면
public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //스레드를 사용한 2초 후 화면 재생
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
                    StaticValue staticValue = StaticValue.getInstance();
                    //앱 실행시 StaticValue 점검
                    Log.d("StaticValue", "\n" +staticValue.getStartDate()+ "\n" +staticValue.getCurrentHr()+ "\n" +
                            staticValue.getEndDate()+ "\n" +staticValue.getLocation()+ "\n" +staticValue.ApiKey);
                    //화면 넘기기
                    startActivity(new Intent(SplashActivity.this, PermissionActivity.class));
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        //스레드 시작
        WaitginTrhead.start();
    }
}