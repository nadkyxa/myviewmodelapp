package com.nekgames.myviewmodelapp.ui.main;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Nadya Bryzgalova on 22.08.2021.
 **/
public interface MyApiService {
    @GET("/nadkyxa/myjsontestrepo/posts")
    Call<ArrayList<UrlPost>> getPostData();
}
