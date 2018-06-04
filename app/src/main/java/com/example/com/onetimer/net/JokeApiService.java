package com.example.com.onetimer.net;

import com.example.com.onetimer.bean.JokeBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface JokeApiService {
    @FormUrlEncoded
    @POST("quarter/getJokes ")
    Observable<JokeBean> getJokes(@Field("page") String page);
}
