package com.example.myapplication123123.Splash;

import com.example.myapplication123123.mvp.ILifeCircle;
import com.example.myapplication123123.mvp.IMvpView;
import com.example.myapplication123123.mvp.MvpControler;

public interface ISplashActiviytContract {

    interface IView extends IMvpView {
        void setSkipTv(String s);

    }

    interface  IPresenter extends ILifeCircle {
        void setTimer();
    }

    IView emptyView = new IView() {
        @Override
        public void setSkipTv(String s) {

        }

        @Override
        public MvpControler getMvpControler() {
            return null;
        }
    };
}
