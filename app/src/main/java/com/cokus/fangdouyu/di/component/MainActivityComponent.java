package com.cokus.fangdouyu.di.component;

import com.cokus.fangdouyu.di.module.MainActivityModule;
import com.cokus.fangdouyu.ui.activity.MainActivity;

import dagger.Component;

/**
 * Created by coku on 16/11/14.
 */
@Component(modules = MainActivityModule.class)
public interface MainActivityComponent {
    void inject(MainActivity activity);
}
