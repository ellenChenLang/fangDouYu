package com.cokus.fangdouyu.domain.service;

import com.cokus.fangdouyu.modle.live.LiveCategory;
import com.cokus.fangdouyu.modle.live.LiveChildCategory;
import com.cokus.fangdouyu.modle.live.LiveRoom;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by coku on 16/11/11.
 */
public interface LiveService {
    @GET("/api/v1/getColumnList?client_sys=android")
    Observable<LiveCategory> getLiveCategory();

    @GET("/api/v1/getColumnDetail?client_sys=android")
    Observable<LiveChildCategory> getLiveChildCategory(@Query("shortName") String shortName);

    @GET("/api/v1/live?offset=0&limit=20&client_sys=android")
    Observable<LiveRoom> getLiveAll();

    @GET("/api/v1/live/{tag_id}?limit=20&client_sys=android")
    Observable<LiveRoom> getLiveRoomByCategoty(@Path("tag_id") String tag_id,@Query("offset") String offset);
}
