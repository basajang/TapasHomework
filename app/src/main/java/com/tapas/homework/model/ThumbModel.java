package com.tapas.homework.model;/*
 * Created by jiHoon on 2021. 7. 9.
 */

public class ThumbModel {
    private int width;
    private int height;
    private int file_size;
    private String file_url;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getFile_size() {
        return file_size;
    }

    public void setFile_size(int file_size) {
        this.file_size = file_size;
    }

    public String getFile_url() {
        return file_url;
    }

    public void setFile_url(String file_url) {
        this.file_url = file_url;
    }

    @Override
    public String toString() {
        return "ThumbModel{" +
                "width=" + width +
                ", height=" + height +
                ", file_size=" + file_size +
                ", file_url='" + file_url + '\'' +
                '}';
    }
}
