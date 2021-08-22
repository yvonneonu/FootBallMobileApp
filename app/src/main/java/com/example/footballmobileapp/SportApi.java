package com.example.footballmobileapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface SportApi {

    @GET("v2/competitions")
    Call<Competitions> getCompetitions(@Header("Authorization") String token);

}
