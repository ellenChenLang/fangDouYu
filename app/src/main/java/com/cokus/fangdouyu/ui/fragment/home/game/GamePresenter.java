package com.cokus.fangdouyu.ui.fragment.home.game;

import com.cokus.fangdouyu.domain.RestClient;
import com.cokus.fangdouyu.modle.game.Game;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * Created by coku on 16/11/4.
 */
public class GamePresenter extends GameContract.Presenter {


    @Override
    public void getDate(int type) {
        mRxManager.add(initObservable(type)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        mView.onRequestStart();
                    }
                }).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Game>() {
                    @Override
                    public void onCompleted() {
                        mView.onRequestEnd();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.onRequestError(e.toString());
                        mView.onInternetError();
                    }

                    @Override
                    public void onNext(Game game) {
                        mView.getData(game);

                    }
                })
        );

    }

    public Observable initObservable(int type){
        switch (type){
            case GameFragment.Game:
                return  mModel.getGame();
            case GameFragment.EnjoyGame:
                return  mModel.getEnjoy();
            case GameFragment.PhoneGame:
                return  mModel.getPhoneGame();
            case GameFragment.InterestGame:
                return  mModel.getInterestGame();
            default:
                return  null;
        }
    }
}
