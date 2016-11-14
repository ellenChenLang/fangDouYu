package com.cokus.fangdouyu.ui.fragment.live.category;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.cokus.fangdouyu.R;
import com.cokus.fangdouyu.modle.live.LiveCategory;
import com.cokus.fangdouyu.modle.live.LiveChildCategory;
import com.cokus.fangdouyu.mvp.base.BaseMvpFragment;
import com.cokus.fangdouyu.ui.fragment.live.category.adapter.LiveCategoryIndicatorViewPagerAdapter;
import com.cokus.fangdouyu.util.DensityUtil;
import com.cokus.fangdouyu.util.ToastUtils;
import com.cokus.fangdouyu.widget.popupwindow.ShowLiveCategoryPopup;
import com.cokus.fangdouyu.widget.viewpagerindicator.view.indicator.IndicatorViewPager;
import com.cokus.fangdouyu.widget.viewpagerindicator.view.indicator.ScrollIndicatorView;
import com.cokus.fangdouyu.widget.viewpagerindicator.view.indicator.slidebar.DrawableBar;
import com.cokus.fangdouyu.widget.viewpagerindicator.view.indicator.slidebar.ScrollBar;
import com.cokus.fangdouyu.widget.viewpagerindicator.view.indicator.transition.OnTransitionTextListener;
import com.cokus.fangdouyu.widget.viewpagerindicator.view.viewpager.SViewPager;
import com.labo.kaji.relativepopupwindow.RelativePopupWindow;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by coku on 16/11/12.
 */
public class LiveChildFragment extends BaseMvpFragment<LiveChildPresenter,LiveChildCategoryModel> implements LiveChildCategoryContract.View {
    @BindView(R.id.live_indicator)
    ScrollIndicatorView scrollIndicatorView;
    @BindView(R.id.live_viewPager)
    SViewPager viewPager;
    @BindView(R.id.topview)
    View topView;
    @BindView(R.id.select_type_img)
    ImageView selectTypeImg;

    private int unSelectTextColor;
    private IndicatorViewPager indicatorViewPager;
    private LayoutInflater inflate;
    private LiveChildCategory data;

    private LiveChildCategory adapteData;

    private String shortName;

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Override
    protected void initView() {

    }

    ShowLiveCategoryPopup popup;
    @OnClick(R.id.select_type_img)
    public  void click(){
        popup = new ShowLiveCategoryPopup(getActivity(),data);
        popup.setOnItemClick(new ShowLiveCategoryPopup.PopupClickPostionCallback() {
            @Override
            public void clickPostion(int postion) {
                LiveChildCategory.DataBean dataBean = adapteData.getData().get(postion);
                adapteData.getData().remove(postion);
                adapteData.getData().add(0,dataBean);
                indicatorViewPager.setCurrentItem(0,false);
                indicatorViewPager.setAdapter(new LiveCategoryIndicatorViewPagerAdapter(getChildFragmentManager(),getActivity(),adapteData));
                popup.dismiss();
            }
        });
        popup.showOnAnchor(topView, RelativePopupWindow.VerticalPosition.BELOW, RelativePopupWindow.HorizontalPosition.RIGHT);
    }


    @Override
    protected int getLayout() {
        return R.layout.fragment_live_child;
    }

    @Override
    protected void loadData() {
        mPresenter.getDate(shortName);
    }

    @Override
    public void getChildCategory(LiveChildCategory data) {
        this.data = data;
        adapteData = data;
        if(data.getData()==null||data.getData().size()==1){
            topView.setVisibility(View.GONE);
        }else{
            topView.setVisibility(View.VISIBLE);
        }
        scrollIndicatorView.setBackgroundResource(R.color.colorwhite);
        scrollIndicatorView.setScrollBar(new DrawableBar(getActivity(), R.drawable.round_border_white_selector, ScrollBar.Gravity.CENTENT) {
            @Override
            public int getHeight(int tabHeight) {
                return tabHeight - DensityUtil.dip2px(getActivity(),10);
            }

            @Override
            public int getWidth(int tabWidth) {
                return tabWidth - DensityUtil.dip2px(getActivity(),10);
            }
        });
        unSelectTextColor = Color.parseColor("#cccccc");
        // 设置滚动监听
        scrollIndicatorView.setOnTransitionListener(new OnTransitionTextListener().setColor(Color.parseColor("#ffff921b"), unSelectTextColor));
        viewPager.setCanScroll(true);
        viewPager.setOffscreenPageLimit(5);
        indicatorViewPager = new IndicatorViewPager(scrollIndicatorView, viewPager);
        indicatorViewPager.setAdapter(new LiveCategoryIndicatorViewPagerAdapter(getChildFragmentManager(),getActivity(),adapteData));
    }



    @Override
    public void onRequestStart() {

    }

    @Override
    public void onRequestEnd() {

    }
}
