package com.example.com.onetimer.base;

public class BaseContract {
    interface BasePresenter<T extends BaseView>{
        void attchView(T view);
        void detachView();
    }
    interface BaseView{
        void showLoading();
        void dissmissLoading();
    }
}
