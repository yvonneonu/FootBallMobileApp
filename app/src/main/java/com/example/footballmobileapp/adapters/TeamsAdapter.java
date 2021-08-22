package com.example.footballmobileapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.footballmobileapp.R;
import com.example.footballmobileapp.models.Team;

import java.util.List;

public class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.TeamHolder> {
    List<Team> teamList;
    Context context;

    public TeamsAdapter(List<Team> teamList, Context context) {
        this.teamList = teamList;
        this.context = context;
    }

    @NonNull
    @Override
    public TeamHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.teamsflag,parent,false);
        return new TeamHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamsAdapter.TeamHolder holder, int position) {

        Team team = teamList.get(position);
        Glide.with(context)
                .asBitmap()
                .load(team.getImgUrl())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return teamList.size();
    }

    public class TeamHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        public TeamHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.teamsmg);
        }
    }
}
