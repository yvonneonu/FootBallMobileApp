package com.example.footballmobileapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.footballmobileapp.ViewModels.LeagueViewModel;
import com.example.footballmobileapp.adapters.LeagueRecyclerView;
import com.example.footballmobileapp.models.LeagueModel;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    private LeagueViewModel viewModel;
    private List<LeagueModel> leagueViewModel;
    Button button2;
    private RecyclerView recyclerView1;
    private LeagueRecyclerView leagueRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button2 = findViewById(R.id.button2);



        recyclerView1 = findViewById(R.id.recylerview2);


        leagueRecyclerAdapter = new LeagueRecyclerView();
        recyclerView1.setAdapter(leagueRecyclerAdapter);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));

        viewModel = new ViewModelProvider(this).get(LeagueViewModel.class);


        viewModel.getlistLiveData().observe(this, leagueModels ->{

            leagueViewModel = leagueModels;
            leagueRecyclerAdapter.setLeagueModels(leagueModels);
                }

                );
       // ConfigureRecyclerView();

       // ObserveAnyChange();


       // searchLeague();
    }


//    private void ObserveAnyChange(){
//        leagueViewModel.getlistLiveData().observe(this, new Observer<List<LeagueModel>>() {
//            @Override
//            public void onChanged(List<LeagueModel> leagueModels) {
//                if (leagueModels != null){
//                    for (LeagueModel leagueModel :leagueModels){
//                        Log.d("TAGGY", "ONCHANGE"+leagueModel.getName());
//                        leagueRecyclerAdapter.setLeagueModels(leagueModels);
//                        //leagueRecyclerAdapter.setLeagueModels(leagueModels);
//                        //leagueRecyclerAdapter.notifyDataSetChanged();
//
//
//                    }
//                }
//            }
//        });
//
//    }

//    private void searchLeague(){
//        leagueViewModel.searchLeague();
//    }

    private void ConfigureRecyclerView(){
       // leagueRecyclerAdapter = new LeagueRecyclerView(this);
        Log.d("recycle", ""+recyclerView1);
        recyclerView1.setAdapter(leagueRecyclerAdapter);

        recyclerView1.setLayoutManager(new LinearLayoutManager(this));

    }

//    @Override
//    public void onLeagueClick(int position) {
//
//    }
//
//    @Override
//    public void onAllLeageCategoryClick(String categoty) {
//
//    }
//    private void fetchLeague(){
//        Call<Competitions> competitionsCall = ApiClient.getService().getCompetitions("X-Auth-Token: 5e7ed5be1554483cbbe403181ce6225");
//
//        competitionsCall.enqueue(new Callback<Competitions>() {
//            @Override
//            public void onResponse(Call<Competitions> call, Response<Competitions> response) {
//                if (response.isSuccessful()){
//
//
//                    Competitions competitions = response.body();
//
//                    competitions.getLeaguesResult().size();
//
//
//                    List<LeagueModel> leagueModels = new ArrayList<>(response.body().getLeaguesResult());
//
//
//                    for (LeagueModel model: leagueModels){
//                        //LeagueModel models = response.body().getLeaguesResult().get(model).getName();
//                      //  models.size()
//                        Log.d("Tag", "allTea"+model.getName());
//
//                    }
//
//                }else {
//                    try {
//                        Log.v("AllTag", "Error"+response.errorBody().string());
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Competitions> call, Throwable t) {
//
//
//
//            }
//        });
//    }

}