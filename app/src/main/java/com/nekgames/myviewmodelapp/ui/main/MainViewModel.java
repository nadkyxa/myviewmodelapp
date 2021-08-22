package com.nekgames.myviewmodelapp.ui.main;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private MutableLiveData<List<UrlPost>> posts = new MutableLiveData<>();

    public LiveData<List<UrlPost>> getPosts() {
        if (posts == null) {
            posts = new MutableLiveData<>();
            loadPosts();
        }
        return posts;
    }

    private void loadPosts() {
        // Do an asynchronous operation to fetch posts.
    }
}