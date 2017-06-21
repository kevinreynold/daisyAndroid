package com.example.ricky.daisymdp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    private ImageView tabHome,tabAdd,tabFriend,tabNotif;
    private TextView tbMomentCount, tbFollowingCount, tbFollowerCount, tbNameProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tabHome = (ImageView) findViewById(R.id.tabHomeProfile);
        tabAdd = (ImageView) findViewById(R.id.tabAddProfile);
        tabFriend = (ImageView) findViewById(R.id.tabFriendProfile);
        tabNotif = (ImageView) findViewById(R.id.tabNotifProfile);

        tbMomentCount = (TextView) findViewById(R.id.tbMomentsCountProfile);
        tbFollowingCount = (TextView) findViewById(R.id.tbFollowingCountProfile);
        tbFollowerCount = (TextView) findViewById(R.id.tbFollowerCountProfile);
        tbNameProfile = (TextView) findViewById(R.id.tbNameProfile);
        tbMomentCount.setText(HomeActivity.user.momentCount()+"");
        tbFollowingCount.setText(HomeActivity.user.followingCount()+"");
        tbFollowerCount.setText(HomeActivity.user.followerCount()+"");
        tbNameProfile.setText(HomeActivity.user.getUsername()+"");

        tabHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toHomeActivity = new Intent(ProfileActivity.this,HomeActivity.class);
                startActivity(toHomeActivity);
            }
        });
        tabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toAddActivity = new Intent(ProfileActivity.this,AddActivity.class);
                startActivity(toAddActivity);
            }
        });
        tabFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toFriendActivity = new Intent(ProfileActivity.this,FriendActivity.class);
                startActivity(toFriendActivity);
            }
        });
        tabNotif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tabNotificationActivity = new Intent(ProfileActivity.this,NotificationActivity.class);
                startActivity(tabNotificationActivity);
            }
        });

    }
}
