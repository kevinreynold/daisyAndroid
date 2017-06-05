package com.example.ricky.daisymdp;

import java.util.ArrayList;

/**
 * Created by Kevin on 6/4/2017.
 */

public abstract class Moment {
    protected int id;
    protected String description;
    protected String tanggal;
    protected String waktu;
    protected int like_count;
    protected int comment_count;
    protected ArrayList<Comment> comments = new ArrayList<>();
    protected ArrayList<Like> likes = new ArrayList<>();

    public Moment(int id, String description, String tanggal, String waktu, int like_count, int comment_count, ArrayList<Comment> comments, ArrayList<Like> likes) {
        this.id = id;
        this.description = description;
        this.tanggal = tanggal;
        this.waktu = waktu;
        this.like_count = like_count;
        this.comment_count = comment_count;
        this.comments = comments;
        this.likes = likes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public int getLike_count() {
        return like_count;
    }

    public void setLike_count(int like_count) {
        this.like_count = like_count;
    }

    public int getComment_count() {
        return comment_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public ArrayList<Like> getLikes() {
        return likes;
    }

    public void setLikes(ArrayList<Like> likes) {
        this.likes = likes;
    }
}

class CommonMoment extends Moment{
    public CommonMoment(int id, String description, String tanggal, String waktu, int like_count, int comment_count, ArrayList<Comment> comments, ArrayList<Like> likes) {
        super(id, description, tanggal, waktu, like_count, comment_count, comments, likes);
    }
}

class LocationMoment extends Moment{
    protected double longitude;
    protected double lattitude;

    public LocationMoment(int id, String description, String tanggal, String waktu, int like_count, int comment_count, ArrayList<Comment> comments, ArrayList<Like> likes, double longitude, double lattitude) {
        super(id, description, tanggal, waktu, like_count, comment_count, comments, likes);
        this.longitude = longitude;
        this.lattitude = lattitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLattitude() {
        return lattitude;
    }

    public void setLattitude(double lattitude) {
        this.lattitude = lattitude;
    }
}

class MediaMoment extends Moment{
    protected String media_url;

    public MediaMoment(int id, String description, String tanggal, String waktu, int like_count, int comment_count, ArrayList<Comment> comments, ArrayList<Like> likes, String media_url) {
        super(id, description, tanggal, waktu, like_count, comment_count, comments, likes);
        this.media_url = media_url;
    }

    public String getMedia_url() {
        return media_url;
    }

    public void setMedia_url(String media_url) {
        this.media_url = media_url;
    }
}
