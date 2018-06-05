package com.example.com.onetimer.recommend.net;

import com.example.com.onetimer.bean.RecommendBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RecommendApiServiece {
    @FormUrlEncoded
    @POST("quarter/getHotVideos?token=B62A5871AA29A0370D6C4A3B2DB6B87C")
    Observable<RecommendBean> getRecommend(@Field("page")String page);
}
