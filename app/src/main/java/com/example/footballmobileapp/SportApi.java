package com.example.footballmobileapp;

import com.example.footballmobileapp.models.TeamModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface SportApi {

    @GET("v2/competitions")
    Call<Competitions> getCompetitions(@Header("Authorization") String token);

    @GET("v2/competitions/{id}/teams")
    Call<TeamModel> getParticularCompetition(@Path("id") int competitionId, @Header("Authorization") String token);
}
