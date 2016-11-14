package com.cokus.fangdouyu.ui.fragment.live;

import com.cokus.fangdouyu.domain.RestClient;

import rx.Observable;

/**
 * Created by coku on 16/11/11.
 */
public class LiveCategoryModel implements LiveContract.Model {
    @Override
    public Observable<com.cokus.fangdouyu.modle.live.LiveCategory> getData() {
        return RestClient.getInstance().getLiveService().getLiveCategory();
    }
}
