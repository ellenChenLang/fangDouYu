package com.cokus.fangdouyu.mvp;


public interface  BaseView {
    void onRequestStart();
    void onRequestError(String msg);
    void onRequestEnd();
    void onInternetError();
}
