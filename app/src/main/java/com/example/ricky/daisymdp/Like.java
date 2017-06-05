package com.example.ricky.daisymdp;

/**
 * Created by Kevin on 6/4/2017.
 */

public class Like {
    private int id;
    private String nama_user;
    private String tanggal;
    private String waktu;

    public Like(int id, String nama_user, String tanggal, String waktu) {
        this.id = id;
        this.nama_user = nama_user;
        this.tanggal = tanggal;
        this.waktu = waktu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama_user() {
        return nama_user;
    }

    public void setNama_user(String nama_user) {
        this.nama_user = nama_user;
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
}
