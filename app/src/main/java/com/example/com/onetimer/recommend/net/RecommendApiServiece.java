package com.example.com.onetimer.recommend.net;

import com.example.com.onetimer.adapter.UserVideosBean;
import com.example.com.onetimer.bean.AttentionBean;
import com.example.com.onetimer.bean.RecommendBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RecommendApiServiece {
    @FormUrlEncoded
    @POST("quarter/getHotVideos?token=B62A5871AA29A0370D6C4A3B2DB6B87C")
    Observable<RecommendBean> getRecommend(@Field("page")String page);
    //获取关注的用户信息
    @FormUrlEncoded
    @POST("quarter/getFollowUsers")
    Observable<AttentionBean> getAttention(@Field("uid")String uid,@Field("token")String token);
    //获取作品列表
    @FormUrlEncoded
    @POST("/quarter/getUserVideos")
    Observable<UserVideosBean> getUserVideos(@Field("uid")String uid, @Field("page")String page);
}
