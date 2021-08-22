package com.example.footballmobileapp.adapters;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.footballmobileapp.R;

public class LeagueViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView textView, textView2, textView4;
    OnLeagueListerner onLeagueListerner;


    public LeagueViewHolder(@NonNull View itemView, OnLeagueListerner onLeagueListerner) {
        super(itemView);
        textView = itemView.findViewById(R.id.textView);
        textView2 = itemView.findViewById(R.id.textView2);
        textView4 = itemView.findViewById(R.id.textView4);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        onLeagueListerner.onLeagueClick(getAdapterPosition());

    }
}
