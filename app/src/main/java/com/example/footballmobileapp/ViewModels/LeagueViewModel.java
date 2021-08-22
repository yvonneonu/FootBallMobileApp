package com.example.footballmobileapp.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.footballmobileapp.models.LeagueModel;
import com.example.footballmobileapp.repositories.LeagueRepository;

import java.util.List;

public class LeagueViewModel extends ViewModel {

    private LeagueRepository leagueRepository;

    public LeagueViewModel() {
        leagueRepository = LeagueRepository.getInstance();
    }
    public LiveData<List<LeagueModel>> getlistLiveData(){
        return leagueRepository.getLeauges();
    }
    public void searchLeague(){
        leagueRepository.searchApi();
    }
}
