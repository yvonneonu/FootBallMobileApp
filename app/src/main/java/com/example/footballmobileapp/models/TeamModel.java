package com.example.footballmobileapp.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TeamModel {
    @SerializedName("teams")
    List<Team> teams;

    public List<Team> getTeams() {
        return teams;
    }
}
