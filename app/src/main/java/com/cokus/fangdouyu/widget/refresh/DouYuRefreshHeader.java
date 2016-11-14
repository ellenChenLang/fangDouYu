package com.cokus.fangdouyu.widget.refresh;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.cokus.fangdouyu.R;
import com.lcodecore.tkrefreshlayout.IHeaderView;
import com.orhanobut.logger.Logger;

/**
 * Created by coku on 16/11/2.
 */
public class DouYuRefreshHeader extends FrameLayout implements IHeaderView {
    private Context context;
    public DouYuRefreshHeader(Context context) {
        super(context);
        this.context = context;
    }

    private View rootView;
    private ImageView loadingView;
    private TextView refreshTextView;
    private AnimationDrawable animationDrawable;

    @Override
    public View getView() {
        return this;
    }

    @Override
    public void onPullingDown(float fraction, float maxHeadHeight, float headHeight) {
        if (fraction < 1f) loadingView.setImageResource(R.drawable.pull_load1);
        if (fraction >= 1f)loadingView.setImageResource(R.drawable.pull_load2);

    }



    @Override
    public void onPullReleasing(float fraction, float maxHeadHeight, float headHeight) {
//        if (fraction < 1f) refreshTextView.setText("下拉刷新");
//        if (fraction > 1f) refreshTextView.setText("松开刷新");
    }

    @Override
    public void startAnim(float maxHeadHeight, float headHeight) {
        loadingView.setBackgroundResource(R.drawable.load_anim);
        animationDrawable = ((AnimationDrawable)loadingView.getBackground());
        animationDrawable.start();
        refreshTextView.setText("正在刷新");
    }

    @Override
    public void onFinish() {
        refreshTextView.setText("下拉刷新");
        if(animationDrawable != null)
        animationDrawable.stop();
        loadingView.setBackgroundResource(0);
        loadingView.setImageResource(R.drawable.pull_load1);
    }


    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        if (rootView == null) {
            rootView = View.inflate(getContext(), R.layout.refresh_head, null);
            refreshTextView = (TextView) rootView.findViewById(R.id.tv);
            loadingView = (ImageView) rootView.findViewById(R.id.iv_loading);
            addView(rootView);
        }
    }
}
