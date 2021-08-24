package com.example.footballmobileapp.requests;

import android.util.Log;

import com.example.footballmobileapp.ApiClient;
import com.example.footballmobileapp.AppExecuters;
import com.example.footballmobileapp.Competitions;
import com.example.footballmobileapp.models.LeagueModel;
import com.example.footballmobileapp.models.Team;
import com.example.footballmobileapp.models.TeamModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LeagueApiClient {
    private List<LeagueModel> mLeagues;
    private RetrieveLeagueRunnable retrieveLeagueRunnable;

    private static LeagueApiClient instance;

    public static LeagueApiClient getInstance(){
        if (instance == null){
            instance = new LeagueApiClient();
        }
        return instance;
    }

    private LeagueApiClient(){
        mLeagues = new ArrayList<>();

    }
//    public LiveData<List<LeagueModel>> getLeagues(){
//        return mLeagues;
//    }


    public void searhLeagueApi(LeagueApiClientListener leagueApiClientListener){
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


                           // mLeagues..postValue(leagueModels);
                            leagueApiClientListener.onLeagueApiClientListener(leagueModels);

                            for (LeagueModel model: leagueModels){

                                Log.d("Tag", "allTea" +model.getId());
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
        }, 5000, TimeUnit.MILLISECONDS);


    }

    //"X-Auth-Token: 345a424d790a4e2393201f16367a6e46",

  //  public void
    public void showTeams(int id, LeagueApiClientListener leagueApiClientListener){
        Call<TeamModel> teamModelCall = ApiClient.getService().getParticularCompetition( id);
        teamModelCall.enqueue(new Callback<TeamModel>() {
            @Override
            public void onResponse(Call<TeamModel> call, Response<TeamModel> response) {
                if (response.isSuccessful()){
                    TeamModel teams = response.body();
//                    Log.d("modelTeam", ""+teams.getTeams().size());

                }
            }

            @Override
            public void onFailure(Call<TeamModel> call, Throwable t) {

            }
        });



//        Call<List<Team>> teamsCall = ApiClient.getService().getParticularCompetition(id, "X-Auth-Token: dfea7ef6599d45e0a238f362c9d75744");
//        teamsCall.enqueue(new Callback<List<Team>>() {
//            @Override
//            public void onResponse(Call<List<Team>> call, Response<List<Team>> response) {
//
//                if (response.isSuccessful()){
//                    List<Team> teamList = response.body();
//
//                    teamList.size();
//
//                    Log.d("teamslist", ""+teamList.size());
//
//
//                    //List<LeagueModel> leagueModels = new ArrayList<>(response.body().getLeaguesResult());
//
//
//                    // mLeagues..postValue(leagueModels);
//                    leagueApiClientListener.onTeamApiClientListener(teamList);
//
////                    for (LeagueModel model: leagueModels){
////
////                        Log.d("Tag", "allTea" +model.getName());
////                        Log.d("Area", "getAllArea" +model.getCountryName().getName());
////                        //    Log.d("Area", "getAllCurrentSeasion" +model.getCurrentSeason().getStartDate());
////
////
////
////                    }
//
//                }else {
//                    try {
//                        assert response.errorBody() != null;
//                        Log.v("AllTag", "Error"+response.errorBody().string());
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//
//
//            @Override
//            public void onFailure(Call<List<Team>> call, Throwable t) {
//                Log.d("failure", ""+t.getMessage());
//
//            }
//        });
//


    }
    //retreving data from ResApi by runnabl class
    private class RetrieveLeagueRunnable implements Runnable {


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


                        // mLeagues..postValue(leagueModels);
                        //leagueApiClientListener.onLeagueApiClientListener(leagueModels);

                        for (LeagueModel model: leagueModels){

                            Log.d("Tag", "allTea" +model.getName());
                            Log.d("Area", "getAllArea" +model.getCountryName().getName());
                            //    Log.d("Area", "getAllCurrentSeasion" +model.getCurrentSeason().getStartDate());



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

    public interface LeagueApiClientListener{
       void onLeagueApiClientListener(List<LeagueModel> leagueModels1);

       void onTeamApiClientListener(List<Team> teamList);
    }

}
