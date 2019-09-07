package com.example.myapplication123123.Splash;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.myapplication123123.main.IMainActivityContract;
import com.example.myapplication123123.mvp.base.BaseMvpPresenter;



class SplashTimerPresenter extends BaseMvpPresenter<ISplashActiviytContract.IView> implements ISplashActiviytContract.IPresenter {

    private CustomCountDownTimer customCountDownTimer;

    public SplashTimerPresenter(ISplashActiviytContract.IView view) {
        super(view);
    }


    public void setTimer() {
        //设置计时器

        customCountDownTimer = new CustomCountDownTimer(5, new CustomCountDownTimer.ICountDownHandler() {
            @Override
            public void onTicker(int time) {
                getView().setSkipTv(time +"秒");
            }

            @Override
            public void onFinish() {
                getView().setSkipTv("跳过");
            }
        });
        customCountDownTimer.start();

    }

    public void cancel() {
        customCountDownTimer.cancel();
    }




    @Override
    public IMainActivityContract.IView onActivityCreated(Bundle savedInstanceState, Intent intent, Bundle getArguements) {

        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        cancel();
        Log.e("ss","ss");
    }

    /**
     * 防止空指针
     * @return emptyView
     */
    @Override
    protected ISplashActiviytContract.IView getEmptyView() {
        return ISplashActiviytContract.emptyView;
    }

}
