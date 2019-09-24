package com.example.myapplication123123.main.Fragment.shanghai.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication123123.R;
import com.example.myapplication123123.main.Fragment.shanghai.view.ShangHaiDetailActivity;

import java.util.ArrayList;


public class ShangHaiAdapter extends RecyclerView.Adapter {
    //借ShangHaiBean来进行数据管理
    private final ArrayList<ShangHaiBean> mData;
    // 保存主页Context
    private final Activity mContext;
    private final boolean misHORIZONTAL;
    private final RecyclerView.RecycledViewPool recycledViewPool;


    //初始化主页Context和Adapter的数据
    public ShangHaiAdapter(Activity context, ArrayList<ShangHaiBean> data, boolean isHORIZONTAL)
    {
       recycledViewPool = new  RecyclerView.RecycledViewPool();
        mContext = context;
        mData = data;
        misHORIZONTAL = isHORIZONTAL;
    }

    //Called when RecyclerView needs a new RecyclerView.ViewHolder of the given type to represent an item.
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == ShangHaiBean.IShanghaiItem.VERTICAL) {
            //inflate要根据布局id把这个布局加载成一个View并返回。
            //网上大神有总结：
            //1. 如果root为null，attachToRoot将失去作用，设置任何值都没有意义。
            //2. 如果root不为null，attachToRoot设为true，则会给加载的布局文件的指定一个父布局，即root。
            //3. 如果root不为null，attachToRoot设为false，则会将布局文件最外层的所有layout属性进行设置，当该view被添加到父view当中时，这些layout属性会自动生效。
            //4. 在不设置attachToRoot参数的情况下，如果root不为null，attachToRoot参数默认为true。
            //Here is the third one
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shanghai_fragment_vertical,parent,false);
            //return a ShanghaiViewVerticalHolder bound to item_shanghai_fragment_VERTICAL
            return new ShanghaiViewVerticalHolder(inflate);
        }else if(viewType == ShangHaiBean.IShanghaiItem.HORIZONTAL){
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shanghai_fragment_horizontal,parent,false);
            //return a ShanghaiViewVerticalHolder bound to item_shanghai_fragment_horizontal
            return new ShanghaiViewHorizontalHolder(inflate);
        }
        return null;
    }

    //Called by RecyclerView to display the data at the specified position.
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ShangHaiBean shangHaiBean = mData.get(position);
        if(holder instanceof ShanghaiViewHorizontalHolder) {
            //绑定数据
            ((ShanghaiViewHorizontalHolder) holder).mRecyclerView.setAdapter(new ShangHaiAdapter(mContext, shangHaiBean.getData(),true));
        }
        else if(holder instanceof ShanghaiViewVerticalHolder){
            //垂直方向单项展示数据：文字和图片
            ((ShanghaiViewVerticalHolder) holder).mTv.setText(shangHaiBean.getmDec());
            ((ShanghaiViewVerticalHolder) holder).mIv.setVisibility(shangHaiBean.isShowImg()?View.VISIBLE:View.GONE);
            ((ShanghaiViewVerticalHolder) holder).itemView.setTag(position);
        }
    }

    //获取RecycleView的方向
    @Override
    public int getItemViewType(int position) {
        return mData.get(position).getmItemType();
    }

    //条目RecycleView的数量
    @Override
    public int getItemCount() {
        return mData.size();
    }

    //垂直方向的条目内容：文字，图片
    public class ShanghaiViewVerticalHolder extends RecyclerView.ViewHolder {
        TextView mTv;
        ImageView mIv;
        ShanghaiViewVerticalHolder(@NonNull View itemView) {
            super(itemView);
            mTv = itemView.findViewById(R.id.item_shanghai);
            mIv = itemView.findViewById(R.id.shanghai_img);
            this.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ShangHaiDetailActivity.start_5_0(mContext,mIv);
                }
            });
        }
    }

    //水平方向的条目内容：横向RecyclerView
    public class ShanghaiViewHorizontalHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        ShanghaiViewHorizontalHolder(@NonNull View itemView) {
            super(itemView);
            mRecyclerView = itemView.findViewById(R.id.item_shanghai_horizontal);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false);
            linearLayoutManager.setRecycleChildrenOnDetach(true);
            mRecyclerView.setLayoutManager(linearLayoutManager);
            mRecyclerView.setRecycledViewPool(recycledViewPool);
        }
    }
}
