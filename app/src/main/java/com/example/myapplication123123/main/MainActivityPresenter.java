package com.example.myapplication123123.main;



import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.example.myapplication123123.R;
import com.example.myapplication123123.main.Fragment.BeiJingFragment;
import com.example.myapplication123123.main.Fragment.HangZhouFragment;
import com.example.myapplication123123.main.Fragment.ShangHaiFragment;
import com.example.myapplication123123.main.Fragment.ShenZhenFragment;
import com.example.myapplication123123.mvp.base.BaseMvpPresenter;

public class MainActivityPresenter extends BaseMvpPresenter<IMainActivityContract.IView> implements  IMainActivityContract.IPresenter{

    private int mCurrentFragmentIndex;
    private Fragment[] mFragments = new Fragment[4];
    private int mCurrentCheckedId;
    private int SHHZPosition;
    private int BJSZPosition;

    public MainActivityPresenter(IMainActivityContract.IView view) {
        super(view);
    }

    @Override
    public void initHomeFragment() {
        mCurrentFragmentIndex = 0 ;
        replaceFragment(mCurrentFragmentIndex);
    }

    @Override
    public int getCurrentCheckedId() {
        return mCurrentCheckedId;
    }

    //切换Fragment的方法
    @Override
    public void replaceFragment(int mCurrentFragmentIndex) {

        for (Fragment fragment:mFragments)
            if (fragment != null) { hideFragment(fragment); }

        Fragment mFragment = mFragments[mCurrentFragmentIndex];
        if (mFragment != null) {
            addAndShowFragment(mFragment);
            setCurChecked(mCurrentFragmentIndex);
        } else {
            newCurrentFragment(mCurrentFragmentIndex);
            setCurChecked(mCurrentFragmentIndex);
        }

    }

    // 记录当前 角标
    private void setCurChecked(int mCurrentFragmentIndex) {
        this.mCurrentFragmentIndex = mCurrentFragmentIndex;
        switch (mCurrentFragmentIndex) {
            case 0:
                mCurrentCheckedId = R.id.SHButton;
                SHHZPosition = MainConstantTool.BEIJING;
                break;
            case 1:
                mCurrentCheckedId = R.id.HZButton;
                SHHZPosition = MainConstantTool.HANGZHOU;
                break;
            case 2:
                mCurrentCheckedId = MainConstantTool.BEIJING;
                BJSZPosition = 2;
                break;
            case 3:
                mCurrentCheckedId = MainConstantTool.SHENZHEN;
                BJSZPosition = 3;
                break;
        }
    }

    @Override
    public int getCurrentCheckedIndex() {
        return mCurrentFragmentIndex;
    }

    @Override
    public int getSHHZPosition() {
        return SHHZPosition;
    }

    @Override
    public int getBJSZPosition() {
        return BJSZPosition;
    }

    //创建 当前 Fragment
    private void newCurrentFragment(int mCurrentFragmentIndex) {
        Fragment fragment = null;
        switch (mCurrentFragmentIndex) {
            case 0:
                fragment = new ShangHaiFragment();
                break;
            case 1:
                fragment = new HangZhouFragment();
                break;
            case 2:
                fragment = new BeiJingFragment();
                break;
            case 3:
                fragment = new ShenZhenFragment();
                break;
        }
        mFragments[mCurrentFragmentIndex] = fragment;
        addAndShowFragment(fragment);
    }

    // 显示 Fragment
    private void addAndShowFragment(Fragment mFragment) {
        if (mFragment.isAdded()) {
            getView().showFragment(mFragment);
        } else {
            getView().addFragment(mFragment);
        }
    }

    // 隐藏Fragment
    private void hideFragment(Fragment mFragment) {
        if (mFragment != null && mFragment.isVisible()) {
            getView().hideFragment(mFragment);
        }
    }


    @Override
    public IMainActivityContract.IView onActivityCreated(Bundle savedInstanceState, Intent intent, Bundle getArguements) {
        return null;
    }
}
