package com.example.myapplication123123.Splash;

import com.example.myapplication123123.mvp.ILifeCircle;
import com.example.myapplication123123.mvp.IMvpView;
import com.example.myapplication123123.mvp.MvpControler;

//提供View和Presenter的接口
public interface ISplashActivityContract {

    //activity的接口
    interface IView extends IMvpView {
        void setSkipTv(String s);
    }

    //逻辑业务的接口
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
