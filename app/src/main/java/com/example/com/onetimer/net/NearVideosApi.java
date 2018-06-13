package com.example.com.onetimer.net;

import com.example.com.onetimer.bean.NearVideosBean;

import io.reactivex.Observable;

public class NearVideosApi {
    private static NearVideosApi nearVideosApi;
    private NearVideosApiService nearVideosApiService;

    public NearVideosApi(NearVideosApiService nearVideosApiService) {
        this.nearVideosApiService = nearVideosApiService;
    }

    public static NearVideosApi getNearVideosApi(NearVideosApiService nearVideosApiService) {
        if (nearVideosApi==null){
            nearVideosApi = new NearVideosApi(nearVideosApiService);
        }
        return nearVideosApi;
    }
    public Observable<NearVideosBean> getNearVideos(String token,String page,String latitude,String longitude){
     return nearVideosApiService.getHotVideos(token, page, latitude, longitude);
    }
}
