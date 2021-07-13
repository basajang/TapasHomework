package com.tapas.homework.model;
/*
 * Created by jiHoon on 2021. 7. 9.
 */

public class GenreModel {

    private int id;
    private String name;
    private String abbr;
    private boolean books ; // If true, then it's a genre for books. If false, then it's a genre for comics.

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public boolean isBooks() {
        return books;
    }

    public void setBooks(boolean books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "GenreModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", abbr='" + abbr + '\'' +
                ", books=" + books +
                '}';
    }
}
