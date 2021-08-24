package com.example.footballmobileapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.footballmobileapp.R;
import com.example.footballmobileapp.models.Squad;

import java.util.List;

public class ParticularAdapter extends RecyclerView.Adapter<ParticularAdapter.ParicularHolder> {

    List<Squad> squadList;
    Context context;

    public ParticularAdapter(List<Squad> squadList, Context context) {
        this.squadList = squadList;
        this.context = context;
    }

    @NonNull
    @Override
    public ParicularHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.particularteamplayers, parent, false);

        return new ParicularHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ParticularAdapter.ParicularHolder holder, int position) {

        Squad squad = squadList.get(position);
    }

    @Override
    public int getItemCount() {
        return squadList.size();
    }

    public class ParicularHolder extends RecyclerView.ViewHolder {

        public ParicularHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
