package com.example.myapplication123123;

import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication123123.mvp.base.BaseMvpPresenter;

class SplashTimerPresenter extends BaseMvpPresenter {

    private final SplashActivity mActivity;
    private CustomCountDownTimer customCountDownTimer;
    SplashTimerPresenter(SplashActivity splashActivity){
        this.mActivity=splashActivity;
    }


    public void setTimer() {
        //设置计时器

        customCountDownTimer = new CustomCountDownTimer(5, new CustomCountDownTimer.ICountDownHandler() {
            @Override
            public void onTicker(int time) {
                mActivity.setSkipTv(time +"秒");
            }

            @Override
            public void onFinish() {
                mActivity.setSkipTv("跳过");
            }
        });
        customCountDownTimer.start();

    }

    public void cancel() {
        customCountDownTimer.cancel();
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState, Intent intent, Bundle getArguements) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        cancel();
    }
}
