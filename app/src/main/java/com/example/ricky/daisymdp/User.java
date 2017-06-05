package com.example.ricky.daisymdp;

import java.util.ArrayList;

/**
 * Created by Kevin on 6/3/2017.
 */

public class User {
    private String json_response;
    private String username;
    private String email;
    private String password;
    private String profile_pict;
    private boolean status;
    private ArrayList<Moment> moments = new ArrayList<>();
    private ArrayList<User> friends = new ArrayList<>();

    public User(String json_response) {
        this.json_response = json_response;
        setUser();
    }

    public void setUser(){

    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getProfile_pict() {
        return profile_pict;
    }

    public boolean isStatus() {
        return status;
    }

    public ArrayList<Moment> getMoments() {
        return moments;
    }

    public ArrayList<User> getFriends() {
        return friends;
    }
}
