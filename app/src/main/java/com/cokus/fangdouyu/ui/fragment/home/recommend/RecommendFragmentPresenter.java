package com.cokus.fangdouyu.ui.fragment.home.recommend;


import com.cokus.fangdouyu.domain.RestClient;
import com.cokus.fangdouyu.modle.recommend.HotCategory;
import com.cokus.fangdouyu.modle.recommend.RecomendChannel;
import com.cokus.fangdouyu.modle.recommend.RecommendData;
import com.cokus.fangdouyu.modle.recommend.VerticalRoom;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * Created by coku on 16/11/1.
 * 多请求合并
 */
public class RecommendFragmentPresenter extends RecommentContract.Presenter{
    private RecommendData recommendData = new RecommendData();

    @Override
    public void getData() {
      mRxManager.add(Observable.merge(mModel.getChannel(),mModel.getHotCate(),mModel.getVertiacalRoom())
                      .subscribeOn(Schedulers.io())
      .doOnSubscribe(new Action0() {
          @Override
          public void call() {
              mView.onRequestStart();
          }
      })
              .observeOn(AndroidSchedulers.mainThread())
              .subscribe(new Observer() {
                  @Override
                  public void onCompleted() {
                      mView.onRequestEnd();
                      mView.getData(recommendData);
                  }

                  @Override
                  public void onError(Throwable e) {
                      mView.onRequestError(e.toString());
                      mView.onInternetError();
                  }

                  @Override
                  public void onNext(Object obj) {
                     if(obj instanceof RecomendChannel ){
                         recommendData.setRecomendChannel((RecomendChannel) obj);
                     }else if(obj instanceof HotCategory){
                         recommendData.setHotCategory((HotCategory) obj);
                     }else{
                         recommendData.setVerticalRoom((VerticalRoom) obj);
                     }
                  }
              })
      );
    }
}
