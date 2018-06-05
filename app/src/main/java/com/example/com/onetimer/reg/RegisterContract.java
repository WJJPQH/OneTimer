package com.example.com.onetimer.reg;

import com.example.com.onetimer.base.BaseContract;
import com.example.com.onetimer.bean.RegisterBean;

public interface RegisterContract{
    interface View extends BaseContract.BaseView{
        void onRegSuccess(RegisterBean registerBean);
    }
    interface Presenter extends BaseContract.BasePresenter<View>{
        void getRegister(String mobile,String password);
    }
}
