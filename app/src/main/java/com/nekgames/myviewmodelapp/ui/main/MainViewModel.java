package com.nekgames.myviewmodelapp.ui.main;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {
    private MutableLiveData<List<UrlPost>> posts;

    public LiveData<List<UrlPost>> getPosts() {
        if (posts == null) {
            posts = new MutableLiveData<>();
            loadPosts();
        }
        return posts;
    }

    private void loadPosts() {
        Call<ArrayList<UrlPost>> call = NetworkClient.getInstance().getMyApiService().getPostData();
        call.enqueue(new Callback<ArrayList<UrlPost>>() {
            @Override
            public void onResponse(Call<ArrayList<UrlPost>> call, Response<ArrayList<UrlPost>> response) {
                List<UrlPost> myList = response.body();
                posts.setValue(myList);
            }

            @Override
            public void onFailure(Call<ArrayList<UrlPost>> call, Throwable t) {
                //handle the error
            }
        });

    }
}