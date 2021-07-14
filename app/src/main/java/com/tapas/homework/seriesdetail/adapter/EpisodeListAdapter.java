package com.tapas.homework.seriesdetail.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tapas.homework.R;
import com.tapas.homework.model.EpisodeModel;
import com.tapas.homework.seriesdetail.viewholder.EpisodeListViewHolder;
import com.tapas.homework.seriesdetail.viewholder.EpisodeViewHolder;
import com.tapas.homework.seriesdetail.viewholder.InfoViewHolder;

import java.util.ArrayList;
import java.util.List;

public class EpisodeListAdapter extends RecyclerView.Adapter<EpisodeViewHolder> {

    private List<EpisodeModel> episodeModelList = new ArrayList<>();

    @NonNull
    @Override
    public EpisodeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rowEpisode = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_episode, parent, false);
        return new EpisodeViewHolder(rowEpisode);
    }

    @Override
    public void onBindViewHolder(@NonNull  EpisodeViewHolder holder, int position) {
        holder.bind(episodeModelList.get(position));
    }

    @Override
    public int getItemCount() {
        return episodeModelList.size();
    }

    public void addList(EpisodeModel episodeModel){
        episodeModelList.add(episodeModel);
        notifyDataSetChanged();
    }

    public void setEpisodeModelList(List<EpisodeModel> episodeModelList) {
        this.episodeModelList = episodeModelList;
        notifyDataSetChanged();
    }
}
