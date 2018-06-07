package com.example.com.onetimer.net;

import com.example.com.onetimer.bean.LoginBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginApiService {
    @FormUrlEncoded
    @POST("user/login")
    Observable<LoginBean> getLogin(@Field("mobile") String mobile,@Field("password")String password);
}
