package com.example.footballmobileapp;

import com.example.footballmobileapp.models.TeamModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface SportApi {

    @GET("v2/competitions")
    Call<Competitions> getCompetitions(@Header("Authorization") String token);


   // /v2/matches

    @GET("v2/competitions/{id}/teams")
    Call<TeamModel> getParticularCompetition( @Header("Authorization") String token, @Path("id") int competitionId);

    @GET("v2/competitions/{id}")
    Call<Competitions> getComp(@Header("Authorization") String token, @Path("id") int competitionId);
//    @GET("v2/competitions/{id}/teams")
//    Call<TeamModel> getParticularCompetition( @Header("Authorization") String token, @Path("id") int competitionId);
    //@Path("id") int competitionIdhttp://api.football-data.org/v2/competitions/2000/teams
}
