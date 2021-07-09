package com.tapas.homework.model;
/*
 * Created by jiHoon on 2021. 7. 9.
 */

import java.util.List;

public class BrowseModel {
    private PaginationModel pagination;
    private List<SeriesModel> series;

    public PaginationModel getPagination() {
        return pagination;
    }

    public void setPagination(PaginationModel pagination) {
        this.pagination = pagination;
    }

    public List<SeriesModel> getSeries() {
        return series;
    }

    public void setSeries(List<SeriesModel> series) {
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
