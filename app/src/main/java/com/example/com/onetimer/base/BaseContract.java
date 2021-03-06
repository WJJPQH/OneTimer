package com.example.com.onetimer.base;

public interface BaseContract {
    interface BasePresenter<T extends BaseView>{
        void attchView(T view);
        void detachView();
    }
    public interface BaseView{
        void showLoading();
        void dissmissLoading();
    }
}
