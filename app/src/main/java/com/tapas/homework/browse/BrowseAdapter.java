package com.tapas.homework.browse;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;

import com.tapas.homework.R;

import com.tapas.homework.model.BrowseModel;
import com.tapas.homework.model.SeriesModel;
import com.tapas.homework.util.Logger;

/*
 * Created by jiHoon on 2021. 7. 10.
 */

public class BrowseAdapter extends PagedListAdapter<SeriesModel,SeriesViewHolder> {
    private final String TAG = this.getClass().getSimpleName();
    private Activity activity;
    private int visibleCount = 0;

    public BrowseAdapter( Activity activity) {
        super(SeriesModel.DIFF_CALLBACK);
        this.activity = activity;
    }

    @NonNull
    @Override
    public SeriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SeriesViewHolder(LayoutInflater.from(activity).inflate(R.layout.row_series, parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull SeriesViewHolder holder, int position) {
        holder.bind(getItem(position));
    }
}
