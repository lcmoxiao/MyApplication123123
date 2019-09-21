package com.example.myapplication123123.main.Fragment.shanghai;


import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.myapplication123123.R;
import com.example.myapplication123123.base.BaseFragment;
import com.example.myapplication123123.base.ViewInject;
import com.google.android.material.appbar.AppBarLayout;

import butterknife.BindView;

//通过注释初始化fragment界面
@ViewInject(main_layout_id = R.layout.fragment_shanghai)
public class ShangHaiFragment extends BaseFragment {

    //welcome横幅
    @BindView(R.id.shanghai_welcome_tv)
    TextView shanghaiWelcomeTv;
    //上侧的APPBAR
    @BindView(R.id.shanghai_AB)
    AppBarLayout shanghaiAB;
    //主页中的RecycleView
    @BindView(R.id.mRecycleView)
    RecyclerView mRecycleView;

    @Override
    public void afterBindView() {
        initRecycleView();
        initListen();
    }

    //初始化界面
    private void initRecycleView() {
        //设置主页中的RecycleView的格式
        mRecycleView.setLayoutManager(new LinearLayoutManager(mContext));
        //设置Adapter将主页Context和ShangHaiDataManager的预留界面传入Adapter
        mRecycleView.setAdapter(new ShangHaiAdapter(mContext, ShangHaiDataManager.getData()));
    }

    //设置滑动welcome的可见性
    private void initListen() {
        shanghaiAB.addOnOffsetChangedListener((appBarLayout, i) -> {
            // 未滑出指定长度时不可见
            if (-i < appBarLayout.getMeasuredHeight() / 2) {
                shanghaiWelcomeTv.setVisibility(View.INVISIBLE);
            } else {
                shanghaiWelcomeTv.setVisibility(View.VISIBLE);
            }
        });
    }



}
