package com.example.myapplication123123.main;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.example.myapplication123123.R;
import com.example.myapplication123123.base.MainConstantTool;
import com.example.myapplication123123.main.Fragment.BeiJingFragment;
import com.example.myapplication123123.main.Fragment.HangZhouFragment;
import com.example.myapplication123123.main.Fragment.shanghai.ShangHaiFragment;
import com.example.myapplication123123.main.Fragment.ShenZhenFragment;
import com.example.myapplication123123.base.BaseMvpPresenter;


//包含对Fragment，Activity绑定的Presenter
public class MainActivityPresenter extends BaseMvpPresenter<IMainActivityContract.IView> implements  IMainActivityContract.IPresenter{

    private Fragment[] mFragments = new Fragment[4];
    //当前显示的Fragment的角标
    private int mCurrentFragmentIndex;
    //当前显示的Button的ID
    private int mCurrentCheckedId;
    private int SHHZPosition;
    private int BJSZPosition;

    //对View层弱绑定
    MainActivityPresenter(IMainActivityContract.IView view) {
        super(view);
    }

    //初始化Fragment
    @Override
    public void initHomeFragment() {
        //初始化角标为SHANGHAI 0
        mCurrentFragmentIndex = 0 ;
        //优先显示上海和杭州
        SHHZPosition = MainConstantTool.SHANGHAI;
        BJSZPosition = MainConstantTool.BEIJING;
        //切换至上海Fragment
        replaceFragment(mCurrentFragmentIndex);
    }

    //切换Fragment的方法
    @Override
    public void replaceFragment(int mCurrentFragmentIndex) {
        //隐藏所有已存在的fragment
        for (Fragment fragment:mFragments)
            if (fragment != null) { hideFragment(fragment); }
        //显示已初始化的fragment，或者初始化fragment并显示，之后记录当前角标
        Fragment mFragment = mFragments[mCurrentFragmentIndex];
        if (mFragment != null) {
            addAndShowFragment(mFragment);
            setCurChecked(mCurrentFragmentIndex);
        } else {
            newCurrentFragment(mCurrentFragmentIndex);
            setCurChecked(mCurrentFragmentIndex);
        }

    }

    // 记录当前 角标，BUTTON的ID，以及用于面板切换的Position记录
    private void setCurChecked(int mCurrentFragmentIndex) {
        this.mCurrentFragmentIndex = mCurrentFragmentIndex;
        switch (mCurrentFragmentIndex) {
            case 0:
                mCurrentCheckedId = R.id.SHButton;
                SHHZPosition = MainConstantTool.SHANGHAI;
                break;
            case 1:
                mCurrentCheckedId = R.id.HZButton;
                SHHZPosition = MainConstantTool.HANGZHOU;
                break;
            case 2:
                mCurrentCheckedId = R.id.BJButton;
                BJSZPosition = MainConstantTool.BEIJING;
                break;
            case 3:
                mCurrentCheckedId = R.id.SZButton;
                BJSZPosition = MainConstantTool.SHENZHEN;
                break;
        }
    }
    //创建 指定角标的 Fragment
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
    public int getCurrentCheckedId() {
        return mCurrentCheckedId;
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

    @Override
    public IMainActivityContract.IView onActivityCreated(Bundle savedInstanceState, Intent intent, Bundle getArguements) {
        return null;
    }
}
