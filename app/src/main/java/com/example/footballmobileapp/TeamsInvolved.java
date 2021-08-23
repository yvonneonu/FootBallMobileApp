package com.example.footballmobileapp;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.footballmobileapp.adapters.TeamsAdapter;
import com.example.footballmobileapp.models.LeagueModel;
import com.example.footballmobileapp.models.Team;
import com.example.footballmobileapp.requests.LeagueApiClient;

import java.util.List;

public class TeamsInvolved extends AppCompatActivity {

    private int id;
    private RecyclerView recyclerView1;
    private TeamsAdapter teamsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams_involved);

        id = getIntent().getIntExtra("competitionId", -1);
        Log.d("teamsId", ""+id);
        recyclerView1 = findViewById(R.id.teamRecylerView);

        LeagueApiClient.getInstance().showTeams(2001, new LeagueApiClient.LeagueApiClientListener() {
            @Override
            public void onLeagueApiClientListener(List<LeagueModel> leagueModels1) {
            }

            @Override
            public void onTeamApiClientListener(List<Team> teamList) {
                Log.d("fetctheTeam", ""+teamList.size());


            }
        });




    }
}