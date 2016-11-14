package com.cokus.fangdouyu.ui.fragment.live.category.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cokus.fangdouyu.R;
import com.cokus.fangdouyu.modle.live.LiveCategory;
import com.cokus.fangdouyu.modle.live.LiveChildCategory;
import com.cokus.fangdouyu.ui.fragment.home.game.GameFragment;
import com.cokus.fangdouyu.ui.fragment.live.room.LiveCategoryRoomFragment;
import com.cokus.fangdouyu.util.DensityUtil;
import com.cokus.fangdouyu.widget.viewpagerindicator.view.indicator.IndicatorViewPager;

/**
 * Created by coku on 16/11/12.
 */
public class LiveCategoryIndicatorViewPagerAdapter extends IndicatorViewPager.IndicatorFragmentPagerAdapter{
    private LiveChildCategory liveChildCategory;
    private Context context;

    public LiveCategoryIndicatorViewPagerAdapter(FragmentManager fragmentManager, Context context, LiveChildCategory liveChildCategory) {
        super(fragmentManager);
        this.context = context;
        this.liveChildCategory = liveChildCategory;
    }

    @Override
    public int getCount() {
        return liveChildCategory.getData().size()>5?5:liveChildCategory.getData().size();
    }

    @Override
    public View getViewForTab(int position, View convertView, ViewGroup container) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.tab_top_bg, container, false);
        }
        TextView textView = (TextView) convertView;
        textView.setText(liveChildCategory.getData().get(position).getTag_name());
        int padding = DensityUtil.dip2px(context,10);
        textView.setPadding(padding, 0, padding, 0);
        return convertView;
    }

    @Override
    public Fragment getFragmentForPage(int position) {
        LiveCategoryRoomFragment fragment = new LiveCategoryRoomFragment();
        fragment.setTagId(liveChildCategory.getData().get(position).getTag_id());
        return fragment;
    }

    @Override
    public int getItemPosition(Object object) {
        //这是ViewPager适配器的特点,有两个值 POSITION_NONE，POSITION_UNCHANGED，默认就是POSITION_UNCHANGED,
        // 表示数据没变化不用更新.notifyDataChange的时候重新调用getViewForPage
        return PagerAdapter.POSITION_NONE;
    }
}
