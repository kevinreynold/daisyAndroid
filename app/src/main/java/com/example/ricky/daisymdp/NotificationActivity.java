package com.example.ricky.daisymdp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class NotificationActivity extends AppCompatActivity {
    private ImageView tabHome,tabAdd,tabFriend,tabProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        tabHome = (ImageView) findViewById(R.id.tabHomeNotif);
        tabAdd = (ImageView) findViewById(R.id.tabAddNotif);
        tabFriend = (ImageView) findViewById(R.id.tabFriendNotif);
        tabProfile = (ImageView) findViewById(R.id.tabMomentNotif);

        tabHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toHomeActivity = new Intent(NotificationActivity.this,HomeActivity.class);
                startActivity(toHomeActivity);
            }
        });
        tabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toAddActivity = new Intent(NotificationActivity.this,AddActivity.class);
                startActivity(toAddActivity);
            }
        });
        tabFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toFriendActivity = new Intent(NotificationActivity.this,FriendActivity.class);
                startActivity(toFriendActivity);
            }
        });
        tabProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tabProfileActivity = new Intent(NotificationActivity.this,ProfileActivity.class);
                startActivity(tabProfileActivity);
            }
        });
    }
}
