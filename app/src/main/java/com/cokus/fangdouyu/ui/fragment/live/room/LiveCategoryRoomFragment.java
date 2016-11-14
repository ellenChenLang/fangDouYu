package com.cokus.fangdouyu.ui.fragment.live.room;

import android.os.Handler;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.cokus.fangdouyu.R;
import com.cokus.fangdouyu.base.adapter.BaseQuickAdapter;
import com.cokus.fangdouyu.modle.live.LiveRoom;
import com.cokus.fangdouyu.mvp.base.BaseMvpFragment;
import com.cokus.fangdouyu.ui.fragment.live.room.adapter.LiveCategoryRoomAdapter;
import com.cokus.fangdouyu.util.ToastUtils;
import com.cokus.fangdouyu.widget.MultiStateView;
import com.cokus.fangdouyu.widget.refresh.DouYuRefreshEmptyBottem;
import com.cokus.fangdouyu.widget.refresh.DouYuRefreshHeader;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.orhanobut.logger.Logger;
import butterknife.BindView;

/**
 * Created by coku on 16/11/12.
 */
public class LiveCategoryRoomFragment extends BaseMvpFragment<LiveCategoryRoomPresenter,LiveCategoryRoomModel> implements LiveCategoryRoomContract.View {
    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerView;
    @BindView(R.id.refreshLayout)
    TwinklingRefreshLayout refreshLayout;
    @BindView(R.id.multistateview)
    MultiStateView multiStateView;

    private final  int init = 0;
    private final  int refresh = 1;
    private final  int loadmore = 2;


    private LiveCategoryRoomAdapter roomAdapter;
    private  LiveRoom liveRoom;
    private String tagId;
    private boolean flag = false;

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    @Override
    protected void initView() {
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        refreshLayout.setHeaderView(new DouYuRefreshHeader(getActivity()));
        refreshLayout.setBottomView(new DouYuRefreshEmptyBottem(getActivity()));
        refreshLayout.setOnRefreshListener(new TwinklingRefreshLayout.OnRefreshListener(){
            @Override
            public void onRefresh(TwinklingRefreshLayout refreshLayout) {
                super.onRefresh(refreshLayout);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        flag = true;
                        mPresenter.getDate(tagId,0,refresh);
                    }
                },150);
            }

//            @Override
//            public void onLoadMore(TwinklingRefreshLayout refreshLayout) {
//                super.onLoadMore(refreshLayout);
//                mPresenter.getDate(tagId,roomAdapter.getItemCount()-1,loadmore);
//            }
        });


    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_recomment;
    }

    @Override
    protected void loadData() {
        mPresenter.getDate(tagId,0,init);
    }

    @Override
    public void getLiveRoom(LiveRoom liveRoom,int state) {
        switch (state){
            case init:
                this.liveRoom = liveRoom;
                initRecyclerView();
                break;
            case refresh:
                this.liveRoom = liveRoom;
                initRecyclerView();
                break;
            case loadmore:
                refreshLayout.finishLoadmore();
                this.liveRoom.getData().addAll(liveRoom.getData());
                roomAdapter.addData(liveRoom.getData());
                break;
        }

    }

    private void initRecyclerView(){
         roomAdapter = new LiveCategoryRoomAdapter(liveRoom.getData());
         View customLoading = getActivity().getLayoutInflater().inflate(R.layout.refresh_load_more, (ViewGroup) mRecyclerView.getParent(), false);
            roomAdapter.setLoadingView(customLoading);
            roomAdapter.openLoadAnimation();
            roomAdapter.openLoadMore(roomAdapter.getItemCount()-1);
            mRecyclerView.setAdapter(roomAdapter);
            roomAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
                @Override
                public void onLoadMoreRequested() {
                    mPresenter.getDate(tagId,roomAdapter.getItemCount()-1,loadmore);
                }
            });

        if(flag) {
            flag = false;
            refreshLayout.finishRefreshing();
        }
    }

    @Override
    public void onRequestStart() {
        if(roomAdapter == null || roomAdapter.getItemCount() == 0)
            multiStateView.setViewState(MultiStateView.STATE_LOADING);
    }

    @Override
    public void onRequestEnd() {
        if(roomAdapter.getItemCount() == 0){
            multiStateView.setViewState(MultiStateView.STATE_EMPTY);
        }else {
            multiStateView.setViewState(MultiStateView.STATE_CONTENT);
        }
    }

    @Override
    public void onRequestError(String msg) {
        super.onRequestError(msg);
        multiStateView.setViewState(MultiStateView.STATE_ERROR);
        multiStateView.setOnRetryClickListener(new MultiStateView.OnRetryClickListener() {
            @Override
            public void onRetry() {
                mPresenter.getDate(tagId,0,init);
            }
        });
    }
}
