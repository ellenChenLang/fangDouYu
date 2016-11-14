package com.cokus.fangdouyu.ui.fragment.home.game.adapter;

import android.widget.ImageView;

import com.cokus.fangdouyu.DYApplication;
import com.cokus.fangdouyu.R;
import com.cokus.fangdouyu.base.adapter.BaseQuickAdapter;
import com.cokus.fangdouyu.base.adapter.BaseViewHolder;
import com.cokus.fangdouyu.modle.game.Game;

import java.util.List;

/**
 * Created by coku on 16/11/2.
 */
public class GameCategoryAdapter extends BaseQuickAdapter<Game.DataBean>{


    public GameCategoryAdapter(List<Game.DataBean> data) {
        super(R.layout.item_game_category, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Game.DataBean item) {
        helper.setText(R.id.category_name,item.getTag_name());
        DYApplication.glideBitmap.displayCircle((ImageView) helper.getView(R.id.category_img),item.getIcon_url());

    }


}
