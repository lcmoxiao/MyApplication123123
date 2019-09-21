package com.example.myapplication123123.main.Fragment.shanghai;

import java.util.ArrayList;

public class ShangHaiDataManager {

    private static ArrayList<ShangHaiBean> getVerView(){
        ArrayList<ShangHaiBean> data=new ArrayList<>();
        for(int i = 0 ; i<3;i++)
        {
            data.add((new ShangHaiBean().setmDec("上海欢迎你").setShowImg(true)));
        }
        return  data;
    }

    private static ArrayList<ShangHaiBean> getHorView(){
        ArrayList<ShangHaiBean> data=new ArrayList<>();
        for(int i = 0 ; i<3;i++)
        {
            data.add((new ShangHaiBean().setmDec("上海是魔都").setShowImg(false)));
        }
        return  data;
    }

    //综合界面
    static ArrayList<ShangHaiBean> getData()
    {
        ArrayList<ShangHaiBean> data=new ArrayList<>();
        data.add(new ShangHaiBean().setData(getHorView()).setmItemType(ShangHaiBean.IShanghaiItem.HORIZONTAL));
        data.addAll(getVerView());
        data.add(new ShangHaiBean().setData(getHorView()).setmItemType(ShangHaiBean.IShanghaiItem.HORIZONTAL));
        data.addAll(getVerView());

        return data;
    }

}
