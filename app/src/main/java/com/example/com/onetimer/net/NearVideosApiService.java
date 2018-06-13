package com.example.com.onetimer.net;

import com.example.com.onetimer.bean.HotVideosBean;
import com.example.com.onetimer.bean.NearVideosBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface NearVideosApiService {
    @FormUrlEncoded
    @POST("quarter/getNearVideos")
    Observable<NearVideosBean> getHotVideos(@Field("token") String token, @Field("page") String page, @Field("latitude")String latitude, @Field("longitude")String longitude);
}
