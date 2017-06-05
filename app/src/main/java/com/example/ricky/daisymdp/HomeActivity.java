package com.example.ricky.daisymdp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    private Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(MainActivity.session.checkLogin()) finish();

        new ProfileDetails().execute();
        btnLogout = (Button) findViewById(R.id.btnLogout);
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
            String path = "http://" + UserSessionManager.host + "/mdp_project/profile.php?userid=" + String.valueOf(id);
            JSONParser.getJSONFromUrl(path);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }
}
