package com.example.myapplication123123.mvp.view;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication123123.mvp.IMvpView;
import com.example.myapplication123123.mvp.MvpControler;

//最基层的Fragment
public class LifeCircleMvpFragment extends Fragment implements IMvpView {

    private MvpControler mvpControler;

    //绑定presenter
    @Override
    public MvpControler getMvpControler() {
        if(this.mvpControler == null )
            this.mvpControler = new MvpControler();
        return this.mvpControler;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        if(bundle == null)
        {
            bundle = new Bundle();
        }
        MvpControler mvpControler = this.getMvpControler();
        if(mvpControler != null)
        {
            mvpControler.onCreate(savedInstanceState,null,bundle);
            mvpControler.onActivityCreated(savedInstanceState,null,bundle);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        MvpControler mvpControler = this.getMvpControler();
        Bundle bundle = this.getArguments();
        if(bundle == null)
        {
            bundle = new Bundle();
        }
        if(mvpControler != null)
        {
            mvpControler.onActivityCreated(savedInstanceState,null,bundle);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        MvpControler mvpControler = this.getMvpControler();
        if(mvpControler != null)
        {
            mvpControler.onViewDestroy();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        MvpControler mvpControler = this.getMvpControler();
        if(mvpControler != null)
        {
            mvpControler.onStart();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        MvpControler mvpControler = this.getMvpControler();
        if(mvpControler != null)
        {
            mvpControler.onResume();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        MvpControler mvpControler = this.getMvpControler();
        if(mvpControler != null)
        {
            mvpControler.onPause();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        MvpControler mvpControler = this.getMvpControler();
        if(mvpControler != null)
        {
            mvpControler.onStop();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        MvpControler mvpControler = this.getMvpControler();
        if(mvpControler != null)
        {
            mvpControler.onDestroy();
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        MvpControler mvpControler = this.getMvpControler();
        if(mvpControler != null)
        {
            mvpControler.onSaveInstanceState(savedInstanceState);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        MvpControler mvpControler = this.getMvpControler();
        if(mvpControler != null)
        {
            mvpControler.onActivityResult(requestCode,resultCode,data);
        }
    }

}
