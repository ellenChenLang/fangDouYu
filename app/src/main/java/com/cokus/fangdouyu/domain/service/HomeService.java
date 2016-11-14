package com.cokus.fangdouyu.domain.service;

import com.cokus.fangdouyu.modle.game.Game;
import com.cokus.fangdouyu.modle.live.LiveCategory;
import com.cokus.fangdouyu.modle.live.LiveChildCategory;
import com.cokus.fangdouyu.modle.live.LiveRoom;
import com.cokus.fangdouyu.modle.recommend.HotCategory;
import com.cokus.fangdouyu.modle.recommend.RecomendChannel;
import com.cokus.fangdouyu.modle.recommend.VerticalRoom;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by coku on 16/10/22.
 */
public interface HomeService {

    @GET("/api/v1/slide/6?version=2.31&client_sys=android")
    Observable<RecomendChannel>  getChannel();

    @GET("/api/v1/getHotCate?aid=android1&client_sys=android&time=1478056974&token=&auth=c49973707d2e379acdd06ed96d0fcb6c")
    Observable<HotCategory>  getHotCate();

    @GET("/api/v1/getVerticalRoom?offset=0&limit=4&client_sys=android")
    Observable<VerticalRoom> getVertiacalRoom();

    @GET("/api/homeCate/getHotRoom?identification=ba08216f13dd1742157412386eee1225&client_sys=android")
    Observable<Game> getGame();

    @GET("/api/homeCate/getHotRoom?identification=9acf9c6f117a4c2d02de30294ec29da9&client_sys=android")
    Observable<Game> getEnjoy();

    @GET("/api/homeCate/getHotRoom?identification=3e760da75be261a588c74c4830632360&client_sys=android")
    Observable<Game> getPhoneGame();

    @GET("/api/homeCate/getHotRoom?identification=393b245e8046605f6f881d415949494c&client_sys=android")
    Observable<Game> getInterestGame();




}
