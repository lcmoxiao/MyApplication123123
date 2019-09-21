package com.example.myapplication123123.Splash;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;


import com.example.myapplication123123.base.BaseActivity;
import com.example.myapplication123123.base.FullScreenVideoView;
import com.example.myapplication123123.R;
import com.example.myapplication123123.base.ViewInject;
import com.example.myapplication123123.main.MainActivity;

import java.io.File;

import butterknife.BindView;

//继承BaseActivity实现注释
@ViewInject(main_layout_id = R.layout.activity_splash)
public class SplashActivity extends BaseActivity implements ISplashActivityContract.IView {

    @BindView(R.id.videoV)
    FullScreenVideoView videoV;
    @BindView(R.id.Skip_tv)
    TextView Skip_tv;

    //绑定Presenter
    private ISplashActivityContract.IPresenter splashTimerPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        //恢复Bundle数据
        super.onCreate(savedInstanceState);
    }

    @Override
    public void afterBindView() {
        initTimerPresenter();
        initClickListener();
        initVideo();
    }

    //初始化timerPresenter
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
        Skip_tv.setOnClickListener(v -> {
            //进入主页
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finish();
        });
    }

    //设置跳过按钮
    @Override
    public void setSkipTv(String s) {
        Skip_tv.setText(s);
    }

    //销毁和Presenter销毁
    @Override
    protected void onDestroy() {
        super.onDestroy();
        splashTimerPresenter.onDestroy();
    }
}

