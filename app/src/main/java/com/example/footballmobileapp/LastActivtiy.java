package com.example.footballmobileapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.request.RequestOptions;
import com.example.footballmobileapp.models.LeagueModel;
import com.example.footballmobileapp.models.ParticularTeam;
import com.example.footballmobileapp.models.Team;
import com.example.footballmobileapp.requests.LeagueApiClient;

import java.util.List;

public class LastActivtiy extends AppCompatActivity {

    int id;
    private TextView founded, nickeName, address, phone, website;
    private ImageView image;



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

                founded.setText(particularTeamList.getFounded());
                GlideApp.with(LastActivtiy.this).load(particularTeamList.getCrestUrl()).apply(RequestOptions.centerCropTransform()).into(image);
                nickeName.setText(particularTeamList.getShortName());
                address.setText(particularTeamList.getAddress());
                phone.setText(particularTeamList.getPhone());
                website.setText(particularTeamList.getWebsite());

            }
        });

    }
}