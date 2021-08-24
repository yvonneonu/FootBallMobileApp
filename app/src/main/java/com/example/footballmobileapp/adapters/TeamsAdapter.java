package com.example.footballmobileapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.request.RequestOptions;
import com.example.footballmobileapp.GlideApp;
import com.example.footballmobileapp.R;
import com.example.footballmobileapp.models.Team;

import java.util.List;

public class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.TeamHolder> {
    List<Team> teamList;
    Context context;
    OnParticularListener onParticularListener;

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

        if (team.getImgUrl() != null){
           if (!team.getImgUrl().isEmpty()){
               GlideApp.with(context).load(team.getImgUrl()).apply(RequestOptions.centerCropTransform()).into(holder.imageView);
           }

        }



    }


    @Override
    public int getItemCount() {
        return teamList.size();
    }

    public class TeamHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        CardView cardView;

        public TeamHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.teamsmg);
            cardView = itemView.findViewById(R.id.cardViewTeams);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onParticularListener != null){
                        int pos = getAdapterPosition();
                        if (pos != RecyclerView.NO_POSITION){
                            onParticularListener.onParticularClick(pos);
                        }
                    }
                }
            });


        }
    }

    public void teamResponder(OnParticularListener onParticularListener1){
        this.onParticularListener = onParticularListener1;


    }
   public interface OnParticularListener{
        void onParticularClick(int poistion);
    }
}
