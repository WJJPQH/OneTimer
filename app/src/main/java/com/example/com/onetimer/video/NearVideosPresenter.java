package com.example.com.onetimer.video;

import com.example.com.onetimer.base.BasePresenter;
import com.example.com.onetimer.bean.NearVideosBean;
import com.example.com.onetimer.net.NearVideosApi;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class NearVideosPresenter extends BasePresenter<NearVideosContract.View> implements NearVideosContract.Presenter {
    private NearVideosApi nearVideosApi;
    @Inject
    public NearVideosPresenter(NearVideosApi nearVideosApi) {
        this.nearVideosApi = nearVideosApi;
    }

    @Override
    public void getNearVideos(String token, String page, String latitude, String longitude) {
        nearVideosApi.getNearVideos(token, page, latitude, longitude)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<NearVideosBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(NearVideosBean nearVideosBean) {
                        mView.onNearVideosSuccess(nearVideosBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
