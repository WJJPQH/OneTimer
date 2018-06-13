package com.example.com.onetimer.video;

import com.example.com.onetimer.base.BaseContract;
import com.example.com.onetimer.bean.HotVideosBean;
import com.example.com.onetimer.bean.NearVideosBean;

public interface NearVideosContract {
    interface View extends BaseContract.BaseView{
        void onNearVideosSuccess(NearVideosBean nearVideosBean);
    }
    interface Presenter extends BaseContract.BasePresenter<View>{
        void getNearVideos(String token,String page,String latitude,String longitude);
    }

}
