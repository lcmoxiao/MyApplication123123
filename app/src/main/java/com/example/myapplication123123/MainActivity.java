package com.example.myapplication123123;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import butterknife.BindView;
import butterknife.OnClick;

@ViewInject(main_layout_id = R.layout.activity_main)
public class MainActivity extends BaseActivity {

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        changeAnime(RG2,RG1);
    }


    @OnClick(R.id.fac_main_home)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fac_main_home:
                isCHangingTopOrBottom = !isCHangingTopOrBottom;
                if (isCHangingTopOrBottom) {
                    changeAnime(RG1,RG2);
                } else {
                    changeAnime(RG2,RG1);
                }
                break;
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
}
