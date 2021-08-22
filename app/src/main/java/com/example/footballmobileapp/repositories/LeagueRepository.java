package com.example.footballmobileapp.repositories;

import androidx.lifecycle.LiveData;

import com.example.footballmobileapp.models.LeagueModel;
import com.example.footballmobileapp.requests.LeagueApiClient;

import java.util.List;

public class LeagueRepository {
    private static LeagueRepository instance;

    private LeagueApiClient mLeaguesApiClient;

    public static LeagueRepository getInstance(){
        if (instance == null){
            instance = new LeagueRepository();
        }
        return instance;
    }

    private LeagueRepository(){

        mLeaguesApiClient = LeagueApiClient.getInstance();

    }
    public LiveData<List<LeagueModel>> getLeauges(){
        return mLeaguesApiClient.getLeagues();
    }
    public void searchApi(){
        mLeaguesApiClient.searhLeagueApi();
    }
}
