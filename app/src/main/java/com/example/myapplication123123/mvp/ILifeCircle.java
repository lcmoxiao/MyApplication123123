package com.example.myapplication123123.mvp;

import android.content.Intent;
import android.os.Bundle;

public interface ILifeCircle {

    void onCreate(Bundle savedInstanceState, Intent intent,Bundle getArguements);

    void onActivityCreated(Bundle savedInstanceState, Intent intent,Bundle getArguements);

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void onDestroy();

    void destroyView();

    void onViewDestroy();

    void onNewIntent(Intent intent);

    void onActivityResult(int requestCode,int resultCode,Intent data);

    void onSaveInstanceState(Bundle bundle);

    void attachView(IMvpView iMvpView);



}