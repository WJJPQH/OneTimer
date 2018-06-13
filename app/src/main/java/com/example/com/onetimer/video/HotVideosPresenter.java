package com.example.com.onetimer.video;

import com.example.com.onetimer.base.BasePresenter;
import com.example.com.onetimer.bean.HotVideosBean;
import com.example.com.onetimer.net.HotVideosApi;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HotVideosPresenter extends BasePresenter<HotVideosContract.View> implements HotVideosContract.Presenter {
    private HotVideosApi hotVideosApi;
    @Inject
    public HotVideosPresenter(HotVideosApi hotVideosApi) {
        this.hotVideosApi = hotVideosApi;
    }

    @Override
    public void getHotVideos(String token, String page) {
        hotVideosApi.getHotVideos(token, page)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<HotVideosBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HotVideosBean hotVideosBean) {
                        mView.onHotVideosSuccess(hotVideosBean);
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
