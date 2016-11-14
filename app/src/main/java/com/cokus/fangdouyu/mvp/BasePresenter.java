package com.cokus.fangdouyu.mvp;

import android.content.Context;

import com.cokus.fangdouyu.mvp.rx.RxManager;



public abstract class BasePresenter<M, V> {
    public Context context;
    public M mModel;
    public V mView;
    public RxManager mRxManager = new RxManager();

    public void setVM(V v, M m) {
        this.mView = v;
        this.mModel = m;
    }


    public void onDestroy() {
        mRxManager.clear();
    }
}
