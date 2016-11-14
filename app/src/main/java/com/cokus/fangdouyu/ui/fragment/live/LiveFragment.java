package com.cokus.fangdouyu.ui.fragment.live;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cokus.fangdouyu.R;
import com.cokus.fangdouyu.base.BaseFragment;
import com.cokus.fangdouyu.modle.live.LiveCategory;
import com.cokus.fangdouyu.modle.live.LiveChildCategory;
import com.cokus.fangdouyu.mvp.base.BaseMvpFragment;
import com.cokus.fangdouyu.ui.activity.MainActivity;
import com.cokus.fangdouyu.ui.fragment.home.HomeFragment;
import com.cokus.fangdouyu.ui.fragment.home.game.GameFragment;
import com.cokus.fangdouyu.ui.fragment.home.recommend.RecommendFragment;
import com.cokus.fangdouyu.ui.fragment.live.category.LiveChildFragment;
import com.cokus.fangdouyu.util.DensityUtil;
import com.cokus.fangdouyu.widget.viewpagerindicator.view.indicator.IndicatorViewPager;
import com.cokus.fangdouyu.widget.viewpagerindicator.view.indicator.ScrollIndicatorView;
import com.cokus.fangdouyu.widget.viewpagerindicator.view.indicator.slidebar.ColorBar;
import com.cokus.fangdouyu.widget.viewpagerindicator.view.indicator.slidebar.DrawableBar;
import com.cokus.fangdouyu.widget.viewpagerindicator.view.indicator.slidebar.ScrollBar;
import com.cokus.fangdouyu.widget.viewpagerindicator.view.indicator.transition.OnTransitionTextListener;
import com.cokus.fangdouyu.widget.viewpagerindicator.view.viewpager.SViewPager;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by coku on 16/11/7.
 */
public class LiveFragment extends BaseMvpFragment<LivePresenter,LiveCategoryModel> implements LiveContract.View{
    @BindView(R.id.live_indicator)
    ScrollIndicatorView scrollIndicatorView;
    @BindView(R.id.live_viewPager)
    ViewPager viewPager;

    @Inject
    public LiveFragment() {
    }

    private int unSelectTextColor;
    private IndicatorViewPager indicatorViewPager;
    private LayoutInflater inflate;
    private LiveCategory data;

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_live;
    }

    @Override
    protected void loadData() {
      mPresenter.getDate();
    }

    @Override
    public void getData(LiveCategory data) {
        this.data = data;
        scrollIndicatorView.setBackgroundResource(R.color.orange_color);
        scrollIndicatorView.setScrollBar(new ColorBar(getActivity(), 0xffffffff, 4) );
        unSelectTextColor = 0x99ffffff;
        // 设置滚动监听
        scrollIndicatorView.setOnTransitionListener(new OnTransitionTextListener().setColor(Color.WHITE, unSelectTextColor));
        viewPager.setOffscreenPageLimit(data.getData().size());
        indicatorViewPager = new IndicatorViewPager(scrollIndicatorView, viewPager);
        inflate = LayoutInflater.from(getApplicationContext());
        indicatorViewPager.setAdapter(new MyAdapter(getFragmentManager()));

    }

    private class MyAdapter extends IndicatorViewPager.IndicatorFragmentPagerAdapter {

        public MyAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public int getCount() {
            return data.getData().size();
        }

        @Override
        public View getViewForTab(int position, View convertView, ViewGroup container) {
            if (convertView == null) {
                convertView = LayoutInflater.from(getActivity()).inflate(R.layout.tab_top, container, false);
            }
            TextView textView = (TextView) convertView;
            textView.setText(data.getData().get(position).getCate_name());
            int padding = DensityUtil.dip2px(getActivity(),10);
            textView.setPadding(padding, 0, padding, 0);
            return convertView;
        }

        @Override
        public Fragment getFragmentForPage(int position) {
            LiveChildFragment fragment = new LiveChildFragment();
            fragment.setShortName(data.getData().get(position).getShort_name());
            return fragment;
        }

        @Override
        public int getItemPosition(Object object) {
            //这是ViewPager适配器的特点,有两个值 POSITION_NONE，POSITION_UNCHANGED，默认就是POSITION_UNCHANGED,
            // 表示数据没变化不用更新.notifyDataChange的时候重新调用getViewForPage
            return PagerAdapter.POSITION_NONE;
        }

    }


}
