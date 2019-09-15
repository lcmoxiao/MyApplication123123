package com.example.myapplication123123.main;

import androidx.fragment.app.Fragment;

import com.example.myapplication123123.mvp.ILifeCircle;
import com.example.myapplication123123.mvp.IMvpView;
import com.example.myapplication123123.mvp.MvpControler;


//
public interface IMainActivityContract {

    interface IView extends IMvpView {

        void showFragment(Fragment mFragment);

        void addFragment(Fragment mFragment);

        void hideFragment(Fragment mFragment);

    }

    interface  IPresenter extends ILifeCircle {

        int getSHHZPosition();

        int getBJSZPosition();

        int getCurrentCheckedId();

        void initHomeFragment();

        int getCurrentCheckedIndex();

        void replaceFragment(int mCurrentFragmentIndex);

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
