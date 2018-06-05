package com.example.com.onetimer.net;

import com.example.com.onetimer.bean.RegisterBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RegisterApiService {
    @FormUrlEncoded
    @POST("quarter/register")
    Observable<RegisterBean> getReg(@Field("mobile") String mobile,@Field("password") String password);
}
