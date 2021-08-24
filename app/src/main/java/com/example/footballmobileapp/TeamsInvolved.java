package com.example.footballmobileapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.footballmobileapp.adapters.TeamsAdapter;
import com.example.footballmobileapp.models.LeagueModel;
import com.example.footballmobileapp.models.ParticularTeam;
import com.example.footballmobileapp.models.Team;
import com.example.footballmobileapp.requests.LeagueApiClient;

import java.util.List;

public class TeamsInvolved extends AppCompatActivity {

    private int id;
    private RecyclerView recyclerView1;
    private TeamsAdapter teamsAdapter;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams_involved);

        id = getIntent().getIntExtra("competitionId", -1);
        Log.d("teamsId", ""+id);
        recyclerView1 = findViewById(R.id.teamRecylerView);
        progressBar = findViewById(R.id.progress1);

        progressBar.setVisibility(View.VISIBLE);
        LeagueApiClient.getInstance().showTeams(2001, new LeagueApiClient.LeagueApiClientListener() {
            @Override
            public void onLeagueApiClientListener(List<LeagueModel> leagueModels1) {

                Log.d("teamsId", "leag");
            }

            @Override
            public void onTeamApiClientListener(List<Team> teamList) {
                Log.d("fetctheTeam", ""+teamList.size());

                    progressBar.setVisibility(View.GONE);

               teamsAdapter = new TeamsAdapter(teamList, TeamsInvolved.this);
               recyclerView1.setAdapter(teamsAdapter);
               recyclerView1.setLayoutManager(new GridLayoutManager(TeamsInvolved.this, 3));

               teamList.get(1).getImgUrl();
               Log.d("imge", teamList.get(1).getImgUrl());

                teamsAdapter.teamResponder(new TeamsAdapter.OnParticularListener() {
                    @Override
                    public void onParticularClick(int poistion) {

                        Team team = teamList.get(poistion);
                        int id = team.getId();
                        Intent intent = new Intent(TeamsInvolved.this, LastActivtiy.class);
                        intent.putExtra("teamsid", id);
                        Log.d("particularid", ""+id);
                        startActivity(intent);
                    }
                });

            }

            @Override
            public void onParticularTeam(ParticularTeam particularTeamList) {

            }
        });


    }


}