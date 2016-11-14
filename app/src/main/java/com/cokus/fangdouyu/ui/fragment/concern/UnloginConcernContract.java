package com.cokus.fangdouyu.ui.fragment.concern;

import com.cokus.fangdouyu.modle.concern.RecommendLiveRoom;
import com.cokus.fangdouyu.modle.live.LiveCategory;
import com.cokus.fangdouyu.mvp.BaseModel;
import com.cokus.fangdouyu.mvp.BasePresenter;
import com.cokus.fangdouyu.mvp.BaseView;

import rx.Observable;

/**
 * Created by coku on 16/11/13.
 */
public interface UnloginConcernContract {
    interface  Model extends BaseModel {
        Observable<RecommendLiveRoom> getData();
    }

    interface View extends BaseView {
        void getData(RecommendLiveRoom data);
    }

    abstract class Presenter extends BasePresenter<Model,View> {
        public abstract void getDate();
    }
}
