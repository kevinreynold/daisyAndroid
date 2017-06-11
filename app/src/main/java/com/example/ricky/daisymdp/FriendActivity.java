package com.example.ricky.daisymdp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class FriendActivity extends AppCompatActivity {
    private ImageView tabHome,tabAdd,tabNotif,tabProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend);
        tabHome = (ImageView) findViewById(R.id.tabHomeFriend);
        tabAdd = (ImageView) findViewById(R.id.tabAddFriend);
        tabNotif = (ImageView) findViewById(R.id.tabNotifFriend);
        tabProfile = (ImageView) findViewById(R.id.tabMomentFriend);

        tabHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toHomeActivity = new Intent(FriendActivity.this,HomeActivity.class);
                startActivity(toHomeActivity);
            }
        });
        tabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toAddActivity = new Intent(FriendActivity.this,AddActivity.class);
                startActivity(toAddActivity);
            }
        });
        tabNotif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toNotificationActivity = new Intent(FriendActivity.this,NotificationActivity.class);
                startActivity(toNotificationActivity);
            }
        });
        tabProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tabProfileActivity = new Intent(FriendActivity.this,ProfileActivity.class);
                startActivity(tabProfileActivity);
            }
        });
    }
}
