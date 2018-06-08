package com.example.com.onetimer.recommend.contract;

import com.example.com.onetimer.base.BaseContract;
import com.example.com.onetimer.bean.AttentionBean;
import com.example.com.onetimer.bean.RecommendBean;

public interface AttentionContract {
    interface View extends BaseContract.BaseView{
        void AttentionSuccess(AttentionBean attentionBean);
    }
    interface Persenter extends BaseContract.BasePresenter<View>{
        void getAttention(String uid,String token);
    }
}
