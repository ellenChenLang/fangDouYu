package com.cokus.fangdouyu.ui.fragment.live;

import com.cokus.fangdouyu.modle.live.*;
import com.cokus.fangdouyu.modle.live.LiveCategory;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by coku on 16/11/11.
 */
public class LivePresenter extends LiveContract.Presenter {

    @Override
    public void getDate() {
     mRxManager.add(mModel.getData()
             .subscribeOn(Schedulers.io())
             .observeOn(AndroidSchedulers.mainThread())
             .subscribe(new Observer<com.cokus.fangdouyu.modle.live.LiveCategory>() {
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
         public void onNext(LiveCategory liveCategory) {
          mView.getData(liveCategory);
         }
     }));
    }
}
