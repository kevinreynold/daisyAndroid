package com.example.ricky.daisymdp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import org.json.JSONException;
import org.json.JSONObject;

public class HomeActivity extends AppCompatActivity {
    private ImageView tabFriend,tabAdd,tabNotif,tabProfile;
    private Button btnLogout;
    public static User user;
    public JSONObject json_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(MainActivity.session.checkLogin()) finish();

        new ProfileDetails().execute();
        btnLogout = (Button) findViewById(R.id.btnLogout);
        tabFriend = (ImageView) findViewById(R.id.tabFriendMain);
        tabAdd = (ImageView) findViewById(R.id.tabAddMain);
        tabNotif = (ImageView) findViewById(R.id.tabNotifMain);
        tabProfile = (ImageView) findViewById(R.id.tabMomentMain);

        tabFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toFriendActivity = new Intent(HomeActivity.this,FriendActivity.class);
                startActivity(toFriendActivity);
            }
        });
        tabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toAddActivity = new Intent(HomeActivity.this,AddActivity.class);
                startActivity(toAddActivity);
            }
        });
        tabNotif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toNotificationActivity = new Intent(HomeActivity.this,NotificationActivity.class);
                startActivity(toNotificationActivity);
            }
        });
        tabProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tabProfileActivity = new Intent(HomeActivity.this,ProfileActivity.class);
                startActivity(tabProfileActivity);
            }
        });
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.session.logoutUser();
            }
        });
    }

    public class ProfileDetails extends AsyncTask<Void,Void,Void>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            int id = Integer.parseInt(MainActivity.session.getUserDetails().get("user_id"));
            String path = "http://" + UserSessionManager.host + "/mdp_project/profile.php?user_id=" + String.valueOf(id);
            json_user = JSONParser.getJSONFromUrl(path);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            user = new User(json_user);
            btnLogout.setText(user.getPassword());
        }
    }
}
