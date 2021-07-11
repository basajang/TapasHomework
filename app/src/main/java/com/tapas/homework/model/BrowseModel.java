package com.tapas.homework.model;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import java.util.ArrayList;

/*
 * Created by jiHoon on 2021. 7. 10.
 */


public class BrowseModel {

    private long id;

    private PaginationModel pagination;
    private ArrayList<SeriesModel> series;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PaginationModel getPagination() {
        return pagination;
    }

    public void setPagination(PaginationModel pagination) {
        this.pagination = pagination;
    }

    public ArrayList<SeriesModel> getSeries() {
        return series;
    }

    public void setSeries(ArrayList<SeriesModel> series) {
        this.series = series;
    }

    public static DiffUtil.ItemCallback<BrowseModel> DIFF_CALLBACK = new DiffUtil.ItemCallback<BrowseModel>() {
        @Override
        public boolean areItemsTheSame(@NonNull BrowseModel oldItem, @NonNull BrowseModel newItem) {
            return oldItem.id == newItem.id;
        }

        @Override
        public boolean areContentsTheSame(@NonNull BrowseModel oldItem, @NonNull BrowseModel newItem) {
            return oldItem.equals(newItem);
        }
    };
    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;

        BrowseModel browseModel = (BrowseModel) obj;
        return browseModel.getId() == this.id;
    }

    @Override
    public String toString() {
        return "BrowseModel{" +
                "pagination=" + pagination +
                ", series=" + series +
                '}';
    }
}
