package com.cokus.fangdouyu.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import butterknife.ButterKnife;

/**
 * Created by coku on 16/11/6.
 */
public abstract class BaseView extends RelativeLayout {
    public BaseView(Context context) {
        super(context);
    }
    public BaseView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews(context);
    }

    public void initViews(Context context){
        inflate(context, getLayoutId(), this);
        ButterKnife.bind(this);
    }

    public abstract int getLayoutId();

}
