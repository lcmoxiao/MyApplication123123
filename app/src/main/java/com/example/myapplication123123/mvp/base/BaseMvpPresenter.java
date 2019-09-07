package com.example.myapplication123123.mvp.base;

import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication123123.mvp.IMvpView;
import com.example.myapplication123123.mvp.presenter.LifeCircleMvpPresenter;

public abstract class BaseMvpPresenter<T extends IMvpView>extends LifeCircleMvpPresenter<T> {

    public BaseMvpPresenter(T view)
    {
        super(view);
    }


    @Override
    protected T getEmptyView() {
        return null;
    }

    @Override
    public void onCreate(Bundle savedInstanceState, Intent intent, Bundle getArguements) {

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


}
