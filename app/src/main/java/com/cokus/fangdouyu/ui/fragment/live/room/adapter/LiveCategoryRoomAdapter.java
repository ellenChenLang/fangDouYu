package com.cokus.fangdouyu.ui.fragment.live.room.adapter;

import android.widget.ImageView;
import com.cokus.fangdouyu.DYApplication;
import com.cokus.fangdouyu.R;
import com.cokus.fangdouyu.base.adapter.BaseQuickAdapter;
import com.cokus.fangdouyu.base.adapter.BaseViewHolder;
import com.cokus.fangdouyu.modle.live.LiveRoom;
import java.util.List;

/**
 * Created by coku on 16/11/12.
 */
public class LiveCategoryRoomAdapter extends BaseQuickAdapter<LiveRoom.DataBean> {
    public LiveCategoryRoomAdapter(List<LiveRoom.DataBean> data) {
        super(R.layout.item_recommend_room, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, LiveRoom.DataBean item) {
        helper.setText(R.id.room_title,item.getRoom_name())
                .setText(R.id.onlinetv,item.getOnline()+"")
                .setText(R.id.authortv,item.getNickname());;
        DYApplication.glideBitmap.displayRound((ImageView) helper.getView(R.id.room_img),item.getRoom_src());

    }
}
