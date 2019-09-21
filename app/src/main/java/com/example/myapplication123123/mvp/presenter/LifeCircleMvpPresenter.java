package com.example.myapplication123123.mvp.presenter;

import com.example.myapplication123123.mvp.ILifeCircle;
import com.example.myapplication123123.mvp.IMvpView;
import com.example.myapplication123123.mvp.MvpControler;

import java.lang.ref.WeakReference;


//最基层的Presenter,对View进行弱引用
public abstract class LifeCircleMvpPresenter<T extends IMvpView> implements ILifeCircle {
    protected WeakReference<T> weakReference;
    protected MvpControler mvpControler;

    public LifeCircleMvpPresenter(IMvpView iMvpView){
        super();
        attachView(iMvpView);
        mvpControler = iMvpView.getMvpControler();
        mvpControler.savePresenter(this);
    }

    protected T getView()
    {
        T view = weakReference != null ? (T)weakReference.get():null;
        if(view == null){
            return getEmptyView();
        }
        return view;
    }

    protected abstract T getEmptyView();

    //对V层进行弱引用
    @Override
    public void attachView(IMvpView iMvpView)
    {
        if(weakReference == null)
        {
            weakReference = new WeakReference(iMvpView);
        }else{
            T view =  weakReference.get();
            if(view != iMvpView)
            {
                weakReference = new WeakReference(iMvpView);
            }
        }
    }

    @Override
    public void onDestroy() {
        weakReference = null;
    }


}
