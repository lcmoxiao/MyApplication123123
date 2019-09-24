package com.example.myapplication123123.main.Fragment.shanghai.view;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;

import com.example.myapplication123123.R;
import com.example.myapplication123123.base.BaseActivity;
import com.example.myapplication123123.base.ViewInject;

import butterknife.BindView;



@ViewInject(main_layout_id = R.layout.activity_shanghai_detail)
public class ShangHaiDetailActivity extends BaseActivity {

    public static String mActivityOptionsCompat = "ShangHaiDetailActivity";

    @BindView(R.id.iv_shanghai_detail)
    ImageView ivShanghaiDetail;

    @Override
    public void afterBindView() {
        //开启转场动画
        startPostponedEnterTransition();
    }

    //用于安卓5.0以上的转场动画
    public static void start_5_0(Activity activity, View view){
        Intent intent = new Intent(activity, ShangHaiDetailActivity.class);
        Pair pair = new Pair<>(view, mActivityOptionsCompat);
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(activity,pair);
        ActivityCompat.startActivity(activity,intent ,optionsCompat.toBundle());
    }
}
