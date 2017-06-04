package com.example.ricky.daisymdp;

/**
 * Created by Kevin on 6/3/2017.
 */

public class User {
    private String username;
    private String email;
    private String password;
    private String profile_pict;
    private boolean status;

    public User(String username, String email, String password, String profile_pict) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.profile_pict = profile_pict;
        this.status = true;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfile_pict() {
        return profile_pict;
    }

    public void setProfile_pict(String profile_pict) {
        this.profile_pict = profile_pict;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
