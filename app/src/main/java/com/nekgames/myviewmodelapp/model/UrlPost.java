package com.nekgames.myviewmodelapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Nadya Bryzgalova on 22.08.2021.
 **/
public class UrlPost {
    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String title="";

    public String getTitle() {
        return title;
    }
}
