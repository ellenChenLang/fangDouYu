package com.cokus.fangdouyu.ui.fragment.concern;

import com.cokus.fangdouyu.modle.concern.RecommendLiveRoom;
import com.cokus.fangdouyu.modle.live.LiveCategory;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by coku on 16/11/13.
 */
public class UnloginConcernPresenter extends UnloginConcernContract.Presenter {
    @Override
    public void getDate() {
        mRxManager.add(mModel.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RecommendLiveRoom>() {
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
                    public void onNext(RecommendLiveRoom recommendLiveRoom) {
                        mView.getData(recommendLiveRoom);
                    }
                }));
    }
}
