package com.example.myapplication123123.mvp;

import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication123123.main.IMainActivityContract;

import java.util.HashSet;
import java.util.Set;

//综合控制器，控制自己的一堆lifeCircles的状态。
public class MvpControler implements ILifeCircle {

    private Set<ILifeCircle> lifeCircles =  new HashSet<>();

    public static MvpControler newInstance(){
        return new MvpControler();
    }

    //添加一个新的控制把柄
    public void savePresenter(ILifeCircle lifeCircle) {
        lifeCircles.add(lifeCircle);
    }

    @Override
    public void onCreate(Bundle savedInstanceState, Intent intent, Bundle getArguements) {
        for (ILifeCircle nextLifeCircle : lifeCircles) {
            if (intent == null) {
                intent = new Intent();
            }
            if (getArguements == null) {
                getArguements = new Bundle();
            }
            nextLifeCircle.onCreate(savedInstanceState, intent, getArguements);
        }
    }

    public IMainActivityContract.IView onActivityCreated(Bundle savedInstanceState, Intent extras, Bundle getArguements) {
        for (ILifeCircle presenter : lifeCircles) {
            if (extras == null) {
                extras = new Intent();
            }
            if (getArguements == null) {
                getArguements = new Bundle();
            }
            presenter.onActivityCreated(savedInstanceState, extras, getArguements);
        }
        return null;
    }

    @Override
    public void onStart() {
        for (ILifeCircle presenter : lifeCircles) {
            presenter.onStart();
        }
    }

    @Override
    public void onResume() {
        for (ILifeCircle presenter : lifeCircles) {
            presenter.onResume();
        }
    }

    @Override
    public void onPause() {
        for (ILifeCircle presenter : lifeCircles) {
            presenter.onPause();
        }
    }

    @Override
    public void onStop() {
        for (ILifeCircle presenter : lifeCircles) {
            presenter.onStop();
        }
    }

    @Override
    public void onDestroy() {
        for (ILifeCircle presenter : lifeCircles) {
            presenter.onDestroy();
        }
    }

    @Override
    public void destroyView() {
        for (ILifeCircle presenter : lifeCircles) {
            presenter.destroyView();
        }
    }

    @Override
    public void onViewDestroy() {
        for (ILifeCircle presenter : lifeCircles) {
            presenter.onViewDestroy();
        }
    }

    @Override
    public void onNewIntent(Intent intent) {
        for (ILifeCircle presenter : lifeCircles) {
            presenter.onNewIntent(intent);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        for (ILifeCircle presenter : lifeCircles) {
            presenter.onActivityResult(requestCode,resultCode,data);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle bundle) {
        for (ILifeCircle presenter : lifeCircles) {
            presenter.onSaveInstanceState(bundle);
        }
    }

    @Override
    public void attachView(IMvpView iMvpView) {
        for (ILifeCircle presenter : lifeCircles) {
            presenter.attachView(iMvpView);
        }
    }

}
