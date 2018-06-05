package com.example.com.onetimer.module;

import com.example.com.onetimer.net.Api;
import com.example.com.onetimer.net.JokeApi;
import com.example.com.onetimer.net.JokeApiService;
import com.example.com.onetimer.net.MyInterceptor;

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

}
