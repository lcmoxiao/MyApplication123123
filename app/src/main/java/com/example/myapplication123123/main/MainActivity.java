package com.example.myapplication123123.main;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;

import com.example.myapplication123123.base.BaseActivity;
import com.example.myapplication123123.R;
import com.example.myapplication123123.base.MainConstantTool;
import com.example.myapplication123123.base.ViewInject;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import butterknife.BindView;
import butterknife.OnClick;

@ViewInject(main_layout_id = R.layout.activity_main)
public class MainActivity extends BaseActivity implements IMainActivityContract.IView{

    IMainActivityContract.IPresenter mPresenter = new MainActivityPresenter(this);

    @BindView(R.id.fac_main_home)
    FloatingActionButton facMainHome;
    @BindView(R.id.fl_main_home)
    FrameLayout flMainHome;
    @BindView(R.id.SHButton)
    RadioButton SHButton;
    @BindView(R.id.HZButton)
    RadioButton HZButton;
    @BindView(R.id.BJButton)
    RadioButton BJButton;
    @BindView(R.id.SZButton)
    RadioButton SZButton;
    @BindView(R.id.RG1)
    RadioGroup RG1;
    @BindView(R.id.RG2)
    RadioGroup RG2;
    private boolean isCHangingTopOrBottom;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void afterBindView() {
        initHomeFragment();
        changeAnime(RG2,RG1);
        SHButton.setChecked(true);
        BJButton.setChecked(true);
    }

    // 初始化Fragment
    private void initHomeFragment() {
        mPresenter.initHomeFragment();
    }

    @OnClick(R.id.fac_main_home)
    public void onClick(View view) {
        if (view.getId() == R.id.fac_main_home) {
            isCHangingTopOrBottom = !isCHangingTopOrBottom;
            if (isCHangingTopOrBottom) {
                changeAnime(RG1, RG2);
                handleBJSZPosition();
            } else {
                changeAnime(RG2, RG1);
                handleSHHZPosition();
            }
        }
    }

    @OnClick({R.id.SHButton, R.id.HZButton, R.id.BJButton, R.id.SZButton})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.SHButton:
                mPresenter.replaceFragment(MainConstantTool.SHANGHAI);
                break;
            case R.id.HZButton:
                mPresenter.replaceFragment(MainConstantTool.HANGZHOU);
                break;
            case R.id.BJButton:
                mPresenter.replaceFragment(MainConstantTool.BEIJING);
                break;
            case R.id.SZButton:
                mPresenter.replaceFragment(MainConstantTool.SHENZHEN);
                break;
        }
    }

    private void handleSHHZPosition() {
        if(mPresenter.getSHHZPosition() == MainConstantTool.SHANGHAI) {
            mPresenter.replaceFragment(MainConstantTool.SHANGHAI);
            SHButton.setChecked(true);
        }else{
            mPresenter.replaceFragment(MainConstantTool.HANGZHOU);
            HZButton.setChecked(true);
        }
    }

    private void handleBJSZPosition() {
        if(mPresenter.getBJSZPosition() == MainConstantTool.BEIJING) {
            mPresenter.replaceFragment(MainConstantTool.BEIJING);
            BJButton.setChecked(true);
        }else{
            mPresenter.replaceFragment(MainConstantTool.SHENZHEN);
            SZButton.setChecked(true);
        }
    }

    private void changeAnime(RadioGroup gone, RadioGroup show) {
        gone.clearAnimation();
        Animation animationGone = AnimationUtils.loadAnimation(this, R.anim.main_tab_hide);
        gone.startAnimation(animationGone);
        gone.setVisibility(View.GONE);
        show.clearAnimation();
        Animation animationShow = AnimationUtils.loadAnimation(this, R.anim.main_tab_show);
        show.startAnimation(animationShow);
        show.setVisibility(View.VISIBLE);
    }

    @Override
    public void showFragment(Fragment mFragment) {
        getSupportFragmentManager().beginTransaction().show(mFragment).commit();
    }

    @Override
    public void addFragment(Fragment mFragment) {
        getSupportFragmentManager().beginTransaction().add(R.id.Fragment_content,mFragment).commit();
    }

    @Override
    public void hideFragment(Fragment mFragment) {
        getSupportFragmentManager().beginTransaction().hide(mFragment).commit();
    }


}
