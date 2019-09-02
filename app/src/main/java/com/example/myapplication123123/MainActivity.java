package com.example.myapplication123123;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import butterknife.BindView;
import butterknife.OnClick;

@ViewInject(main_layout_id = R.layout.activity_main)
public class MainActivity extends BaseActivity {

    @BindView(R.id.fac_main_home)
    FloatingActionButton facMainHome;
    @BindView(R.id.LButton)
    RadioButton LButton;
    @BindView(R.id.RButton)
    RadioButton RButton;
    @BindView(R.id.fl_main_home)
    FrameLayout flMainHome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @OnClick(R.id.fac_main_home)
    public void onClick() {

    }
}
