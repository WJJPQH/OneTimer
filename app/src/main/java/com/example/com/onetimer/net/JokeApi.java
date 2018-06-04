package com.example.com.onetimer.net;

import com.example.com.onetimer.bean.JokeBean;

import io.reactivex.Observable;

public class JokeApi {

    private static JokeApi jokeApi;
    private JokeApiService jokeApiService;

    public JokeApi(JokeApiService jokeApiService) {
        this.jokeApiService = jokeApiService;
    }

    public static JokeApi getJokeApi(JokeApiService jokeApiService) {
        if (jokeApi == null){
            jokeApi = new JokeApi(jokeApiService);
        }
        return jokeApi;
    }
    public Observable<JokeBean> getJokes(String page){
       return jokeApiService.getJokes(page);
    }
}
