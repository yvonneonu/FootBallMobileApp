package com.example.footballmobileapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.footballmobileapp.R;
import com.example.footballmobileapp.models.LeagueModel;

import java.util.ArrayList;
import java.util.List;

public class LeagueRecyclerView extends RecyclerView.Adapter<LeagueRecyclerView.TaskHolder> {

    private List<LeagueModel> leagueModels = new ArrayList<>();
    private OnLeagueListerner onLeagueListerner;

    public LeagueRecyclerView(List<LeagueModel> leagueModels) {
        this.leagueModels = leagueModels;
    }

    @NonNull
    @Override
    public TaskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.competitionscreen,parent,false);
        return new TaskHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LeagueRecyclerView.TaskHolder holder, int position) {

        final LeagueModel model = leagueModels.get(position);
        holder.textView2.setText(model.getName());
        holder.textView.setText(model.getCountryName().getName());
        if (model.getCurrentSeason() != null){
            holder.textView4.setText(model.getCurrentSeason().getStartDate());
        }


    }

    @Override
    public int getItemCount() {
        return leagueModels.size();
    }

    public void setLeagueModels(List<LeagueModel> leagueModel){
        leagueModels = leagueModel;
        notifyDataSetChanged();
    }
    public class TaskHolder extends RecyclerView.ViewHolder {

        TextView textView, textView2, textView4;
        CardView cardView;

        public TaskHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2);
       textView4 = itemView.findViewById(R.id.textView4);
       cardView = itemView.findViewById(R.id.cardview);

       cardView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if (onLeagueListerner != null){
                   int pos = getAdapterPosition();
                   if (pos != RecyclerView.NO_POSITION){
                       onLeagueListerner.onLeagueClick(pos);
                   }
               }
           }
       });
        }

    }

    public void setListener(OnLeagueListerner onLeagueListerner){
        this.onLeagueListerner = onLeagueListerner;


    }

    public interface OnLeagueListerner {
        void onLeagueClick(int position);

        void onAllLeageCategoryClick(String categoty);

    }

////    public LeagueRecyclerView(OnLeagueListerner onLeagueListerner) {
////        this.onLeagueListerner = onLeagueListerner;
////    }
//
////    @NonNull
////    @Override
////    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
////        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.competitionscreen, parent, false);
////
////        return new RecyclerView.ViewHolder(view, onLeagueListerner) {
////        };
////    }
////
////    @Override
////    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
////        ((LeagueViewHolder)holder).textView.setText(leagueModels.get(position).getName());
////        ((LeagueViewHolder)holder).textView2.setText(leagueModels.get(position).getCountryName().getName());
////        ((LeagueViewHolder)holder).textView2.setText(leagueModels.get(position).getCurrentSeason().getStartDate());
////
////
////
////    }
//
//    @NonNull
//    @Override
//    public LeagueRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.competitionscreen, parent, false);
//        return new LeagueRecyclerView(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull LeagueRecyclerView.ViewHolder holder, int position) {
//
//    }
//
//    @Override
//    public int getItemCount() {
//        if (leagueModels != null){
//            return leagueModels.size();
//
//        }
//
//        return 0;
//    }
//
//    public void setLeagueModels(List<LeagueModel> leagueModels) {
//        this.leagueModels = leagueModels;
//        notifyDataSetChanged();
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder {
//    }
}
