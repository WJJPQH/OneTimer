package com.example.com.onetimer.recommend.persenter;

import com.example.com.onetimer.base.BasePresenter;
import com.example.com.onetimer.bean.AttentionBean;
import com.example.com.onetimer.bean.RecommendBean;
import com.example.com.onetimer.recommend.contract.AttentionContract;
import com.example.com.onetimer.recommend.contract.RecommendContract;
import com.example.com.onetimer.recommend.net.RecommendApi;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class AttentionPersenter extends BasePresenter<AttentionContract.View> implements AttentionContract.Persenter{
    private RecommendApi recommendApi;
    @Inject
    public AttentionPersenter(RecommendApi recommendApi) {
        this.recommendApi = recommendApi;
    }


    @Override
    public void getAttention(String uid,String token) {
        recommendApi.getAttention(uid,token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<AttentionBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AttentionBean attentionBean) {
                        if(mView!=null){
                            mView.AttentionSuccess(attentionBean);
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
