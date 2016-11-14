package com.cokus.fangdouyu.ui.fragment.home.game;

import com.cokus.fangdouyu.modle.game.Game;
import com.cokus.fangdouyu.mvp.BaseModel;
import com.cokus.fangdouyu.mvp.BasePresenter;
import com.cokus.fangdouyu.mvp.BaseView;

import rx.Observable;

/**
 * Created by coku on 16/11/4.
 */
public interface GameContract {
    interface  Model extends BaseModel {
        Observable<Game> getGame();
        Observable<Game> getEnjoy();
        Observable<Game> getPhoneGame();
        Observable<Game> getInterestGame();


    }
    interface View extends BaseView {
        void getData(Game data);
    }

    abstract class Presenter extends BasePresenter<Model,View> {
        public abstract void getDate(int type);
    }
}
