package com.example.myapplication123123.Splash;

import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication123123.main.IMainActivityContract;
import com.example.myapplication123123.base.BaseMvpPresenter;



class SplashTimerPresenter extends BaseMvpPresenter<ISplashActivityContract.IView> implements ISplashActivityContract.IPresenter {

    private CustomCountDownTimer customCountDownTimer;

    //绑定View层，对View层进行弱引用
    SplashTimerPresenter(ISplashActivityContract.IView view) {
        super(view);
    }

    public void setTimer() {
        //设置计时器
        customCountDownTimer = new CustomCountDownTimer(5, new CustomCountDownTimer.ICountDownHandler() {
            //定义Ticker，显示剩余秒数
            @Override
            public void onTicker(int time) {
                getView().setSkipTv(time +"秒");
            }
            //定义Finish，显示跳过
            @Override
            public void onFinish() {
                getView().setSkipTv("跳过");
            }
        });
        customCountDownTimer.start();

    }

    //结束生命
    private void cancel() {
        customCountDownTimer.cancel();
    }

    @Override
    public IMainActivityContract.IView onActivityCreated(Bundle savedInstanceState, Intent intent, Bundle getArguements) {
        return null;
    }

    //View层引用销毁
    @Override
    public void onDestroy() {
        super.onDestroy();
        cancel();
    }

    @Override
    protected ISplashActivityContract.IView getEmptyView() {
        return ISplashActivityContract.emptyView;
    }
}
