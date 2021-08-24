package com.example.footballmobileapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.request.RequestOptions;
import com.example.footballmobileapp.adapters.ParticularAdapter;
import com.example.footballmobileapp.models.LeagueModel;
import com.example.footballmobileapp.models.ParticularTeam;
import com.example.footballmobileapp.models.Team;
import com.example.footballmobileapp.requests.LeagueApiClient;

import java.util.List;

public class LastActivtiy extends AppCompatActivity {

    int id;
    private TextView founded, nickeName, address, phone, website, email, color;
    private ImageView image;
    private RecyclerView recyclerView;
    private ParticularAdapter particularAdapter;
    private ProgressBar progressBar, progressBar1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_activtiy);
        founded = findViewById(R.id.textView7);
        image = findViewById(R.id.imageView2);
        nickeName = findViewById(R.id.textView9);
        address = findViewById(R.id.textView11);
        phone = findViewById(R.id.textView14);
        website = findViewById(R.id.website);
        email = findViewById(R.id.email);
        color = findViewById(R.id.color);
        recyclerView = findViewById(R.id.yivon);
        progressBar = findViewById(R.id.progre);
        progressBar1 = findViewById(R.id.imagePogress);



        id = getIntent().getIntExtra("teamsid", -1);



        LeagueApiClient.getInstance().showParticularTeam(new LeagueApiClient.LeagueApiClientListener() {
            @Override
            public void onLeagueApiClientListener(List<LeagueModel> leagueModels1) {

            }

            @Override
            public void onTeamApiClientListener(List<Team> teamList) {

            }

            @Override
            public void onParticularTeam(ParticularTeam particularTeamList) {
                Log.d("particular", particularTeamList.getName());

                progressBar.setVisibility(View.INVISIBLE);
                progressBar1.setVisibility(View.VISIBLE);
                founded.setText(particularTeamList.getFounded());
                if (image != null){
                    GlideApp.with(LastActivtiy.this).load(particularTeamList.getCrestUrl()).apply(RequestOptions.centerCropTransform()).into(image);

                    progressBar1.setVisibility(View.GONE);
                }else {
                    progressBar1.setVisibility(View.VISIBLE);

                }
                nickeName.setText(particularTeamList.getShortName());
                address.setText(particularTeamList.getAddress());
                phone.setText(particularTeamList.getPhone());
                website.setText(particularTeamList.getWebsite());
                email.setText(particularTeamList.getEmail());
                color.setText(particularTeamList.getClubColors());

                if (recyclerView != null){
                    progressBar.setVisibility(View.GONE);
                    particularAdapter = new ParticularAdapter(particularTeamList.getSquad(), LastActivtiy.this);
                    recyclerView.setLayoutManager(new LinearLayoutManager(LastActivtiy.this));
                    recyclerView.setAdapter(particularAdapter);
                }else {
                    progressBar.setVisibility(View.VISIBLE);
                }





            }
        });

    }
}