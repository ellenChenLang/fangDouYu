package com.cokus.fangdouyu.ui.fragment.home.game.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.cokus.fangdouyu.R;
import com.cokus.fangdouyu.base.adapter.BaseQuickAdapter;
import com.cokus.fangdouyu.base.adapter.BaseViewHolder;
import com.cokus.fangdouyu.modle.game.Game;

import java.util.List;

/**
 * Created by coku on 16/11/2.
 */
public class GameAdapter extends BaseQuickAdapter<Game.DataBean>{
    private Context context;

    public GameAdapter(List<Game.DataBean> data, Context context) {
        super(R.layout.item_recommend, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, Game.DataBean item) {
        helper.setText(R.id.category_name,item.getTag_name());
        RecyclerView recyclerView = helper.getView(R.id.category_recyclerview);
        if(recyclerView.getAdapter()== null) {
            recyclerView.setLayoutManager(new GridLayoutManager(context,2));
            recyclerView.setAdapter(new GameRoomAdapter(item.getRoom_list()));
        }else{
            ((GameRoomAdapter)recyclerView.getAdapter()).setNewData(item.getRoom_list());
        }

    }


}
