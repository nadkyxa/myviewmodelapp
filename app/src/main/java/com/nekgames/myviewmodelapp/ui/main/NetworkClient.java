package com.nekgames.myviewmodelapp.ui.main;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Nadya Bryzgalova on 22.08.2021.
 **/
public class NetworkClient {
    private static NetworkClient instance;
    public static final String BASE_URL = "https://my-json-server.typicode.com/";
    private Retrofit retrofit;
    private MyApiService apiService;

    public static NetworkClient getInstance(){
        if (instance == null) {
            instance = new NetworkClient();
            instance.initRetrofit();
        }

        return instance;
    }

    private void initRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(MyApiService.class);
    }

    public MyApiService getMyApiService(){
        return apiService;
    }

}
