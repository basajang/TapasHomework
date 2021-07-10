package com.tapas.homework.model;

import java.util.ArrayList;

/*
 * Created by jiHoon on 2021. 7. 10.
 */


public class BrowseModel {
    private PaginationModel pagination;
    private ArrayList<SeriesModel> series;

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

    @Override
    public String toString() {
        return "BrowseModel{" +
                "pagination=" + pagination +
                ", series=" + series +
                '}';
    }
}
