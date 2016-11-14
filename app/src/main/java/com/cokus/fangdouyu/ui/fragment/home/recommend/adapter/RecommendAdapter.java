package com.cokus.fangdouyu.ui.fragment.home.recommend.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.cokus.fangdouyu.R;
import com.cokus.fangdouyu.base.adapter.BaseQuickAdapter;
import com.cokus.fangdouyu.base.adapter.BaseViewHolder;
import com.cokus.fangdouyu.modle.recommend.HotCategory;

import java.util.List;

/**
 * Created by coku on 16/11/2.
 */
public class RecommendAdapter extends BaseQuickAdapter<HotCategory.DataBean>{
    private Context context;

    public RecommendAdapter(List<HotCategory.DataBean> data,Context context) {
        super(R.layout.item_recommend, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, HotCategory.DataBean item) {
        helper.setText(R.id.category_name,item.getTag_name());
        RecyclerView recyclerView = helper.getView(R.id.category_recyclerview);
        if(recyclerView.getAdapter()== null) {
        recyclerView.setLayoutManager(new GridLayoutManager(context,2));
        recyclerView.setAdapter(new RecommendRoomAdapter(item.getRoom_list()));
        }else{
            ((RecommendRoomAdapter)recyclerView.getAdapter()).setNewData(item.getRoom_list());
        }
    }


}
