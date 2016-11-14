package com.cokus.fangdouyu.widget.refresh;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.cokus.fangdouyu.R;
import com.lcodecore.tkrefreshlayout.IBottomView;
import com.lcodecore.tkrefreshlayout.IHeaderView;

/**
 * Created by coku on 16/11/2.
 */
public class DouYuRefreshEmptyBottem extends FrameLayout implements IBottomView {
    private Context context;
    public DouYuRefreshEmptyBottem(Context context) {
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
    public void onPullingUp(float fraction, float maxHeadHeight, float headHeight) {

    }

    @Override
    public void startAnim(float maxHeadHeight, float headHeight) {

    }

    @Override
    public void onPullReleasing(float fraction, float maxHeadHeight, float headHeight) {

    }

    @Override
    public void onFinish() {

    }


    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (rootView == null) {
            rootView = View.inflate(getContext(), R.layout.refresh_bottem, null);
            addView(rootView);
        }
    }
}
