package com.cokus.fangdouyu.ui.fragment.home.game.adapter;


import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cokus.fangdouyu.R;
import com.cokus.fangdouyu.modle.game.Game;
import com.cokus.fangdouyu.widget.viewpagerindicator.view.indicator.IndicatorViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by coku on 16/11/3.
 */
public class GameIndicatorViewPagerAdapter extends IndicatorViewPager.IndicatorViewPagerAdapter{
    private  Context context;
    private Game game;
    public GameIndicatorViewPagerAdapter(Context context, Game game){
        this.context = context;
        game.getData().remove(0);
        this.game = game;

    }

    @Override
    public int getCount() {
        return (int)Math.ceil(game.getData().size()/8.0f);
    }

    @Override
    public View getViewForTab(int position, View convertView, ViewGroup container) {
        if (convertView == null) {
            LayoutInflater inflate = LayoutInflater.from(context);
            convertView = inflate.inflate(R.layout.tab_circle, container, false);
        }
        return convertView;
    }

    @Override
    public View getViewForPage(int position, View convertView, ViewGroup container) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_banner_game,null);
        }
        RecyclerView recyclerView = (RecyclerView) convertView;
        recyclerView.setLayoutManager(new GridLayoutManager(context,4));
        GameCategoryAdapter adapter = new GameCategoryAdapter(getPagerList(position));
        recyclerView.setAdapter(adapter);

        return convertView;
    }

    public List<Game.DataBean> getPagerList(int page){
        List<Game.DataBean> beanList = new ArrayList<>();
        int begin = page*8;
        int end = begin+8<game.getData().size()-1?begin+8:game.getData().size()-1;
//        beanList = game.getData().subList(begin,end);
        for(int i = begin;i<end;i++){
            beanList.add(game.getData().get(i));
        }
        return  beanList;
    }
}
