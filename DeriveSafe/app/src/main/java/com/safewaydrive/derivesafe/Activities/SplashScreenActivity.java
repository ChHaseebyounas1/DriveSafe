package com.safewaydrive.derivesafe.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.safewaydrive.derivesafe.R;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        gotoMainpage();
        getSupportActionBar().hide();
    }

    private void gotoMainpage() {
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    sleep(4000);
                    Intent mintent=new Intent(SplashScreenActivity.this,MainActivity.class);
                    startActivity(mintent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

}
