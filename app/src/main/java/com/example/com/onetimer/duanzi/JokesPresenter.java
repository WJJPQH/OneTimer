package com.example.com.onetimer.duanzi;

import com.example.com.onetimer.base.BasePresenter;
import com.example.com.onetimer.bean.JokeBean;
import com.example.com.onetimer.net.JokeApi;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class JokesPresenter extends BasePresenter<JokesContract.View> implements JokesContract.Presenter {
    private JokeApi jokeApi;
    @Inject
    public JokesPresenter(JokeApi jokeApi) {
        this.jokeApi = jokeApi;
    }

    @Override
    public void getJoke(String page) {
        jokeApi.getJokes(page)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<JokeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JokeBean jokeBean) {
                        mView.onJokeSuccess(jokeBean);
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
