package com.example.footballmobileapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.footballmobileapp.R;
import com.example.footballmobileapp.models.LeagueModel;

import java.util.ArrayList;
import java.util.List;

public class LeagueRecyclerView extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<LeagueModel> leagueModels = new ArrayList<>();
    private OnLeagueListerner onLeagueListerner;



    public LeagueRecyclerView(OnLeagueListerner onLeagueListerner) {
        this.onLeagueListerner = onLeagueListerner;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.competitionscreen, parent, false);

        return new LeagueViewHolder(view, onLeagueListerner);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((LeagueViewHolder)holder).textView.setText(leagueModels.get(position).getName());
        ((LeagueViewHolder)holder).textView2.setText(leagueModels.get(position).getCountryName().getName());
        ((LeagueViewHolder)holder).textView2.setText(leagueModels.get(position).getCurrentSeason().getStartDate());



    }

    @Override
    public int getItemCount() {
        if (leagueModels != null){
            return leagueModels.size();

        }

        return 0;
    }

    public void setLeagueModels(List<LeagueModel> leagueModels) {
        this.leagueModels = leagueModels;
        notifyDataSetChanged();
    }
}
