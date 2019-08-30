package com.example.myapplication123123;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.VideoView;

import java.io.File;


public class SplashActivity extends AppCompatActivity {

    private VideoView video_vv;
    private TextView ticker_tv;
    private CustomCountDownTimer ccd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ticker_tv =  findViewById(R.id.textView);
        ticker_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
            }
        });
        video_vv = findViewById(R.id.videoV);
        video_vv.setVideoURI(Uri.parse("android.resource://"+getPackageName()+ File.separator+R.raw.splash));
        video_vv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });
        video_vv.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
            }
        });
        ccd = new CustomCountDownTimer(5, new CustomCountDownTimer.ICountDownHandler() {
            @Override
            public void onTicker(int time) {
                ticker_tv.setText(time + "秒");
            }
            @Override
            public void onFinish() {
                ticker_tv.setText("跳过");
            }
        });
        ccd.start();



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ccd.cancel();
    }
}

