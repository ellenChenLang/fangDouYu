package com.cokus.fangdouyu.ui.fragment.home.recommend.adapter;

import android.widget.ImageView;

import com.cokus.fangdouyu.DYApplication;
import com.cokus.fangdouyu.R;
import com.cokus.fangdouyu.base.adapter.BaseQuickAdapter;
import com.cokus.fangdouyu.base.adapter.BaseViewHolder;
import com.cokus.fangdouyu.modle.recommend.HotCategory;

import java.util.List;

/**
 * Created by coku on 16/11/2.
 */
public class RecommendRoomAdapter extends BaseQuickAdapter<HotCategory.DataBean.RoomListBean>{


    public RecommendRoomAdapter(List<HotCategory.DataBean.RoomListBean> data) {
        super(R.layout.item_recommend_room, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HotCategory.DataBean.RoomListBean item) {
        helper.setText(R.id.room_title,item.getRoom_name())
        .setText(R.id.onlinetv,item.getOnline()+"")
        .setText(R.id.authortv,item.getNickname());
        DYApplication.glideBitmap.displayRound((ImageView) helper.getView(R.id.room_img),item.getRoom_src());

    }


}
