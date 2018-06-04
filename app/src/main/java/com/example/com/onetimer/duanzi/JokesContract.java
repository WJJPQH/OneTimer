package com.example.com.onetimer.duanzi;

import com.example.com.onetimer.base.BaseContract;
import com.example.com.onetimer.bean.JokeBean;

public interface JokesContract {

    interface View extends BaseContract.BaseView{
        void onJokeSuccess(JokeBean jokeBean);
    }
    interface Presenter extends BaseContract.BasePresenter<View>{
        void getJoke(String page);
    }
}
