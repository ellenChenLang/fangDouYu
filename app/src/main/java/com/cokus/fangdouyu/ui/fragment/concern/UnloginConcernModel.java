package com.cokus.fangdouyu.ui.fragment.concern;

import com.cokus.fangdouyu.domain.RestClient;
import com.cokus.fangdouyu.modle.concern.RecommendLiveRoom;

import rx.Observable;

/**
 * Created by coku on 16/11/13.
 */
public class UnloginConcernModel implements UnloginConcernContract.Model {
    @Override
    public Observable<RecommendLiveRoom> getData() {
        return RestClient.getInstance().getConcernService().getRecommedLiveRoom();
    }
}
