package com.cokus.fangdouyu.ui.fragment.home.game;

import com.cokus.fangdouyu.domain.RestClient;
import com.cokus.fangdouyu.modle.game.Game;

import rx.Observable;

/**
 * Created by coku on 16/11/4.
 */
public class GameModel implements GameContract.Model {

    @Override
    public Observable<Game> getGame() {
        return RestClient.getInstance().getHomeService().getGame();
    }

    @Override
    public Observable<Game> getEnjoy() {
        return RestClient.getInstance().getHomeService().getEnjoy();
    }

    @Override
    public Observable<Game> getPhoneGame() {
        return RestClient.getInstance().getHomeService().getPhoneGame();
    }

    @Override
    public Observable<Game> getInterestGame() {
        return RestClient.getInstance().getHomeService().getInterestGame();
    }
}
