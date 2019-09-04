package com.example.myapplication123123.mvp;

import android.content.Intent;
import android.os.Bundle;

import java.util.HashSet;
import java.util.Set;

public class MvpControler implements ILifeCircle {

    private Set<ILifeCircle> lifeCircles =  new HashSet<>();

    public static MvpControler newInstance(){
        return new MvpControler();
    }


    @Override
    public void onCreate(Bundle savedInstanceState, Intent intent, Bundle getArguements) {

    }



    public void onActivityCreated(Bundle savedInstanceState, Intent intent, Bundle getArguements) {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void destroyView() {

    }

    @Override
    public void onViewDestroy() {

    }

    @Override
    public void onNewIntent(Intent intent) {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

    @Override
    public void onSaveInstanceState(Bundle bundle) {

    }

    @Override
    public void attachView(IMvpView iMvpView) {

    }
}
