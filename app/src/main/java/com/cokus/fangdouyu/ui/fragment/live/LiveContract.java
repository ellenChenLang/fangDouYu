package com.cokus.fangdouyu.ui.fragment.live;

import com.cokus.fangdouyu.modle.game.Game;
import com.cokus.fangdouyu.modle.live.LiveCategory;
import com.cokus.fangdouyu.mvp.BaseModel;
import com.cokus.fangdouyu.mvp.BasePresenter;
import com.cokus.fangdouyu.mvp.BaseView;

import rx.Observable;

/**
 * Created by coku on 16/11/11.
 */
public interface LiveContract {
    interface  Model extends BaseModel {
        Observable<LiveCategory> getData();
    }

    interface View extends BaseView {
        void getData(LiveCategory data);
    }

    abstract class Presenter extends BasePresenter<Model,View> {
        public abstract void getDate();
    }
}
