package com.cokus.fangdouyu.ui.fragment.live.room;

import com.cokus.fangdouyu.domain.RestClient;
import com.cokus.fangdouyu.modle.live.LiveChildCategory;
import com.cokus.fangdouyu.modle.live.LiveRoom;
import com.orhanobut.logger.Logger;

import rx.Observable;

/**
 * Created by coku on 16/11/12.
 */
public class LiveCategoryRoomModel implements LiveCategoryRoomContract.Model{

    @Override
    public Observable<LiveRoom> getLiveRoom(String tagId,int offset) {
        return RestClient.getInstance().getLiveService().getLiveRoomByCategoty(tagId,offset+"");
    }
}
