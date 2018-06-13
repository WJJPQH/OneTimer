package com.example.com.onetimer.recommend.persenter;

import com.example.com.onetimer.base.BaseContract;
import com.example.com.onetimer.base.BasePresenter;
import com.example.com.onetimer.bean.RecommendBean;
import com.example.com.onetimer.recommend.contract.RecommendContract;
import com.example.com.onetimer.recommend.net.RecommendApi;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RecommendPersenter extends BasePresenter<RecommendContract.View> implements RecommendContract.Persenter{
    private RecommendApi recommendApi;
    @Inject
    public RecommendPersenter(RecommendApi recommendApi) {
        this.recommendApi = recommendApi;
    }

    @Override
    public void getRecommend(String page) {
        recommendApi.getRecommend(page)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<RecommendBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RecommendBean recommendBean) {
                          if(mView!=null){
                              mView.recommendSuccess(recommendBean);
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
