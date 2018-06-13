package com.example.com.onetimer.net;

import com.example.com.onetimer.bean.HotVideosBean;

import io.reactivex.Observable;

public class HotVideosApi {
    private static HotVideosApi hotVideosApi;
    private HotVideosApiService hotVideosApiService;

    public HotVideosApi(HotVideosApiService hotVideosApiService) {
        this.hotVideosApiService = hotVideosApiService;
    }

    public static HotVideosApi getHotVideosApi(HotVideosApiService hotVideosApiService) {
        if (hotVideosApi==null){
            hotVideosApi = new HotVideosApi(hotVideosApiService);
        }
        return hotVideosApi;
    }
    public Observable<HotVideosBean> getHotVideos(String token,String page){

        return hotVideosApiService.getHotVideos(token, page);
    }
}
