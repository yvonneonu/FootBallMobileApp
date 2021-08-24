package com.example.footballmobileapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.request.RequestOptions;
import com.example.footballmobileapp.GlideApp;
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


        GlideApp.with(context).load(team.getImgUrl()).apply(RequestOptions.centerCropTransform()).into(holder.imageView);



//        holder.imageView.S
//        //holder.imageView.setImageURI(Uri.parse("https://cdn.pixabay.com/photo/2021/08/11/16/39/parking-lot-6538926_1280.jpg"));
//        Glide.with(context)
//                .as()
//                .asBitmap()
//                .load(Uri.parse("https://cdn.pixabay.com/photo/2021/08/11/16/39/parking-lot-6538926_1280.jpg"))
//                .into(holder.imageView);
//        Uri uri = Uri.parse(team.getImgUrl());
//        //requestBuilder
//                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
//                // SVG cannot be serialized so it's not worth to cache it
//                .load(uri)
//                .into(holder.imageView);

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
