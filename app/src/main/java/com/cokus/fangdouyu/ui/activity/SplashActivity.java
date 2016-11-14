package com.cokus.fangdouyu.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.cokus.fangdouyu.DYApplication;
import com.cokus.fangdouyu.R;
import com.cokus.fangdouyu.base.BaseActivity;
import com.cokus.fangdouyu.util.ActivityUtils;
import com.cokus.fangdouyu.util.DensityUtil;
import com.jaeger.library.StatusBarUtil;
import java.util.concurrent.TimeUnit;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by coku on 16/10/21.
 */
public class SplashActivity extends BaseActivity{
    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.time)
    TextView timeText;
    private static String AD_URL = "http://staticlive.douyucdn.cn/upload/signs/201610211346076600.jpg";
    Subscriber subscriber;
    Observable observable;
    private int countTime = 7;

    @Override
    protected void loadData() {
        observable = Observable.interval(0, 1, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<Long, Integer>() {
                    @Override
                    public Integer call(Long increaseTime) {
                        return countTime - increaseTime.intValue();
                    }
                })
                .take(countTime + 1);
       subscriber = new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                ActivityUtils.launchActivity(SplashActivity.this,MainActivity.class);
                finish();
            }

            @Override
            public void onError(Throwable e) {

            }
            @Override
            public void onNext(Integer integer) {
                if(integer == 5){
                    img.setVisibility(View.VISIBLE);
                    timeText.setVisibility(View.VISIBLE);
                }
                if(integer<=5){
                    SpannableStringBuilder style = new SpannableStringBuilder("跳过（"+integer+"）");
                    style.setSpan(new ForegroundColorSpan(Color.parseColor("#ffff921b")), 3, 4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    timeText.setText(style);

                }
            }
        };
        observable.subscribe(subscriber);

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_splash;
    }



    @Override
    protected void initView() {
        StatusBarUtil.setTransparentForImageView(this,null);
        DYApplication.glideBitmap.displayAdImage(img,AD_URL, DensityUtil.getScreenHeight(SplashActivity.this));
    }


    @OnClick(R.id.time)
    public void jump(){
        subscriber.unsubscribe();
        ActivityUtils.launchActivity(SplashActivity.this,MainActivity.class);
        finish();
    }


}
