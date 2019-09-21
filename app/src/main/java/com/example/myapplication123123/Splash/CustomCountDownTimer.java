package com.example.myapplication123123.Splash;


import android.os.Handler;

public class CustomCountDownTimer implements Runnable{
    //总倒计时时间
    private int time;
    //当前剩余时间
    private int countDowntime;
    private final Handler handler;
    private boolean isRun;
    //handler外部操作接口
    private final ICountDownHandler Ihandler;

    CustomCountDownTimer(int time, ICountDownHandler Ihandler)
    {
        handler = new Handler();
        this.time=time;
        this.countDowntime=time;
        this.Ihandler =Ihandler;
    }

    //IOC数据回调
    public interface ICountDownHandler
    {
        void onTicker(int time);
        void onFinish();
    }

    @Override
    public void run() {
        if(isRun)
        {
            //存在Ihandler，则Ticker
            if(Ihandler != null)
            {
                Ihandler.onTicker(countDowntime);
            }
            //时间归0，存在Ihandler，则onFinish
            if(countDowntime==0)
            {
                if(Ihandler != null)
                {
                    cancel();
                    Ihandler.onFinish();
                }
            }
            //时间未0，则剩余时间--，延迟一秒继续运行
            else {
                countDowntime--;
                handler.postDelayed(this,1000);
            }
        }
    }

    //进入线程
    void start()
    {
        isRun = true;
        handler.post(this);
    }
    //移除线程
    void cancel()
    {
        isRun = false;
        handler.removeCallbacks(this);
    }

}
