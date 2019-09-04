package com.example.myapplication123123;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;

@ViewInject(main_layout_id = R.layout.activity_splash)
public class SplashActivity extends AppCompatActivity {


    @BindView(R.id.videoV)
    FullScreenVideoView videoV;
    @BindView(R.id.Skip_tv)
    TextView Skip_tv;
    SplashTimerPresenter splashTimerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        initTimerPresenter();
        initClickListener();
        initVideo();

    }

    private void initTimerPresenter() {

        splashTimerPresenter = new SplashTimerPresenter(this);
        splashTimerPresenter.setTimer();
    }

    //绑定Splash视频 设定循环播放
    private void initVideo() {
        videoV.setVideoURI(Uri.parse("android.resource://" + getPackageName() + File.separator + R.raw.splash));
        videoV.setOnPreparedListener(MediaPlayer::start);
        videoV.setOnCompletionListener(MediaPlayer::start);
    }

    //设置跳过按钮点击事件
    private void initClickListener() {
        Skip_tv.setOnClickListener(v -> startActivity(new Intent(SplashActivity.this, MainActivity.class)));
    }

    public void setSkipTv(String s) {
        Skip_tv.setText(s);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        splashTimerPresenter.onDestroy();
    }
}

