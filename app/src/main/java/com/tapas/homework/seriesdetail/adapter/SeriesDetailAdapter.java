package com.tapas.homework.seriesdetail.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tapas.homework.R;
import com.tapas.homework.model.SeriesModel;
import com.tapas.homework.seriesdetail.viewholder.EpisodeListViewHolder;
import com.tapas.homework.seriesdetail.viewholder.InfoViewHolder;
import com.tapas.homework.seriesdetail.viewholder.StateViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by james on 2021-07-13.
 */
public class SeriesDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int INFO = 0;
    public static final int STATE = 1;
    public static final int EPISODE = 2;

    private Activity activity;

    private List<Integer> typeList = new ArrayList<>();

    private SeriesModel model;

    public SeriesDetailAdapter(Activity activity, SeriesModel model) {
        this.activity = activity;
        this.model = model;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        switch (viewType) {
            case INFO:
                View rowSeriesDetailInfo = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.row_series_detail_info, parent, false);
                return new InfoViewHolder(rowSeriesDetailInfo);
            case STATE:
                View rowSeriesDetailState = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.row_series_detail_state, parent, false);
                return new StateViewHolder(rowSeriesDetailState);
            case EPISODE:
                View rowSeriesDetailEpisode = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.row_series_detail_episode, parent, false);
                return new EpisodeListViewHolder(rowSeriesDetailEpisode);

            default:
                return null;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        switch (holder.getItemViewType()){
            case INFO:
                ((InfoViewHolder)holder).bind(model, activity);
                break;
            case STATE:
                ((StateViewHolder)holder).bind(model);
                break;
            case EPISODE:
                ((EpisodeListViewHolder)holder).bind(model);
                break;
        }

    }

    @Override
    public int getItemCount() {
        return typeList.size();
    }


    @Override
    public int getItemViewType(int position) {
        return typeList.get(position);
    }

    public void setTypeList(List<Integer> typeList) {
        this.typeList = typeList;
    }

    public void addTypeList(int type) {
        typeList.add(type);
    }
}
