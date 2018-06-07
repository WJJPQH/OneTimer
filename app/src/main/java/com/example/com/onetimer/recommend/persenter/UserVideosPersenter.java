package com.example.com.onetimer.recommend.persenter;

import com.example.com.onetimer.adapter.UserVideosBean;
import com.example.com.onetimer.base.BasePresenter;
import com.example.com.onetimer.recommend.contract.UserVideosContract;
import com.example.com.onetimer.recommend.net.RecommendApi;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class UserVideosPersenter extends BasePresenter<UserVideosContract.View> implements UserVideosContract.Persenter{
    private RecommendApi recommendApi;
    @Inject
    public UserVideosPersenter(RecommendApi recommendApi) {
        this.recommendApi = recommendApi;
    }


    @Override
    public void getUserVoides(String uid, String page) {
        recommendApi.getUserVideos(uid,page)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<UserVideosBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserVideosBean userVideosBena) {
                        if(mView!=null){
                            mView.UserVoidesSuccess(userVideosBena);
                        }
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
