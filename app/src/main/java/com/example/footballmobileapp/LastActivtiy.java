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
    private ProgressBar progressBar1;





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
       // color = findViewById(R.id.color);
        recyclerView = findViewById(R.id.yivon);
        progressBar1 = findViewById(R.id.imagePogress);



        id = getIntent().getIntExtra("teamsid", -1);



        progressBar1.setVisibility(View.VISIBLE);


        LeagueApiClient.getInstance().showParticularTeam(id, new LeagueApiClient.LeagueApiClientListener() {
            @Override
            public void onLeagueApiClientListener(List<LeagueModel> leagueModels1) {

            }

            @Override
            public void onTeamApiClientListener(List<Team> teamList) {

            }

            @Override
            public void onParticularTeam(ParticularTeam particularTeamList) {
                Log.d("particular", particularTeamList.getName());


                progressBar1.setVisibility(View.GONE);

                founded.setText(particularTeamList.getFounded());


                    GlideApp.with(LastActivtiy.this).load(particularTeamList.getCrestUrl()).apply(RequestOptions.centerCropTransform()).into(image);


                nickeName.setText(particularTeamList.getShortName());
                address.setText(particularTeamList.getAddress());
                phone.setText(particularTeamList.getPhone());
                website.setText(particularTeamList.getWebsite());
                email.setText(particularTeamList.getEmail());
                //color.setText(particularTeamList.getClubColors());



                    particularAdapter = new ParticularAdapter(particularTeamList.getSquad(), LastActivtiy.this);
                    recyclerView.setLayoutManager(new LinearLayoutManager(LastActivtiy.this));
                    recyclerView.setAdapter(particularAdapter);






            }
        });

    }

    public void back(View view) {
        finish();
    }
}