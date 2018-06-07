package com.example.com.onetimer.net;

import com.example.com.onetimer.bean.LoginBean;

import io.reactivex.Observable;

public class LoginApi {
    private static LoginApi loginApi;
    private LoginApiService loginApiService;

    public LoginApi(LoginApiService loginApiService) {
        this.loginApiService = loginApiService;
    }

    public static LoginApi getLoginApi(LoginApiService loginApiService) {
        if (loginApi==null){
            loginApi = new LoginApi(loginApiService);
        }
        return loginApi;
    }
    public Observable<LoginBean> getLogin(String mobile,String password){
        return loginApiService.getLogin(mobile, password);
    };
}
