package com.example.footballmobileapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.footballmobileapp.R;
import com.example.footballmobileapp.models.Squad;

import java.text.SimpleDateFormat;
import java.util.Date;
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
        holder.textView.setText(squad.getName());
        holder.position.setText(squad.getPosition());
        holder.country.setText(squad.getNationality());
       // holder.dateOfBirth.setText(squad.getDateOfBirth());

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("YY/MM/dd");

        holder.dateOfBirth.setText(dateFormat.format(date));
    }

    @Override
    public int getItemCount() {
        return squadList.size();
    }

    public class ParicularHolder extends RecyclerView.ViewHolder {

        TextView textView, position, country, dateOfBirth;

        public ParicularHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView18);
            position = itemView.findViewById(R.id.textView20);
            country = itemView.findViewById(R.id.textView19);
            dateOfBirth = itemView.findViewById(R.id.textView21);

        }
    }
}
