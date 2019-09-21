package com.example.myapplication123123.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication123123.mvp.view.LifeCircleMvpFragment;

import butterknife.ButterKnife;


//实现ViewInject注释，进行Fragment的初始化,并传输Context
public abstract class BaseFragment extends LifeCircleMvpFragment {

    //Interface to global information about an application environment.
    protected Context mContext;

    @Override
    public void onAttach(Context context) {
        //Called when a fragment is first attached to its context.
        super.onAttach(context);
        this.mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView;
        ViewInject annotation = this.getClass().getAnnotation(ViewInject.class);
        if (annotation != null) {
            int main_layout_id = annotation.main_layout_id();
            if (main_layout_id > 0) {
                mView = initFragmentView(inflater,main_layout_id);
                bindView(mView);
                afterBindView();
            } else {
                throw new RuntimeException("main_layout_id < 0");
            }
        } else {
            throw new RuntimeException("annotation  = null");
        }
        return mView;
    }

    private View initFragmentView(LayoutInflater inflater,int main_layout_id) {
        //Inflate a new view hierarchy from the specified xml resource.
        return inflater.inflate(main_layout_id, null);
    }

    public abstract void afterBindView();

    // View 的依赖注入绑定
    private void bindView(View mView) {
        ButterKnife.bind(this,mView);
    }
}
