package com.example.myapplication123123.main;

import androidx.fragment.app.Fragment;

import com.example.myapplication123123.mvp.ILifeCircle;
import com.example.myapplication123123.mvp.IMvpView;
import com.example.myapplication123123.mvp.MvpControler;


//Activity规范化接口
public interface IMainActivityContract {

    //继承了MvpControler
    interface IView extends IMvpView {

        void showFragment(Fragment mFragment);

        void addFragment(Fragment mFragment);

        void hideFragment(Fragment mFragment);

    }

    //继承了一大堆Activity的生命周期函数
    interface  IPresenter extends ILifeCircle {

        int getSHHZPosition();

        int getBJSZPosition();

        void replaceFragment(int mCurrentFragmentIndex);

        void initHomeFragment();

        int getCurrentCheckedId();

        int getCurrentCheckedIndex();

    }

    IView emptyView = new IView() {

        @Override
        public MvpControler getMvpControler() {
            return null;
        }

        @Override
        public void showFragment(Fragment mFragment) {

        }

        @Override
        public void addFragment(Fragment mFragment) {

        }

        @Override
        public void hideFragment(Fragment mFragment) {

        }


    };
}
