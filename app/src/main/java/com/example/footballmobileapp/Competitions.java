package com.example.footballmobileapp;

import com.example.footballmobileapp.models.LeagueModel;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Competitions {

    @SerializedName("competitions")
    private List<LeagueModel> leaguesResult = new ArrayList<>();

    public List<LeagueModel> getLeaguesResult() {
        return leaguesResult;
    }

    public void setLeaguesResult(List<LeagueModel> leaguesResult) {
        this.leaguesResult = leaguesResult;
    }
}
