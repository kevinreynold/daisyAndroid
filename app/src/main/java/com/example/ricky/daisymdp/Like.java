package com.example.ricky.daisymdp;

/**
 * Created by Kevin on 6/4/2017.
 */

public class Like {
    private int id_user;
    private String nama_user;
    private String tanggal;
    private String waktu;

    public Like(int id_user, String nama_user, String tanggal, String waktu) {
        this.id_user = id_user;
        this.nama_user = nama_user;
        this.tanggal = tanggal;
        this.waktu = waktu;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
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
