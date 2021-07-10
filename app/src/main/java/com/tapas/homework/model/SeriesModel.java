package com.tapas.homework.model;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by jiHoon on 2021. 7. 9.
 */


public class SeriesModel {
    private int id;
    private String title;
    private String sale_type;
    private ThumbModel thumb; // Use thumbnail information if book_cover_url is invalid
    private String book_cover_url;
    private List<CreatorModel> creators = new ArrayList<>();
    private int age_rating;
    private String rgb_hex;

    private boolean restricted; // If true, the series is restricted and thus is not available for your region.
    private String restricted_msg;

    private boolean onSale;
    private int discount_rate;
    private String sale_start_date;
    private String sale_end_date;

    private int subscribe_cnt; // The number of subscribers on a series
    private int like_cnt;
    private int view_cnt;

    private boolean up;

    private String blurb;
    private String sub_title;
    private GenreModel genre;

    private String rect_banner_url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSale_type() {
        return sale_type;
    }

    public void setSale_type(String sale_type) {
        this.sale_type = sale_type;
    }

    public ThumbModel getThumb() {
        return thumb;
    }

    public void setThumb(ThumbModel thumb) {
        this.thumb = thumb;
    }

    public String getBook_cover_url() {
        return book_cover_url;
    }

    public void setBook_cover_url(String book_cover_url) {
        this.book_cover_url = book_cover_url;
    }

    public List<CreatorModel> getCreators() {
        return creators;
    }

    public void setCreators(List<CreatorModel> creators) {
        this.creators = creators;
    }

    public int getAge_rating() {
        return age_rating;
    }

    public void setAge_rating(int age_rating) {
        this.age_rating = age_rating;
    }

    public String getRgb_hex() {
        return rgb_hex;
    }

    public void setRgb_hex(String rgb_hex) {
        this.rgb_hex = rgb_hex;
    }

    public boolean isRestricted() {
        return restricted;
    }

    public void setRestricted(boolean restricted) {
        this.restricted = restricted;
    }

    public String getRestricted_msg() {
        return restricted_msg;
    }

    public void setRestricted_msg(String restricted_msg) {
        this.restricted_msg = restricted_msg;
    }

    public boolean isOnSale() {
        return onSale;
    }

    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }

    public int getDiscount_rate() {
        return discount_rate;
    }

    public void setDiscount_rate(int discount_rate) {
        this.discount_rate = discount_rate;
    }

    public String getSale_start_date() {
        return sale_start_date;
    }

    public void setSale_start_date(String sale_start_date) {
        this.sale_start_date = sale_start_date;
    }

    public String getSale_end_date() {
        return sale_end_date;
    }

    public void setSale_end_date(String sale_end_date) {
        this.sale_end_date = sale_end_date;
    }

    public int getSubscribe_cnt() {
        return subscribe_cnt;
    }

    public void setSubscribe_cnt(int subscribe_cnt) {
        this.subscribe_cnt = subscribe_cnt;
    }

    public int getLike_cnt() {
        return like_cnt;
    }

    public void setLike_cnt(int like_cnt) {
        this.like_cnt = like_cnt;
    }

    public int getView_cnt() {
        return view_cnt;
    }

    public void setView_cnt(int view_cnt) {
        this.view_cnt = view_cnt;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public String getBlurb() {
        return blurb;
    }

    public void setBlurb(String blurb) {
        this.blurb = blurb;
    }

    public String getSub_title() {
        return sub_title;
    }

    public void setSub_title(String sub_title) {
        this.sub_title = sub_title;
    }

    public GenreModel getGenre() {
        return genre;
    }

    public void setGenre(GenreModel genre) {
        this.genre = genre;
    }

    public String getRect_banner_url() {
        return rect_banner_url;
    }

    public void setRect_banner_url(String rect_banner_url) {
        this.rect_banner_url = rect_banner_url;
    }

    @Override
    public String toString() {
        return "SeriesModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", sale_type='" + sale_type + '\'' +
                ", thumb=" + thumb +
                ", book_cover_url='" + book_cover_url + '\'' +
                ", creators=" + creators +
                ", age_rating=" + age_rating +
                ", rgb_hex='" + rgb_hex + '\'' +
                ", restricted=" + restricted +
                ", restricted_msg='" + restricted_msg + '\'' +
                ", onSale=" + onSale +
                ", discount_rate=" + discount_rate +
                ", sale_start_date='" + sale_start_date + '\'' +
                ", sale_end_date='" + sale_end_date + '\'' +
                ", subscribe_cnt=" + subscribe_cnt +
                ", like_cnt=" + like_cnt +
                ", view_cnt=" + view_cnt +
                ", up=" + up +
                ", blurb='" + blurb + '\'' +
                ", sub_title='" + sub_title + '\'' +
                ", genre=" + genre +
                ", rect_banner_url='" + rect_banner_url + '\'' +
                '}';
    }
}
