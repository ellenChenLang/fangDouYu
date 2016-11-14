package com.cokus.fangdouyu.ui.activity;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.cokus.fangdouyu.R;
import com.cokus.fangdouyu.base.BaseActivity;
import com.cokus.fangdouyu.di.component.DaggerMainActivityComponent;
import com.cokus.fangdouyu.ui.fragment.concern.UnloginConcernFragment;
import com.cokus.fangdouyu.ui.fragment.home.game.GameFragment;
import com.cokus.fangdouyu.ui.fragment.home.HomeFragment;
import com.cokus.fangdouyu.ui.fragment.live.LiveFragment;
import com.cokus.fangdouyu.ui.fragment.live.category.LiveChildFragment;
import com.cokus.fangdouyu.ui.fragment.my.MyFragment;
import com.cokus.fangdouyu.widget.viewpagerindicator.view.indicator.FixedIndicatorView;
import com.cokus.fangdouyu.widget.viewpagerindicator.view.indicator.IndicatorViewPager;
import com.cokus.fangdouyu.widget.viewpagerindicator.view.indicator.transition.OnTransitionTextListener;
import com.cokus.fangdouyu.widget.viewpagerindicator.view.viewpager.SViewPager;
import com.jaeger.library.StatusBarUtil;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class MainActivity extends BaseActivity {
    IndicatorViewPager indicatorViewPager;
    @BindView(R.id.tabmain_indicator)
    FixedIndicatorView indicator;
    @BindView(R.id.tabmain_viewPager)
    SViewPager viewPager;
    private boolean isFullScreen =false;
    @Inject
    HomeFragment homeFragment;
    @Inject
    LiveFragment liveFragment;
    @Inject
    UnloginConcernFragment unloginConcernFragment;
    @Inject
    MyFragment myFragment;



    @Override
    protected void loadData() {

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        DaggerMainActivityComponent.create().inject(this);
        StatusBarUtil.setColor(MainActivity.this, Color.parseColor("#00ff921b"),0);
        indicator.setOnTransitionListener(new OnTransitionTextListener().setColor(Color.parseColor("#ffff921b"), Color.GRAY));
        indicatorViewPager = new IndicatorViewPager(indicator, viewPager);
        indicatorViewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        indicatorViewPager.setOnIndicatorPageChangeListener(new IndicatorViewPager.OnIndicatorPageChangeListener() {
            @Override
            public void onIndicatorPageChange(int preItem, int currentItem) {
                switch (currentItem){
                    case 0:
                        if (isFullScreen) {
                            resetFragmentView(fragments.get(currentItem));
                        }
                        StatusBarUtil.setColor(MainActivity.this, Color.parseColor("#00ff921b"),0);
                        break;
                    case 1:
                        if (isFullScreen) {
                            resetFragmentView(fragments.get(currentItem));
                        }
                        StatusBarUtil.setColor(MainActivity.this, Color.parseColor("#00ff921b"),0);
                        break;
                    case 2:
                        if (isFullScreen) {
                            resetFragmentView(fragments.get(currentItem));
                        }
                        StatusBarUtil.setColor(MainActivity.this, Color.parseColor("#00ff921b"),0);
                        break;
                    case 3:
                        isFullScreen = true;
                        StatusBarUtil.setTranslucentForImageViewInFragment(MainActivity.this,0,null);
                        break;
                }
            }
        });
        // 禁止viewpager的滑动事件
        viewPager.setCanScroll(false);
        // 设置viewpager保留界面不重新加载的页面数量
        viewPager.setOffscreenPageLimit(3);
    }


    private List<Fragment> fragments = new ArrayList<>();
    private class MyAdapter extends IndicatorViewPager.IndicatorFragmentPagerAdapter {
        private String[] tabNames = {getResources().getString(R.string.tab1_name), getResources().getString(R.string.tab2_name)
                , getResources().getString(R.string.tab3_name), getResources().getString(R.string.tab4_name)};
        private int[] tabIcons = {R.drawable.home_bg, R.drawable.live_bg, R.drawable.follow_bg,
                R.drawable.user_bg};
        private LayoutInflater inflater;


        public MyAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            inflater = LayoutInflater.from(getApplicationContext());
            fragments.add(homeFragment);
            fragments.add(liveFragment);
            fragments.add(unloginConcernFragment);
            fragments.add(myFragment);
        }

        @Override
        public int getCount() {
            return tabNames.length;
        }

        @Override
        public View getViewForTab(int position, View convertView, ViewGroup container) {
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.tab_main, container, false);
            }
            TextView textView = (TextView) convertView;
            textView.setText(tabNames[position]);
            textView.setCompoundDrawablesWithIntrinsicBounds(0, tabIcons[position], 0, 0);
            return convertView;
        }

        @Override
        public Fragment getFragmentForPage(int position) {
            return fragments.get(position);
        }
    }


    private long mExitTime;
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - mExitTime) > 800) {
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                mExitTime = System.currentTimeMillis();
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

//    // Get the results:
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
//        if(result != null) {
//            if(result.getContents() == null) {
//                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
//            } else {
//                Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
//            }
//        } else {
//            super.onActivityResult(requestCode, resultCode, data);
//        }
//    }


//    ImageView searchImg;
//    ImageView scannerImg;
//    ImageView historyImg;
//
//    @Override
//    public void onCreateCustomToolBar(Toolbar toolbar) {
//        super.onCreateCustomToolBar(toolbar);
//        toolbar.showOverflowMenu();
//        View view = getLayoutInflater().inflate(R.layout.actionbar, toolbar) ;
//        searchImg = ButterKnife.findById(view,R.id.search);
//        scannerImg = ButterKnife.findById(view,R.id.scanner);
//        historyImg = ButterKnife.findById(view,R.id.history);
//    }
//
//    @OnClick({R.id.scanner,R.id.history,R.id.search})
//    public void getView(View view){
//        switch (view.getId()){
//            case  R.id.scanner:
//                new IntentIntegrator(this).initiateScan(); // `this` is the current Activity
//                break;
//            case R.id.search:
//                break;
//            case R.id.history:
//                break;
//        }
//    }
}
