package com.example.footballmobileapp.models;

import com.google.gson.annotations.SerializedName;

public class Team {



    @SerializedName("crestUrl")
    private String imgUrl;
    private int id;


    public int getId() {
        return id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
