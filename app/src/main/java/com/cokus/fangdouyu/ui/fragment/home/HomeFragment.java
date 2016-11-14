package com.cokus.fangdouyu.ui.fragment.home;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cokus.fangdouyu.R;
import com.cokus.fangdouyu.base.BaseFragment;
import com.cokus.fangdouyu.ui.fragment.home.game.GameFragment;
import com.cokus.fangdouyu.ui.fragment.home.recommend.RecommendFragment;
import com.cokus.fangdouyu.util.DensityUtil;
import com.cokus.fangdouyu.widget.viewpagerindicator.view.indicator.Indicator;
import com.cokus.fangdouyu.widget.viewpagerindicator.view.indicator.IndicatorViewPager;
import com.cokus.fangdouyu.widget.viewpagerindicator.view.indicator.slidebar.ColorBar;
import com.cokus.fangdouyu.widget.viewpagerindicator.view.indicator.slidebar.LayoutBar;
import com.cokus.fangdouyu.widget.viewpagerindicator.view.indicator.slidebar.ScrollBar;
import com.cokus.fangdouyu.widget.viewpagerindicator.view.indicator.transition.OnTransitionTextListener;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Administrator on 2016/9/8.
 */
public class HomeFragment extends BaseFragment {

    private IndicatorViewPager indicatorViewPager;
    private LayoutInflater inflate;
    private int index;
    private String tabs[] = {"推荐", "游戏", "娱乐", "手游","趣玩"};

    @Inject
    public HomeFragment() {
    }

    @Override
    protected void initActionBar(int actionbarID) {
        super.initActionBar(actionbarID);
        actionBar.isShowBottemLine(false)
                .setBarLeft("",R.drawable.logo_icon,null)
                .setBarRight1("",R.drawable.image_search_normal,null)
                .setBarRight2("",R.drawable.image_scanner_normal,null)
                .setBarRight3("",R.drawable.image_history_normal,null);
    }



    @Override
    protected void initView() {
        initActionBar(R.id.action_bar);
        Bundle bundle = getArguments();
        index = 0;
        ViewPager viewPager = (ViewPager) findViewById(R.id.fragment_tabmain_viewPager);
        Indicator indicator = (Indicator) findViewById(R.id.fragment_tabmain_indicator);

        switch (index) {
            case 0:
                ColorBar line1 = new ColorBar(getApplicationContext(), Color.parseColor("#ffff921b"), 5);
                line1.setWidth(DensityUtil.dip2px(getActivity(), 55));
                line1.setHeight(DensityUtil.dip2px(getActivity(), 3));
                indicator.setScrollBar(line1);
                break;
            case 1:
                indicator.setScrollBar(new ColorBar(getApplicationContext(), Color.parseColor("#ffff921b"), 0, ScrollBar.Gravity.CENTENT_BACKGROUND));
                break;
            case 2:
                indicator.setScrollBar(new ColorBar(getApplicationContext(), Color.parseColor("#ffff921b"), 5, ScrollBar.Gravity.TOP));
                break;
            case 3:
                indicator.setScrollBar(new LayoutBar(getApplicationContext(), R.layout.layout_slidebar, ScrollBar.Gravity.CENTENT_BACKGROUND));
                break;
        }

        float unSelectSize = 15;
        float selectSize = 15;
        int selectColor = Color.parseColor("#ffff921b");
        int unSelectColor = Color.BLACK;
        indicator.setOnTransitionListener(new OnTransitionTextListener().setColor(selectColor, unSelectColor).setSize(selectSize, unSelectSize));
        viewPager.setOffscreenPageLimit(5);
        indicatorViewPager = new IndicatorViewPager(indicator, viewPager);
        inflate = LayoutInflater.from(getApplicationContext());
        // 注意这里 的FragmentManager 是 getChildFragmentManager(); 因为是在Fragment里面
        // 而在activity里面用FragmentManager 是 getSupportFragmentManager()
        indicatorViewPager.setAdapter(new MyAdapter(getChildFragmentManager()));
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_maintab_home;
    }

    @Override
    protected void loadData() {

    }


    private class MyAdapter extends IndicatorViewPager.IndicatorFragmentPagerAdapter {
        private List<Fragment> fragments = new ArrayList<>();
        public MyAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public int getCount() {
            return tabs.length;
        }

        @Override
        public View getViewForTab(int position, View convertView, ViewGroup container) {
            if (convertView == null) {
                convertView = inflate.inflate(R.layout.tab_textview, container, false);
                fragments.add(new RecommendFragment());
                fragments.add(initGameFragment(GameFragment.Game));
                fragments.add(initGameFragment(GameFragment.EnjoyGame));
                fragments.add(initGameFragment(GameFragment.PhoneGame));
                fragments.add(initGameFragment(GameFragment.InterestGame));
            }
            TextView textView = (TextView) convertView;
            textView.setText(tabs[position]);
            return convertView;
        }


        @Override
        public Fragment getFragmentForPage(int position) {
            return fragments.get(position);
        }
    }

    public GameFragment initGameFragment(int type){
        GameFragment game = new GameFragment();
        game.setType(type);
        return  game;
    }
}
