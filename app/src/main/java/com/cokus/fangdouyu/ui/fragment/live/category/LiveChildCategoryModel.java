package com.cokus.fangdouyu.ui.fragment.live.category;

import com.cokus.fangdouyu.domain.RestClient;
import com.cokus.fangdouyu.modle.live.LiveChildCategory;
import com.cokus.fangdouyu.modle.live.LiveRoom;

import rx.Observable;

/**
 * Created by coku on 16/11/12.
 */
public class LiveChildCategoryModel implements LiveChildCategoryContract.Model {
    @Override
    public Observable<LiveChildCategory> getChildCategory(String shortName) {
        return RestClient.getInstance().getLiveService().getLiveChildCategory(shortName);
    }


}
