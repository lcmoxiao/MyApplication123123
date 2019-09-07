package com.example.myapplication123123.mvp;

import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication123123.main.IMainActivityContract;

import java.util.HashSet;
import java.util.Set;

public class MvpControler implements ILifeCircle {

    private Set<ILifeCircle> lifeCircles =  new HashSet<>();

    public static MvpControler newInstance(){
        return new MvpControler();
    }


    @Override
    public void onCreate(Bundle savedInstanceState, Intent intent, Bundle getArguements) {
        for (ILifeCircle next : this.lifeCircles) {
            if (intent == null) {
                intent = new Intent();
            }
            if (getArguements == null) {
                getArguements = new Bundle();
            }
            next.onCreate(savedInstanceState, intent, getArguements);
        }
    }



    public IMainActivityContract.IView onActivityCreated(Bundle savedInstanceState, Intent extras, Bundle getArguements) {
        for (ILifeCircle presenter : this.lifeCircles) {
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
        for (ILifeCircle presenter : this.lifeCircles) {
            presenter.onStart();
        }
    }

    @Override
    public void onResume() {
        for (ILifeCircle presenter : this.lifeCircles) {
            presenter.onResume();
        }
    }

    @Override
    public void onPause() {
        for (ILifeCircle presenter : this.lifeCircles) {
            presenter.onPause();
        }
    }

    @Override
    public void onStop() {
        for (ILifeCircle presenter : this.lifeCircles) {
            presenter.onStop();
        }
    }

    @Override
    public void onDestroy() {
        for (ILifeCircle presenter : this.lifeCircles) {
            presenter.onDestroy();
        }
    }

    @Override
    public void destroyView() {
        for (ILifeCircle presenter : this.lifeCircles) {
            presenter.destroyView();
        }
    }

    @Override
    public void onViewDestroy() {
        for (ILifeCircle presenter : this.lifeCircles) {
            presenter.onViewDestroy();
        }
    }

    @Override
    public void onNewIntent(Intent intent) {
        for (ILifeCircle presenter : this.lifeCircles) {
            presenter.onNewIntent(intent);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        for (ILifeCircle presenter : this.lifeCircles) {
            presenter.onActivityResult(requestCode,resultCode,data);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle bundle) {
        for (ILifeCircle presenter : this.lifeCircles) {
            presenter.onSaveInstanceState(bundle);
        }
    }

    @Override
    public void attachView(IMvpView iMvpView) {
        for (ILifeCircle presenter : this.lifeCircles) {
            presenter.attachView(iMvpView);
        }
    }

    public void savePresenter(ILifeCircle lifeCircle) {
        this.lifeCircles.add(lifeCircle);
    }
}
