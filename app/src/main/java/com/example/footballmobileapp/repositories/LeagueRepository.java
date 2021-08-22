package com.example.footballmobileapp.repositories;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.footballmobileapp.models.LeagueModel;
import com.example.footballmobileapp.requests.LeagueApiClient;

import java.util.ArrayList;
import java.util.List;

public class LeagueRepository {
    private static LeagueRepository instance;
    private MutableLiveData<List<LeagueModel>> mutableLiveData;

    private LeagueApiClient mLeaguesApiClient;

    public static LeagueRepository getInstance(){
        if (instance == null){
            instance = new LeagueRepository();
        }
        return instance;
    }

    private LeagueRepository(){
        mutableLiveData = new MutableLiveData<>();

        mLeaguesApiClient = LeagueApiClient.getInstance();
//        mLeaguesApiClient.searhLeagueApi(new LeagueApiClient.LeagueApiClientListener() {
//            @Override
//            public MutableLiveData<List<LeagueModel>> onLeagueApiClientListener(MutableLiveData<List<LeagueModel>> liveData) {
//                mutableLiveData = liveData;
//                Log.d("mutables", ""+mutableLiveData.toString());
//                return liveData;
//            }
//        });


    }
    public List<LeagueModel> list(){
        //List n
        return new ArrayList<>();
    }
    public MutableLiveData<List<LeagueModel>> getLeauges(){
       Log.d("getLeague", "anything" );
    //   mutableLiveData.getValue().size();
        return mutableLiveData;
    }


//    public void getApi(){
//        mLeaguesApiClient.searhLeagueApi();
//    }
}
