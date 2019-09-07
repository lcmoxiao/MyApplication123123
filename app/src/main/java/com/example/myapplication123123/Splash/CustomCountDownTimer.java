package com.example.myapplication123123.Splash;


import android.os.Handler;

public class CustomCountDownTimer implements Runnable{
    private int time;
    private int countDowntime;
    private final ICountDownHandler Ihandler;
    private final Handler handler;
    private boolean isRun;


    //IOC数据回调
    public interface ICountDownHandler
    {
        void onTicker(int time);
        void onFinish();
    }



    public  CustomCountDownTimer (int time ,ICountDownHandler Ihandler)
    {
        handler = new Handler();
        this.countDowntime=time;
        this.time=time;
        this.Ihandler =Ihandler;
    }

    @Override
    public void run() {
        if(isRun)
        {
            if(Ihandler != null)
            {
                Ihandler.onTicker(countDowntime);
            }
            if(countDowntime==0)
            {
                if(Ihandler != null)
                {
                    cancel();
                    Ihandler.onFinish();
                }
            }
            else {
                countDowntime = time--;
                handler.postDelayed(this,1000);
            }
        }
    }

    public void start()
    {
        isRun = true;
        handler.post(this);
    }

    public void cancel()
    {
        isRun = false;
        handler.removeCallbacks(this);
    }







}
