package com.example.com.onetimer.module;

import com.example.com.onetimer.net.Api;
import com.example.com.onetimer.net.HotVideosApi;
import com.example.com.onetimer.net.HotVideosApiService;
import com.example.com.onetimer.net.JokeApi;
import com.example.com.onetimer.net.JokeApiService;
import com.example.com.onetimer.net.LoginApi;
import com.example.com.onetimer.net.LoginApiService;
import com.example.com.onetimer.net.MyInterceptor;
import com.example.com.onetimer.net.NearVideosApi;
import com.example.com.onetimer.net.NearVideosApiService;
import com.example.com.onetimer.net.RegisterApi;
import com.example.com.onetimer.net.RegisterApiService;
import com.example.com.onetimer.recommend.net.RecommendApi;
import com.example.com.onetimer.recommend.net.RecommendApiServiece;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class HttpModule {
    @Provides
    OkHttpClient.Builder provideOk(){

        return new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(20,TimeUnit.SECONDS)
                .writeTimeout(20,TimeUnit.SECONDS);
    }

    @Provides
    JokeApi provideJoke(OkHttpClient.Builder builder){
        builder.addInterceptor(new MyInterceptor());
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.Base_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(builder.build())
                .build();
        JokeApiService jokeApiService = retrofit.create(JokeApiService.class);
        return JokeApi.getJokeApi(jokeApiService);
    }
    //获取热门视频
    @Provides
    RecommendApi myrecommendapi(OkHttpClient.Builder builder){
        builder.addInterceptor(new MyInterceptor());
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Api.Base_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        RecommendApiServiece recommendApiServiece=retrofit.create(RecommendApiServiece.class);
        return RecommendApi.getRecommendApi(recommendApiServiece);
    }
    @Provides
    RegisterApi provideRegister(OkHttpClient.Builder builder){
        builder.addInterceptor(new MyInterceptor());
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.Base_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(builder.build())
                .build();
        RegisterApiService registerApiService = retrofit.create(RegisterApiService.class);
        return RegisterApi.getRegisterApi(registerApiService);
    }
    @Provides
    LoginApi provideLogin(OkHttpClient.Builder builder){
        builder.addInterceptor(new MyInterceptor());
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.Base_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(builder.build())
                .build();
        LoginApiService loginApiService = retrofit.create(LoginApiService.class);
        return LoginApi.getLoginApi(loginApiService);
    }
    @Provides
    HotVideosApi provideHotVideos(OkHttpClient.Builder builder){
        builder.addInterceptor(new MyInterceptor());
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.Base_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(builder.build())
                .build();
        HotVideosApiService hotVideosApiService = retrofit.create(HotVideosApiService.class);
        return HotVideosApi.getHotVideosApi(hotVideosApiService);
    }
    @Provides
    NearVideosApi provideNearVideos(OkHttpClient.Builder builder){
        builder.addInterceptor(new MyInterceptor());
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.Base_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(builder.build())
                .build();
        NearVideosApiService nearVideosApiService = retrofit.create(NearVideosApiService.class);
        return NearVideosApi.getNearVideosApi(nearVideosApiService);
    }

}
