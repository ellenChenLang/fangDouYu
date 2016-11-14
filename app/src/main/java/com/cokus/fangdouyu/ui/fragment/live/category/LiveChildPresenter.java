package com.cokus.fangdouyu.ui.fragment.live.category;

import com.cokus.fangdouyu.modle.live.LiveCategory;
import com.cokus.fangdouyu.modle.live.LiveChildCategory;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by coku on 16/11/12.
 */
public class LiveChildPresenter extends LiveChildCategoryContract.Presenter {

    @Override
    public void getDate(String shortName) {
     mRxManager.add(mModel.getChildCategory(shortName).subscribeOn(Schedulers.io())
             .observeOn(AndroidSchedulers.mainThread())
             .subscribe(new Observer<LiveChildCategory>() {
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
                 public void onNext(LiveChildCategory liveChildCategory) {
                     mView.getChildCategory(liveChildCategory);
                 }
             }));
    }

}
