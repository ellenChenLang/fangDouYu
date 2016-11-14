package com.cokus.fangdouyu.ui.fragment.live.room;

import com.cokus.fangdouyu.modle.live.LiveChildCategory;
import com.cokus.fangdouyu.modle.live.LiveRoom;
import com.cokus.fangdouyu.mvp.BaseModel;
import com.cokus.fangdouyu.mvp.BasePresenter;
import com.cokus.fangdouyu.mvp.BaseView;

import rx.Observable;

/**
 * Created by coku on 16/11/12.
 */
public interface LiveCategoryRoomContract {
    interface  Model extends BaseModel {
        Observable<LiveRoom> getLiveRoom(String tagId,int offset);
    }

    interface View extends BaseView {
        void getLiveRoom(LiveRoom liveRoom,int state);
    }

    abstract class Presenter extends BasePresenter<Model,View> {
        public abstract void getDate(String  tagId,int offset,int state);
    }
}
