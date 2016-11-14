package com.cokus.fangdouyu.di.module;

import android.support.v4.app.Fragment;
import com.cokus.fangdouyu.di.scope.ActivityScope;
import com.cokus.fangdouyu.ui.activity.MainActivity;
import com.cokus.fangdouyu.ui.fragment.concern.UnloginConcernFragment;
import com.cokus.fangdouyu.ui.fragment.home.HomeFragment;
import com.cokus.fangdouyu.ui.fragment.live.LiveFragment;
import com.cokus.fangdouyu.ui.fragment.my.MyFragment;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

/**
 * Created by coku on 16/11/14.
 */
@Module
public class MainActivityModule {

    @Singleton
    @Provides
    Fragment provideHomeFragment(){
        return new HomeFragment();
    }

    @Singleton
    @Provides
    Fragment provideLiveFragment(){
        return new LiveFragment();
    }

    @Singleton
    @Provides
    Fragment provideUnloginConcernFragment(){
        return new UnloginConcernFragment();
    }

    @Singleton
    @Provides
    Fragment provideMyFragment(){
        return new MyFragment();
    }
}
