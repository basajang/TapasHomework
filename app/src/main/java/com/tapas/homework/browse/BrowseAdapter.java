package com.tapas.homework.browse;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tapas.homework.R;
import com.tapas.homework.model.SeriesModel;

import java.util.ArrayList;
/*
 * Created by jiHoon on 2021. 7. 10.
 */

public class BrowseAdapter extends RecyclerView.Adapter<SeriesViewHolder>{
    private final String TAG = this.getClass().getSimpleName();
    private Activity activity;
    private ArrayList<SeriesModel> seriesModelList = new ArrayList<>();
    private int visibleCount = 0;


    public BrowseAdapter(Activity activity) {
        this.activity = activity;
    }

    @NonNull
    @Override
    public SeriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SeriesViewHolder(LayoutInflater.from(activity).inflate(R.layout.row_series, parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull SeriesViewHolder holder, int position) {

        holder.bind(seriesModelList.get(position));
    }

    @Override
    public int getItemCount() {

        return seriesModelList.size();
    }


    public void addItemList(ArrayList<SeriesModel> modelList){


        seriesModelList.addAll(modelList);
        if(visibleCount == 0){
            notifyDataSetChanged();
            visibleCount = modelList.size();
        }else{
            notifyItemRangeInserted(visibleCount, modelList.size());
        }

    }


    public ArrayList<SeriesModel> getSeriesModelList() {
        return seriesModelList;
    }
}
