package com.example.jafarabdi.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.os.Handler;

import com.example.jafarabdi.project.beranda.Home;

public class SplashActivity extends Activity {
    private static int splashInterval=1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splashscreen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashActivity.this, Home.class);
                startActivity(intent);
                this.finish();
            }
            private void finish(){

            }
        },splashInterval);
        /*Thread mythread=new Thread(){
            @Override
            public void run() {
                //super.run();
                try {
                    sleep(3000);
                    Intent intent=new Intent(getApplicationContext(),Main2Activity.class);
                    startActivity(intent);
                    finish();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        mythread.start();*/
    };
}
