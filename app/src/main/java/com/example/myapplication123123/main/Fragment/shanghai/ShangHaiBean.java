package com.example.myapplication123123.main.Fragment.shanghai;

import java.util.ArrayList;

//建立可重复使用的套件ShangHaiBean
class ShangHaiBean {
    //用于RecycleView方向的属性
    private int mItemType = IShanghaiItem.VERTICAL;
    //用于RecycleView是否显示图片
    private boolean isShowImg = false;
    //用于RecycleView的文字内容
    private String mDec;
    //用于保存ShangHaiBean的集合
    private ArrayList<ShangHaiBean>data;

    int getmItemType() {
        return mItemType;
    }

    ShangHaiBean setmItemType(int mItemType) {
        this.mItemType = mItemType;
        return this;
    }

    String getmDec() {
        return mDec;
    }

    ShangHaiBean setmDec(String mDec) {
        this.mDec = mDec;
        return this;
    }

    boolean isShowImg() {
        return isShowImg;
    }

    ShangHaiBean setShowImg(boolean isShowImg) {
        this.isShowImg = isShowImg;
        return this;
    }

    ArrayList<ShangHaiBean> getData() {
        return data;
    }

    ShangHaiBean setData(ArrayList<ShangHaiBean> data) {
        this.data = data;
        return this;
    }

    public interface IShanghaiItem{
        int VERTICAL = 0;
        int HORIZONTAL = 1;
    }
}
