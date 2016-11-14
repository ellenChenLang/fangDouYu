package com.cokus.fangdouyu.ui.fragment.home.recommend;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.cokus.fangdouyu.R;
import com.cokus.fangdouyu.modle.recommend.RecommendData;
import com.cokus.fangdouyu.mvp.base.BaseMvpFragment;
import com.cokus.fangdouyu.ui.fragment.home.recommend.adapter.CategoryAdapter;
import com.cokus.fangdouyu.ui.fragment.home.recommend.adapter.RecommendAdapter;
import com.cokus.fangdouyu.ui.fragment.home.recommend.adapter.RecommendIndicatorViewPagerAdapter;
import com.cokus.fangdouyu.widget.MultiStateView;
import com.cokus.fangdouyu.widget.refresh.DouYuRefreshEmptyBottem;
import com.cokus.fangdouyu.widget.refresh.DouYuRefreshHeader;
import com.cokus.fangdouyu.widget.viewpagerindicator.view.indicator.BannerComponent;
import com.cokus.fangdouyu.widget.viewpagerindicator.view.indicator.Indicator;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import butterknife.BindView;

/**
 * Created by coku on 16/10/24.
 */
public class RecommendFragment extends BaseMvpFragment<RecommendFragmentPresenter,RecommendChannelModel> implements RecommentContract.View{
    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerView;
    @BindView(R.id.refreshLayout)
    TwinklingRefreshLayout refreshLayout;
    @BindView(R.id.multistateview)
    MultiStateView multiStateView;

    RecommendData recommendData;
    RecommendAdapter recommendAdapter;
    CategoryAdapter categoryAdapter;
    RecommendIndicatorViewPagerAdapter recommendIndicatorViewPagerAdapter;

    @Override
    public void getData(RecommendData recommendData) {
        this.recommendData = recommendData;
        initHead();//初始化头部布局
        initRecyclcer();
    }


    @Override
    public void onRequestStart() {
        if(recommendAdapter == null || recommendAdapter.getItemCount() == 0)
        multiStateView.setViewState(MultiStateView.STATE_LOADING);
    }


    @Override
    public void onRequestEnd() {
        multiStateView.setViewState(MultiStateView.STATE_CONTENT);
    }

    @Override
    public void onRequestError(String msg) {
        multiStateView.setViewState(MultiStateView.STATE_ERROR);
    }

    @Override
    protected void loadData() {
        mPresenter.getData();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_recomment;
    }

    @Override
    protected void initView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        refreshLayout.setHeaderView(new DouYuRefreshHeader(getActivity()));
        refreshLayout.setBottomView(new DouYuRefreshEmptyBottem(getActivity()));
        refreshLayout.setOnRefreshListener(new TwinklingRefreshLayout.OnRefreshListener(){
            @Override
            public void onRefresh(TwinklingRefreshLayout refreshLayout) {
                super.onRefresh(refreshLayout);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mPresenter.getData();
                    }
                },1000);
            }
        });
        multiStateView.setOnRetryClickListener(new MultiStateView.OnRetryClickListener() {
            @Override
            public void onRetry() {
                mPresenter.getData();
            }
        });
    }


    private View headView;
    private ViewPager bannerViewPager;
    private Indicator indicator;
    private BannerComponent bannerComponent;
    private RecyclerView bannerRecyclerView;
    public  void  initHead(){
        LayoutInflater inflate = LayoutInflater.from(getActivity());
        headView = inflate.inflate(R.layout.head_recommend_fragment, null, false);
        bannerViewPager = (ViewPager) headView.findViewById(R.id.banner_hot_viewPager);
        indicator = (Indicator) headView.findViewById(R.id.banner_hot_indicator);
        bannerRecyclerView = (RecyclerView) headView.findViewById(R.id.banner_head_recyclerview_horizontal);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        bannerRecyclerView.setLayoutManager(linearLayoutManager);
        bannerViewPager.setOffscreenPageLimit(2);
        bannerComponent = new BannerComponent(indicator, bannerViewPager, false);
        bannerComponent.setAutoPlayTime(5000);
        bannerComponent.startAutoPlay();
        recommendIndicatorViewPagerAdapter = new RecommendIndicatorViewPagerAdapter(getActivity(),recommendData);
        bannerComponent.setAdapter(recommendIndicatorViewPagerAdapter);
        categoryAdapter = new CategoryAdapter(recommendData.getHotCategory().getData());
        bannerRecyclerView.setAdapter(categoryAdapter);
    }

    public void initRecyclcer(){
        if(recommendAdapter == null) {
            recommendAdapter = new RecommendAdapter(recommendData.getHotCategory().getData(), getActivity());
            recommendAdapter.addHeaderView(headView);
            mRecyclerView.setAdapter(recommendAdapter);
        }else{
            recommendAdapter.notifyDataSetChanged();
        }
        refreshLayout.finishRefreshing();
    }
}
