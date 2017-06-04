package com.example.ricky.daisymdp;

/**
 * Created by Kevin on 6/4/2017.
 */

import java.util.HashMap;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class UserSessionManager {

    SharedPreferences pref;
    Editor editor;
    Context _context;
    int PRIVATE_MODE = 0;
    private static final String PREFER_NAME = "DAISY_PREFERENCE";
    private static final String IS_USER_LOGIN = "IsUserLoggedIn";
    public static final String KEY_USER = "user_id";

//    public static final String host = "192.168.100.14";
    public static final String host = "10.0.3.2";

    public UserSessionManager(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREFER_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void createUserLoginSession(String user_id){
        editor.putBoolean(IS_USER_LOGIN, true);
        editor.putString(KEY_USER, user_id);
        editor.commit();
    }

    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user = new HashMap<String, String>();
        user.put(KEY_USER, pref.getString(KEY_USER, null));
        return user;
    }

    public boolean checkLogin(){
        if(!this.isUserLoggedIn()){
            Intent i = new Intent(_context, LoginActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            _context.startActivity(i);
            return true;
        }
        return false;
    }

    public void logoutUser(){
        editor.clear();
        editor.commit();
        Intent i = new Intent(_context, LoginActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        _context.startActivity(i);
    }

    // Check for login
    public boolean isUserLoggedIn(){
        return pref.getBoolean(IS_USER_LOGIN, false);
    }
}