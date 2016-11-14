package com.cokus.fangdouyu;

import android.app.Application;
import android.content.Context;

import com.cokus.fangdouyu.global.Constants;
import com.cokus.fangdouyu.util.glide.GlideBitmap;
import com.github.moduth.blockcanary.BlockCanary;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by coku on 16/10/21.
 */
public class DYApplication extends Application {
    public static GlideBitmap glideBitmap;
    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        if(Constants.isDebug) {
            if (LeakCanary.isInAnalyzerProcess(this)) {
                // This process is dedicated to LeakCanary for heap analysis.
                // You should not init your app in this process.
                return;
            }
            LeakCanary.install(this);
            BlockCanary.install(this, new AppContext()).start();
        }
        init();


    }

    private void init(){
        sContext = getApplicationContext();
        glideBitmap = GlideBitmap.create(getApplicationContext());
    }


    public static Context getAppContext() {
        return sContext;
    }
}
