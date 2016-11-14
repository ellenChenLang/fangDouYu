package com.cokus.fangdouyu.base;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.cokus.fangdouyu.R;
import com.cokus.fangdouyu.widget.actionbar.ActionBar;
import com.cokus.fangdouyu.widget.viewpagerindicator.fragment.LazyFragment;

import butterknife.ButterKnife;


/**
 * Created by cokus on 2016/5/20.
 */
public abstract class BaseFragment extends LazyFragment {
    public ActionBar actionBar;



    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this, getContentView());
        initView();
        loadData();
    }

    protected   void initActionBar(int actionbarID){
        actionBar = (ActionBar) findViewById(actionbarID);
    }

    protected abstract void initView();
    protected abstract int getLayout();
    protected abstract void loadData();

}
