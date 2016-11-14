package com.cokus.fangdouyu.widget.actionbar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.cokus.fangdouyu.R;

import butterknife.BindView;

/**
 * Created by coku on 16/11/6.
 */
public class ActionBar extends BaseActionBar {
    @BindView(R.id.bar_title_center)
    TextView bar_center;
    @BindView(R.id.bar_title_left)
    TextView bar_left;
    @BindView(R.id.bar_title_right_1)
    TextView bar_right_1;
    @BindView(R.id.bar_title_right_2)
    TextView bar_right_2;
    @BindView(R.id.bar_title_right_3)
    TextView bar_right_3;
    @BindView(R.id.bar_line)
    ImageView bar_line;
    private Context context;

    public ActionBar(Context context) {
        super(context);
        this.context = context;
    }

    public ActionBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    @Override
    public int getLayoutId() {
        return R.layout.actionbar_layout;
    }

    public ActionBar setBarCenter(String content, int res, View.OnClickListener onClickListener){
       initTextView(bar_center,content,res,onClickListener);
        return  this;
    }

    public ActionBar setBarLeft(String content, int res, View.OnClickListener onClickListener){
        initTextView(bar_left,content,res,onClickListener);
        return  this;
    }

    public ActionBar setBarRight1(String content, int res, View.OnClickListener onClickListener){
        initTextView(bar_right_1,content,res,onClickListener);
        return  this;

    }

    public ActionBar setBarRight2(String content, int res, View.OnClickListener onClickListener){
        initTextView(bar_right_2,content,res,onClickListener);
        return  this;
    }

    public ActionBar setBarRight3(String content, int res, View.OnClickListener onClickListener){
        initTextView(bar_right_3,content,res,onClickListener);
        return  this;
    }

    public ActionBar isShowBottemLine(boolean isShow){
        if(isShow){
            bar_line.setVisibility(VISIBLE);
        }else{
            bar_line.setVisibility(GONE);
        }
        return  this;

    }

    void initTextView(TextView textView,String content, int res, View.OnClickListener onClickListener){
        Drawable drawable = null;
        try {
            drawable = ContextCompat.getDrawable(context, res);
        } catch (Resources.NotFoundException exception) {
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            textView.setCompoundDrawables(drawable, null, null, null);
        }
        textView.setText(content);
        textView.setVisibility(View.VISIBLE);
        textView.setOnClickListener(onClickListener);
    }

}
