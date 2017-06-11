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
    protected ArrayList<Comment> comments = new ArrayList<>();
    protected ArrayList<Like> likes = new ArrayList<>();

    public Moment(int id, String description, String tanggal, String waktu, ArrayList<Comment> comments, ArrayList<Like> likes) {
        this.id = id;
        this.description = description;
        this.tanggal = tanggal;
        this.waktu = waktu;
        this.comments = comments;
        this.likes = likes;
    }

    @Override
    public String toString() {
        return this.id + " - " + this.description;
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
    public CommonMoment(int id, String description, String tanggal, String waktu, ArrayList<Comment> comments, ArrayList<Like> likes) {
        super(id, description, tanggal, waktu, comments, likes);
    }
}

class LocationMoment extends Moment{
    protected String longitude;
    protected String lattitude;

    public LocationMoment(int id, String description, String tanggal, String waktu, ArrayList<Comment> comments, ArrayList<Like> likes, String longitude, String lattitude) {
        super(id, description, tanggal, waktu, comments, likes);
        this.longitude = longitude;
        this.lattitude = lattitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLattitude() {
        return lattitude;
    }

    public void setLattitude(String lattitude) {
        this.lattitude = lattitude;
    }
}

class MediaMoment extends Moment{
    protected String media_url;

    public MediaMoment(int id, String description, String tanggal, String waktu, ArrayList<Comment> comments, ArrayList<Like> likes, String media_url) {
        super(id, description, tanggal, waktu, comments, likes);
        this.media_url = media_url;
    }

    public String getMedia_url() {
        return media_url;
    }

    public void setMedia_url(String media_url) {
        this.media_url = media_url;
    }
}
