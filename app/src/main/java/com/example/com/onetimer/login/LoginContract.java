package com.example.com.onetimer.login;

import com.example.com.onetimer.base.BaseContract;
import com.example.com.onetimer.bean.LoginBean;

public interface LoginContract {
    interface View extends BaseContract.BaseView{
        void onLoginSuccess(LoginBean loginBean);
    }
    interface Presenter extends BaseContract.BasePresenter<View>{
        void getLogin(String mobile,String password);
    }
}
