package com.example.myapplication123123.mvp;

import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication123123.main.IMainActivityContract;

//用于规范化使用的 生命周期
public interface ILifeCircle {

    //前台可见
    void onCreate(Bundle savedInstanceState, Intent intent,Bundle getArguements);

    //当Fragment所在的Activity被启动完成后回调该方法
    IMainActivityContract.IView onActivityCreated(Bundle savedInstanceState, Intent intent, Bundle getArguements);

    //展示
    void onStart();

    //恢复展示
    void onResume();

    //进入堆栈
    void onPause();

    //终止
    void onStop();

    //销毁
    void onDestroy();


    void destroyView();


    void onViewDestroy();

    void onNewIntent(Intent intent);

    void onActivityResult(int requestCode,int resultCode,Intent data);

    void onSaveInstanceState(Bundle bundle);

    void attachView(IMvpView iMvpView);



}
