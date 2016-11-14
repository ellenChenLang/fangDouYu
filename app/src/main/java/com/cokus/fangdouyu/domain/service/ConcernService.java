package com.cokus.fangdouyu.domain.service;

import com.cokus.fangdouyu.modle.concern.RecommendLiveRoom;
import com.cokus.fangdouyu.modle.recommend.RecomendChannel;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by coku on 16/11/13.
 */
public interface ConcernService {
    @GET("/api/v1/nologinrecommroom?client_sys=android")
    Observable<RecommendLiveRoom> getRecommedLiveRoom();
}
