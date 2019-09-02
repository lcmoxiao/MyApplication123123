package com.example.myapplication123123;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;


public class SplashActivity extends AppCompatActivity {

    private TextView ticker_tv;
    private CustomCountDownTimer ccd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ticker_tv =  findViewById(R.id.textView);
        ticker_tv.setOnClickListener(v -> startActivity(new Intent(SplashActivity.this,MainActivity.class)));
        VideoView video_vv = findViewById(R.id.videoV);
        video_vv.setVideoURI(Uri.parse("android.resource://"+getPackageName()+ File.separator+R.raw.splash));
        video_vv.setOnPreparedListener(MediaPlayer::start);
        video_vv.setOnCompletionListener(MediaPlayer::start);
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

