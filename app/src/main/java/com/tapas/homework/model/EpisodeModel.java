package com.tapas.homework.model;
/*
 * Created by jiHoon on 2021. 7. 10.
 */

public class EpisodeModel {
    private int id;
    private String title;
    private int scene;
    private boolean free;
    private boolean downloadable;
    private ThumbModel thumb;
    private String created_date;
    private boolean nsfw;
    private boolean read;
    private boolean unlocked;
    private boolean nu;
    private boolean early_access;
    private boolean support_supporting_ad;
    private int view_cnt;
    private String scheduled_date;

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

    public int getScene() {
        return scene;
    }

    public void setScene(int scene) {
        this.scene = scene;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public boolean isDownloadable() {
        return downloadable;
    }

    public void setDownloadable(boolean downloadable) {
        this.downloadable = downloadable;
    }

    public ThumbModel getThumb() {
        return thumb;
    }

    public void setThumb(ThumbModel thumb) {
        this.thumb = thumb;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public boolean isNsfw() {
        return nsfw;
    }

    public void setNsfw(boolean nsfw) {
        this.nsfw = nsfw;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public boolean isUnlocked() {
        return unlocked;
    }

    public void setUnlocked(boolean unlocked) {
        this.unlocked = unlocked;
    }

    public boolean isNu() {
        return nu;
    }

    public void setNu(boolean nu) {
        this.nu = nu;
    }

    public boolean isEarly_access() {
        return early_access;
    }

    public void setEarly_access(boolean early_access) {
        this.early_access = early_access;
    }

    public boolean isSupport_supporting_ad() {
        return support_supporting_ad;
    }

    public void setSupport_supporting_ad(boolean support_supporting_ad) {
        this.support_supporting_ad = support_supporting_ad;
    }

    public int getView_cnt() {
        return view_cnt;
    }

    public void setView_cnt(int view_cnt) {
        this.view_cnt = view_cnt;
    }

    public String getScheduled_date() {
        return scheduled_date;
    }

    public void setScheduled_date(String scheduled_date) {
        this.scheduled_date = scheduled_date;
    }

    @Override
    public String toString() {
        return "EpisodeModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", scene=" + scene +
                ", free=" + free +
                ", downloadable=" + downloadable +
                ", thumb=" + thumb +
                ", created_date='" + created_date + '\'' +
                ", nsfw=" + nsfw +
                ", read=" + read +
                ", unlocked=" + unlocked +
                ", nu=" + nu +
                ", early_access=" + early_access +
                ", support_supporting_ad=" + support_supporting_ad +
                ", view_cnt=" + view_cnt +
                ", scheduled_date='" + scheduled_date + '\'' +
                '}';
    }
}
