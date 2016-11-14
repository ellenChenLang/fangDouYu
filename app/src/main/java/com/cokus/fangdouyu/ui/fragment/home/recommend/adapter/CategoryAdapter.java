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
public class CategoryAdapter extends BaseQuickAdapter<HotCategory.DataBean>{


    public CategoryAdapter(List<HotCategory.DataBean> data) {
        super(R.layout.item_category, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HotCategory.DataBean item) {
        helper.setText(R.id.category_name,item.getTag_name());
        DYApplication.glideBitmap.displayCircle((ImageView) helper.getView(R.id.category_img),item.getIcon_url());

    }


}
