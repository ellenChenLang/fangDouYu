package com.cokus.fangdouyu.ui.fragment.live.category.adapter;

import android.widget.ImageView;

import com.cokus.fangdouyu.DYApplication;
import com.cokus.fangdouyu.R;
import com.cokus.fangdouyu.base.adapter.BaseQuickAdapter;
import com.cokus.fangdouyu.base.adapter.BaseViewHolder;
import com.cokus.fangdouyu.modle.live.LiveCategory;
import com.cokus.fangdouyu.modle.live.LiveChildCategory;
import com.cokus.fangdouyu.modle.recommend.HotCategory;

import java.util.List;

/**
 * Created by coku on 16/11/2.
 */
public class LiveCategoryAdapter extends BaseQuickAdapter<LiveChildCategory.DataBean>{


    public LiveCategoryAdapter(List<LiveChildCategory.DataBean> data) {
        super(R.layout.item_live_category, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, LiveChildCategory.DataBean item) {
        helper.setText(R.id.category_name,item.getTag_name());
        DYApplication.glideBitmap.displayCircle((ImageView) helper.getView(R.id.category_img),item.getIcon_url());

    }


}
