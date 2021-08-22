package com.example.footballmobileapp.requests;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.footballmobileapp.ApiClient;
import com.example.footballmobileapp.AppExecuters;
import com.example.footballmobileapp.Competitions;
import com.example.footballmobileapp.models.LeagueModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LeagueApiClient {
    private MutableLiveData<List<LeagueModel>> mLeagues;
    private RetrieveLeagueRunnable retrieveLeagueRunnable;

    private static LeagueApiClient instance;

    public static LeagueApiClient getInstance(){
        if (instance == null){
            instance = new LeagueApiClient();
        }
        return instance;
    }

    private LeagueApiClient(){
        mLeagues = new MutableLiveData<>();

    }
    public LiveData<List<LeagueModel>> getLeagues(){
        return mLeagues;
    }


    public void searhLeagueApi(){
        if (retrieveLeagueRunnable != null){
            retrieveLeagueRunnable = null;
        }
        retrieveLeagueRunnable = new RetrieveLeagueRunnable();
        final Future myHandler = AppExecuters.getInstance().networkIO().submit(new Runnable() {
            @Override
            public void run() {
                Call<Competitions> competitionsCall = ApiClient.getService().getCompetitions("X-Auth-Token: dfea7ef6599d45e0a238f362c9d75744");

                competitionsCall.enqueue(new Callback<Competitions>() {
                    @Override
                    public void onResponse(Call<Competitions> call, Response<Competitions> response) {
                        if (response.isSuccessful()){


                            Competitions competitions = response.body();

                            competitions.getLeaguesResult().size();


                            List<LeagueModel> leagueModels = new ArrayList<>(response.body().getLeaguesResult());


                            for (LeagueModel model: leagueModels){

                                Log.d("Tag", "allTea" +model.getName());
                                Log.d("Area", "getAllArea" +model.getCountryName().getName());
                            //    Log.d("Area", "getAllCurrentSeasion" +model.getCurrentSeason().getStartDate());



                            }

                        }else {
                            try {
                                assert response.errorBody() != null;
                                Log.v("AllTag", "Error"+response.errorBody().string());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<Competitions> call, Throwable t) {



                    }
                });
            }
        });

        AppExecuters.getInstance().networkIO().schedule(new Runnable() {
            @Override
            public void run() {

                myHandler.cancel(true);
                //cancelling the retrofit
            }
        }, 3000, TimeUnit.MILLISECONDS);


    }
    //retreving data from ResApi by runnabl class
    private class RetrieveLeagueRunnable implements Runnable {


        @Override
        public void run() {

            Call<Competitions> competitionsCall = ApiClient.getService().getCompetitions("X-Auth-Token: 345a424d790a4e2393201f16367a6e46");

            competitionsCall.enqueue(new Callback<Competitions>() {
                @Override
                public void onResponse(Call<Competitions> call, Response<Competitions> response) {
                    if (response.isSuccessful()){


                        Competitions competitions = response.body();

                        competitions.getLeaguesResult().size();


                        List<LeagueModel> leagueModels = new ArrayList<>(response.body().getLeaguesResult());



                        for (LeagueModel model: leagueModels){
                            //LeagueModel models = response.body().getLeaguesResult().get(model).getName();
                            //  models.size()
                            Log.d("Tag", "allTea"+model.getName());

                        }

                    }else {
                        try {
                            Log.v("AllTag", "Error"+response.errorBody().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

                @Override
                public void onFailure(Call<Competitions> call, Throwable t) {



                }
            });
        }

    }

}
