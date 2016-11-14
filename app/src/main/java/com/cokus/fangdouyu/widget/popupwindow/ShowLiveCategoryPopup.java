package com.cokus.fangdouyu.widget.popupwindow;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cokus.fangdouyu.R;
import com.cokus.fangdouyu.base.adapter.BaseQuickAdapter;
import com.cokus.fangdouyu.base.adapter.listener.OnItemClickListener;
import com.cokus.fangdouyu.modle.live.LiveCategory;
import com.cokus.fangdouyu.modle.live.LiveChildCategory;
import com.cokus.fangdouyu.ui.fragment.live.category.adapter.LiveCategoryAdapter;
import com.labo.kaji.relativepopupwindow.RelativePopupWindow;

/**
 * Created by coku on 16/11/14.
 */
public class ShowLiveCategoryPopup extends RelativePopupWindow {
    private  RecyclerView recyclerView;
    public ShowLiveCategoryPopup(Context context, LiveChildCategory liveChildCategory) {
        View view = LayoutInflater.from(context).inflate(R.layout.popup_showlivecategory, null);
        setContentView(view);
        initRecycler(context,view,liveChildCategory);
        setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        setFocusable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        // Disable default animation for circular reveal
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setAnimationStyle(0);
        }
    }

    public  void initRecycler(Context context,View view,LiveChildCategory liveChildCategory){
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(context,3));
        recyclerView.setAdapter(new LiveCategoryAdapter(liveChildCategory.getData()));
        recyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter adapter, View view, int position) {
                if(callback != null)
                    callback.clickPostion(position);
            }
            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });
    }

    private PopupClickPostionCallback callback;
    public  interface  PopupClickPostionCallback{
        void clickPostion(int postion);
    }
    public void setOnItemClick(PopupClickPostionCallback callback){
        this.callback = callback;
    }


    @Override
    public void showOnAnchor(@NonNull View anchor, int vertPos, int horizPos, int x, int y) {
        super.showOnAnchor(anchor, vertPos, horizPos, x, y);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            circularReveal(anchor);
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void circularReveal(@NonNull final View anchor) {
        final View contentView = getContentView();
        contentView.post(new Runnable() {
            @Override
            public void run() {
                final int[] myLocation = new int[2];
                final int[] anchorLocation = new int[2];
                contentView.getLocationOnScreen(myLocation);
                anchor.getLocationOnScreen(anchorLocation);
                final int cx = anchorLocation[0] - myLocation[0] + anchor.getWidth()/2;
                final int cy = anchorLocation[1] - myLocation[1] + anchor.getHeight()/2;

                contentView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
                final int dx = Math.max(cx, contentView.getMeasuredWidth() - cx);
                final int dy = Math.max(cy, contentView.getMeasuredHeight() - cy);
                final float finalRadius = (float) Math.hypot(dx, dy);
//                Animator animator = ViewAnimationUtils.createCircularReveal(contentView, cx, cy, 0f, finalRadius);
//                animator.setDuration(500);
//                animator.start();
            }
        });
    }

}
