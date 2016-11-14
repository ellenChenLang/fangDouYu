package com.cokus.fangdouyu.ui.fragment.live.room;
import com.cokus.fangdouyu.modle.live.LiveRoom;
import com.orhanobut.logger.Logger;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * Created by coku on 16/11/12.
 */
public class LiveCategoryRoomPresenter extends LiveCategoryRoomContract.Presenter {
    @Override
    public void getDate(String tagId, int offset, final int state) {
        mRxManager.add(mModel.getLiveRoom(tagId,offset).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        mView.onRequestStart();
                    }
                })
                .subscribe(new Observer<LiveRoom>() {
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
                    public void onNext(LiveRoom liveRoom) {
                        mView.getLiveRoom(liveRoom,state);

                    }
                }));
    }
}
