package com.example.com.onetimer.recommend.contract;

import com.example.com.onetimer.base.BaseContract;
import com.example.com.onetimer.bean.RecommendBean;

public interface RecommendContract {
    interface View extends BaseContract.BaseView{
        void recommendSuccess(RecommendBean recommendBean);
    }
    interface Persenter extends BaseContract.BasePresenter<View>{
        void getRecommend(String page);
    }
}
