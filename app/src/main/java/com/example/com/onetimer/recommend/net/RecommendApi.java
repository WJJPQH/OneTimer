package com.example.com.onetimer.recommend.net;

import com.example.com.onetimer.bean.UserVideosBean;
import com.example.com.onetimer.base.AttentionUserBean;
import com.example.com.onetimer.bean.AttentionBean;
import com.example.com.onetimer.bean.RecommendBean;

import io.reactivex.Observable;

public class RecommendApi {
    private static RecommendApi recommendApi;
    private RecommendApiServiece recommendApiServiece;

    public RecommendApi(RecommendApiServiece recommendApiServiece) {
        this.recommendApiServiece = recommendApiServiece;
    }

    public static RecommendApi getRecommendApi(RecommendApiServiece recommendApiServiece) {
        if(recommendApi==null){
            recommendApi=new RecommendApi(recommendApiServiece);
        }
        return recommendApi;
    }
    public Observable<RecommendBean> getRecommend(String page){
        return recommendApiServiece.getRecommend(page);
    }
    public Observable<AttentionBean> getAttention(String uid,String token){
        return recommendApiServiece.getAttention(uid,token);
    }
    public Observable<UserVideosBean> getUserVideos(String uid, String page){
        return recommendApiServiece.getUserVideos(uid,page);
    }
    public Observable<AttentionUserBean> getAttentionUser(String uid,String wid,String token){
        return recommendApiServiece.getAttentionUser(uid,wid,token);
    }
}
