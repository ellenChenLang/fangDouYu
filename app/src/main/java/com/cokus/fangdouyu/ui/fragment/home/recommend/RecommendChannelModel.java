package com.cokus.fangdouyu.ui.fragment.home.recommend;

import com.cokus.fangdouyu.domain.RestClient;
import com.cokus.fangdouyu.modle.recommend.HotCategory;
import com.cokus.fangdouyu.modle.recommend.RecomendChannel;
import com.cokus.fangdouyu.modle.recommend.VerticalRoom;

import rx.Observable;

/**
 * Created by coku on 16/11/1.
 */
public class RecommendChannelModel implements RecommentContract.Model {


    @Override
    public Observable<RecomendChannel> getChannel() {
        return RestClient.getInstance().getHomeService().getChannel();
    }

    @Override
    public Observable<HotCategory> getHotCate() {
        return RestClient.getInstance().getHomeService().getHotCate();
    }

    @Override
    public Observable<VerticalRoom> getVertiacalRoom() {
        return RestClient.getInstance().getHomeService().getVertiacalRoom();
    }
}
