package com.cokus.fangdouyu.ui.fragment.home.recommend;

import com.cokus.fangdouyu.modle.recommend.HotCategory;
import com.cokus.fangdouyu.modle.recommend.RecomendChannel;
import com.cokus.fangdouyu.modle.recommend.RecommendData;
import com.cokus.fangdouyu.modle.recommend.VerticalRoom;
import com.cokus.fangdouyu.mvp.BaseModel;
import com.cokus.fangdouyu.mvp.BasePresenter;
import com.cokus.fangdouyu.mvp.BaseView;
import rx.Observable;

/**
 * Created by coku on 16/11/1.
 */
public interface RecommentContract {


    interface  Model extends BaseModel{
        Observable<RecomendChannel> getChannel();
        Observable<HotCategory> getHotCate();
        Observable<VerticalRoom> getVertiacalRoom();
    }

    interface View extends BaseView{
        void getData(RecommendData data);
    }

    abstract class Presenter extends BasePresenter<Model,View>{
        public abstract void getData();
    }

}
