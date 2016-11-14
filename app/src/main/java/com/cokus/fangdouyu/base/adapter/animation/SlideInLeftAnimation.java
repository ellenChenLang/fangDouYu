package com.cokus.fangdouyu.base.adapter.animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;


/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
public class SlideInLeftAnimation implements BaseAnimation {

  @TargetApi(Build.VERSION_CODES.HONEYCOMB)
  @Override
  public Animator[] getAnimators(View view) {
    return new Animator[] {
        ObjectAnimator.ofFloat(view, "translationX", -view.getRootView().getWidth(), 0)
    };
  }
}
