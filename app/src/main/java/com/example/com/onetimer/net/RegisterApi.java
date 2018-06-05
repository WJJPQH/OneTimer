package com.example.com.onetimer.net;

import com.example.com.onetimer.bean.RegisterBean;

import io.reactivex.Observable;

public class RegisterApi {
    private static RegisterApi registerApi;
    private RegisterApiService registerApiService;

    public RegisterApi(RegisterApiService registerApiService) {
        this.registerApiService = registerApiService;
    }

    public static RegisterApi getRegisterApi(RegisterApiService registerApiService) {
        if(registerApi==null){
            registerApi = new RegisterApi(registerApiService);
        }
        return registerApi;
    }
    public Observable<RegisterBean> getReg(String mobile,String password){
        return registerApiService.getReg(mobile, password);
    }
}
