package com.cokus.fangdouyu.ui.fragment.live.category;

import com.cokus.fangdouyu.modle.live.LiveCategory;
import com.cokus.fangdouyu.modle.live.LiveChildCategory;
import com.cokus.fangdouyu.modle.live.LiveRoom;
import com.cokus.fangdouyu.mvp.BaseModel;
import com.cokus.fangdouyu.mvp.BasePresenter;
import com.cokus.fangdouyu.mvp.BaseView;

import rx.Observable;

/**
 * Created by coku on 16/11/12.
 */
public interface LiveChildCategoryContract {
    interface  Model extends BaseModel {
        Observable<LiveChildCategory> getChildCategory(String shortName);
    }

    interface View extends BaseView {
        void getChildCategory(LiveChildCategory data);
    }

    abstract class Presenter extends BasePresenter<Model,View> {
        public abstract void getDate(String shortName);
    }
}
