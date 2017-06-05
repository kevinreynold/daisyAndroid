package com.example.ricky.daisymdp;

/**
 * Created by Kevin on 6/4/2017.
 */

public class Comment {
    private int id;
    private String tanggal;
    private String waktu;
    private String message;
    private String nama_user;

    public Comment(int id, String tanggal, String waktu, String message, String nama_user) {
        this.id = id;
        this.tanggal = tanggal;
        this.waktu = waktu;
        this.message = message;
        this.nama_user = nama_user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNama_user() {
        return nama_user;
    }

    public void setNama_user(String nama_user) {
        this.nama_user = nama_user;
    }
}