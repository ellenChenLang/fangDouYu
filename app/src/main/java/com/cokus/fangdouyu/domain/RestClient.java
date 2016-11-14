package com.cokus.fangdouyu.domain;

import com.cokus.fangdouyu.domain.service.ConcernService;
import com.cokus.fangdouyu.domain.service.HomeService;
import com.cokus.fangdouyu.domain.service.LiveService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;;

/**
 * Created by coku on 16/10/31.
 */
public class RestClient {
    private  static String HOST_NAME="http://capi.douyucdn.cn";

    private static final RestClient instance = new RestClient();

    private HomeService homeService;

    private LiveService liveService;

    private ConcernService concernService;

    public HomeService getHomeService() {
        return homeService == null ?  create(HomeService.class) :homeService;
    }

    public LiveService getLiveService() {
        return liveService == null ?  create(LiveService.class) :liveService;
    }

    public ConcernService getConcernService() {
        return concernService == null ?  create(ConcernService.class) :concernService;
    }

    public static RestClient getInstance() {
        return instance;
    }


    private Retrofit retrofit;

    public RestClient() {
        createRetrofit();
    }

    private void createRetrofit() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(HOST_NAME)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }


    public <T> T create(Class<T> clazz) {
        return (T) retrofit.create(clazz);
    }


}
