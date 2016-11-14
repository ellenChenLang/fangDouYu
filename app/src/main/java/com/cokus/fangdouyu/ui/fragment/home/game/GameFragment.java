package com.cokus.fangdouyu.ui.fragment.home.game;


import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import com.cokus.fangdouyu.R;
import com.cokus.fangdouyu.modle.game.Game;
import com.cokus.fangdouyu.mvp.base.BaseMvpFragment;
import com.cokus.fangdouyu.ui.fragment.home.game.adapter.GameAdapter;
import com.cokus.fangdouyu.ui.fragment.home.game.adapter.GameIndicatorViewPagerAdapter;
import com.cokus.fangdouyu.util.DensityUtil;
import com.cokus.fangdouyu.widget.MultiStateView;
import com.cokus.fangdouyu.widget.refresh.DouYuRefreshEmptyBottem;
import com.cokus.fangdouyu.widget.refresh.DouYuRefreshHeader;
import com.cokus.fangdouyu.widget.viewpagerindicator.view.indicator.BannerComponent;
import com.cokus.fangdouyu.widget.viewpagerindicator.view.indicator.FixedIndicatorView;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import butterknife.BindView;

/**
 * Created by coku on 16/11/4.
 */
public class GameFragment extends BaseMvpFragment<GamePresenter,GameModel> implements GameContract.View{
    public static  final int Game =0;
    public static  final int EnjoyGame =1;
    public static  final int PhoneGame =2;
    public static  final int InterestGame =3;

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerView;
    @BindView(R.id.refreshLayout)
    TwinklingRefreshLayout refreshLayout;
    @BindView(R.id.multistateview)
    MultiStateView multiStateView;

    private int type;

    public void setType(int type) {
        this.type = type;
    }

    private GameAdapter gameAdapter;
    private GameIndicatorViewPagerAdapter gameIndicatorViewPagerAdapter;
    private Game game;


    @Override
    protected void loadData() {
        mPresenter.getDate(type);
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
                mPresenter.getDate(type);
            }
        });

    }

    @Override
    public void getData(Game data) {
        this.game = data;
        initHead();
        initRecyclerView();

    }

    @Override
    public void onRequestStart() {
        if(gameAdapter == null || gameAdapter.getItemCount() == 0)
            multiStateView.setViewState(MultiStateView.STATE_LOADING);
    }

    @Override
    public void onRequestEnd() {
        multiStateView.setViewState(MultiStateView.STATE_CONTENT);
    }

    @Override
    public void onRequestError(String msg) {
        super.onRequestError(msg);
        multiStateView.setViewState(MultiStateView.STATE_ERROR);
    }

    private void initRecyclerView(){
        if(gameAdapter == null) {
            gameAdapter = new GameAdapter(game.getData(), getActivity());
            gameAdapter.addHeaderView(headView);
            mRecyclerView.setAdapter(gameAdapter);
        }else{
            gameAdapter.notifyDataSetChanged();
        }
        refreshLayout.finishRefreshing();
    }


    private View headView;
    private ViewPager bannerViewPager;
    private FixedIndicatorView indicator;
    private BannerComponent bannerComponent;
    public  void  initHead(){
        LayoutInflater inflate = LayoutInflater.from(getActivity());
        headView = inflate.inflate(R.layout.head_game_fragment, null, false);
        bannerViewPager = (ViewPager) headView.findViewById(R.id.banner_category_viewPager);
        bannerViewPager.setOffscreenPageLimit(0);
        indicator = (FixedIndicatorView)headView.findViewById(R.id.banner_category_indicator);
        if(game.getData().size()>9) {
            int height = DensityUtil.dip2px(getActivity(), 20) * (int) Math.ceil(game.getData().size() / 8.0f);
            indicator.getLayoutParams().width = height;
        }else{
            indicator.setVisibility(View.GONE);
        }
        bannerComponent = new BannerComponent(indicator, bannerViewPager, false);

        gameIndicatorViewPagerAdapter = new GameIndicatorViewPagerAdapter(getActivity(),game);
        bannerComponent.setAdapter(gameIndicatorViewPagerAdapter);
        bannerComponent.setCurrentItem(0,false);
    }
}
