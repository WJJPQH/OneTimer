package com.example.com.onetimer.recommend.net;

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
}
