package com.example.myapplication123123.main.Fragment.shanghai;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication123123.R;
import java.util.ArrayList;


public class ShangHaiAdapter extends RecyclerView.Adapter {
    //借ShangHaiBean来进行数据管理
    private final ArrayList<ShangHaiBean> mData;
    // 保存主页Context
    private final Context mContext;

    //用于初始化主页Context和Adapter要展示的数据
    ShangHaiAdapter(Context context, ArrayList<ShangHaiBean> data)
    {
        mContext = context;
        mData = data;
    }

    //onCreateViewHolder（）方法，负责承载每个子项的布局。
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
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shanghai_fragment,parent,false);
            //return a ShanghaiViewHolder bound to item_shanghai_fragment
            return new ShanghaiViewHolder(inflate);
        }else if(viewType == ShangHaiBean.IShanghaiItem.HORIZONTAL){
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shanghai_fragment_rv,parent,false);
            //return a ShanghaiViewHolder bound to item_shanghai_fragment_rv
            return new ShanghaiViewrvHolder(inflate);
        }
        return null;
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


    //onBindViewHolder()方法，负责将每个子项holder绑定数据。
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ShangHaiBean shangHaiBean = mData.get(position);
        if(holder instanceof ShanghaiViewrvHolder) {
            ((ShanghaiViewrvHolder) holder).mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false));
            ((ShanghaiViewrvHolder) holder).mRecyclerView.setAdapter(new ShangHaiAdapter(mContext, shangHaiBean.getData()));
        }
        else if(holder instanceof ShanghaiViewHolder){
            ((ShanghaiViewHolder) holder).mTv.setText(shangHaiBean.getmDec());
            ((ShanghaiViewHolder) holder).mIv.setVisibility(shangHaiBean.isShowImg()?View.VISIBLE:View.GONE);
        }

    }

    public class ShanghaiViewHolder extends RecyclerView.ViewHolder {
        TextView mTv;
        ImageView mIv;
        ShanghaiViewHolder(@NonNull View itemView) {
            super(itemView);
            mTv = itemView.findViewById(R.id.item_shanghai);
            mIv = itemView.findViewById(R.id.shanghai_img);

        }
    }

    public class ShanghaiViewrvHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        ShanghaiViewrvHolder(@NonNull View itemView) {
            super(itemView);
            mRecyclerView = itemView.findViewById(R.id.item_shanghai_rv);
        }
    }
}
