package com.example.com.onetimer.recommend.contract;

import com.example.com.onetimer.adapter.UserVideosBean;
import com.example.com.onetimer.base.BaseContract;
import com.example.com.onetimer.bean.AttentionBean;

public interface UserVideosContract {
    interface View extends BaseContract.BaseView{
        void UserVoidesSuccess(UserVideosBean userVideosBean);
    }
    interface Persenter extends BaseContract.BasePresenter<View>{
        void getUserVoides(String uid, String page);
    }
}
