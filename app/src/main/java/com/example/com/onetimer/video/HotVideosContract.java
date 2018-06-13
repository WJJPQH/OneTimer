package com.example.com.onetimer.video;

import com.example.com.onetimer.base.BaseContract;
import com.example.com.onetimer.bean.HotVideosBean;

public interface HotVideosContract  {
    interface View extends BaseContract.BaseView{
        void onHotVideosSuccess(HotVideosBean hotVideosBean);
    }
    interface Presenter extends BaseContract.BasePresenter<View>{
        void getHotVideos(String token,String page);
    }
}
