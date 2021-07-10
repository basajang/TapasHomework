package com.tapas.homework.model;
/*
 * Created by jiHoon on 2021. 7. 9.
 */

public class PaginationModel {
    private int page  = 1;
    private boolean has_next = true;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public boolean isHas_next() {
        return has_next;
    }

    public void setHas_next(boolean has_next) {
        this.has_next = has_next;
    }

    @Override
    public String toString() {
        return "PaginationModel{" +
                "page=" + page +
                ", has_next=" + has_next +
                '}';
    }
}
