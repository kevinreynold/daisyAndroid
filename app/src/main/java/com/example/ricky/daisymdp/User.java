package com.example.ricky.daisymdp;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Kevin on 6/3/2017.
 */

public class User {
    private JSONObject json_response;
    private int id;
    private String username;
    private String email;
    private String password;
    private String profile_pict;
    private boolean status;
    private ArrayList<Moment> moments = new ArrayList<>();
    private ArrayList<User> following = new ArrayList<>();
    private ArrayList<User> follower = new ArrayList<>();
    private ArrayList<User> friend_suggestion = new ArrayList<>();

    public User(JSONObject json_response) {
        this.json_response = json_response;
        getUserFromJSON();
    }

    public User(int id, String username){
        this.id = id;
        this.username = username;
    }

    public void getUserFromJSON(){
        if(json_response!=null){
            try {
                this.id = json_response.getInt("id_user");
                this.username = json_response.getString("nama_user");
                this.email = json_response.getString("email");
                this.password = json_response.getString("password");
                this.profile_pict = json_response.getString("profile_foto_url");
                this.status = (json_response.getString("status").equals("1"))? true:false;

                JSONArray json_following = json_response.getJSONArray("following");
                for (int i=0; i<json_following.length(); i++){
                    JSONObject temp = json_following.getJSONObject(i);
                    int id_following = temp.getInt("id");
                    String username_following = temp.getString("nama_user");
                    this.following.add(new User(id_following,username_following));
                }

                JSONArray json_follower = json_response.getJSONArray("follower");
                for (int i=0; i<json_follower.length(); i++){
                    JSONObject temp = json_follower.getJSONObject(i);
                    int id_follower = temp.getInt("id");
                    String username_follower = temp.getString("nama_user");
                    this.follower.add(new User(id_follower,username_follower));
                }

                //moment
                JSONArray json_moments = json_response.getJSONArray("moment");
                for (int i=0; i<json_moments.length(); i++){
                    JSONObject json_moment = json_moments.getJSONObject(i);
                    int id_moment = json_moment.getInt("id");
                    String description_moment = json_moment.getString("description");
                    String tanggal_moment = json_moment.getString("tanggal");
                    String waktu_moment = json_moment.getString("waktu");
                    String media_url_moment = (json_moment.getString("media_url").equals("null"))? json_moment.getString("media_url") : null;
                    String longitude_moment = (json_moment.getString("longitude").equals("null"))? json_moment.getString("longitude") : null;
                    String latitude_moment = (json_moment.getString("latitude").equals("null"))? json_moment.getString("latitude") : null;

                    //comment
                    ArrayList<Comment> comments_moment = new ArrayList<>();
                    JSONArray json_comment_array = json_moment.getJSONArray("comment");
                    for (int j=0; j<json_comment_array.length(); j++){
                        JSONObject json_comment = json_comment_array.getJSONObject(j);
                        int id_comment = json_comment.getInt("id");
                        String tanggal_comment = json_comment.getString("tanggal");
                        String waktu_comment = json_comment.getString("waktu");
                        String message_comment = json_comment.getString("message");
                        String nama_user_comment = json_comment.getString("nama_user");
                        comments_moment.add(new Comment(id_comment,tanggal_comment,waktu_comment,message_comment,nama_user_comment));
                    }

                    //like
                    ArrayList<Like> likes_moment = new ArrayList<>();
                    JSONArray json_like_array = json_moment.getJSONArray("like");
                    for (int j=0; j<json_like_array.length(); j++){
                        JSONObject json_like = json_like_array.getJSONObject(j);
                        int id_user_like = json_like.getInt("id");
                        String nama_user_like = json_like.getString("nama");
                        String tanggal_like = json_like.getString("tanggal");
                        String waktu_like = json_like.getString("waktu");
                        likes_moment.add(new Like(id_user_like,nama_user_like,tanggal_like,waktu_like));
                    }

                    if (media_url_moment==null && latitude_moment==null && longitude_moment==null){
                        moments.add(new CommonMoment(id_moment, description_moment, tanggal_moment, waktu_moment, comments_moment, likes_moment));
                    }
                    else if(media_url_moment!=null){
                        moments.add(new MediaMoment(id_moment, description_moment, tanggal_moment, waktu_moment, comments_moment, likes_moment, media_url_moment));
                    }
                    else if(latitude_moment!=null && longitude_moment!=null){
                        moments.add(new LocationMoment(id_moment, description_moment, tanggal_moment, waktu_moment, comments_moment, likes_moment, longitude_moment, latitude_moment));
                    }
                }

                //friend_suggestion
                JSONArray json_friend_suggestion_array = json_response.getJSONArray("friend_suggestion");
                for (int i=0; i<json_friend_suggestion_array.length(); i++){
                    JSONObject json_friend_suggestion = json_friend_suggestion_array.getJSONObject(i);
                    int id = json_friend_suggestion.getInt("id");
                    String nama_user = json_friend_suggestion.getString("nama_user");
                    friend_suggestion.add(new User(id,nama_user));
                }

                Log.e("JSON-User","Success");
            } catch (JSONException e) {
                e.printStackTrace();
                Log.e("JSON-User","Failed");
            }
        }
    }

    public int followingCount(){
        return following.size();
    }

    public int followerCount(){
        return follower.size();
    }

    public int momentCount(){
        for (int i=0; i<moments.size(); i++){
            Log.e("Moment -",moments.get(i).toString());
        }
        return moments.size();
    }

    public int getId() {
        return id;
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

    public ArrayList<User> getFollowing() {
        return following;
    }

    public ArrayList<User> getFollower() {
        return follower;
    }

    public ArrayList<User> getFriend_suggestion() {
        return friend_suggestion;
    }
}
