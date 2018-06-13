package com.example.com.onetimer.recommend.contract;

import com.example.com.onetimer.base.AttentionUserBean;
import com.example.com.onetimer.bean.UserVideosBean;
import com.example.com.onetimer.base.BaseContract;

public interface UserVideosContract {
    interface View extends BaseContract.BaseView{
        void UserVoidesSuccess(UserVideosBean userVideosBean);
        void AttentionSuccess(AttentionUserBean attentionUserBean);
    }
    interface Persenter extends BaseContract.BasePresenter<View>{
        void getUserVoides(String uid, String page);
        void getAttentionUser(String uid, String wid,String token);
    }
}
