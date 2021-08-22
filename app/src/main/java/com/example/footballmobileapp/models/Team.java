package com.example.footballmobileapp.models;

import com.google.gson.annotations.SerializedName;

public class Team {


    @SerializedName("teams")
    private String imgUrl;



    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
