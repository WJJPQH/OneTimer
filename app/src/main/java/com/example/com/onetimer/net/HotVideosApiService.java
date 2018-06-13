package com.example.com.onetimer.net;

import com.example.com.onetimer.bean.HotVideosBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface HotVideosApiService {
    @FormUrlEncoded
    @POST("quarter/getHotVideos")
    Observable<HotVideosBean> getHotVideos(@Field("token") String token,@Field("page") String page);
}
