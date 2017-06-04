package com.example.ricky.daisymdp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class LoginActivity extends AppCompatActivity {
    private Button btnLogin, btnToRegister;
    private EditText tbUserLogin, tbPassLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tbUserLogin = (EditText) findViewById(R.id.tbUserLogin);
        tbPassLogin = (EditText) findViewById(R.id.tbPassLogin);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnToRegister = (Button) findViewById(R.id.btnToRegister);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = tbUserLogin.getText().toString();
                String password = tbPassLogin.getText().toString();
                if (!username.trim().equals("") && !password.trim().equals("") ){
                    if(Validation.isValidEmail(username)){
                        new LoginTask().execute(username,password);
                    }
                    else{
                        Toast.makeText(LoginActivity.this,"That's not the right email. Sorry!",Toast.LENGTH_LONG).show();
                        tbUserLogin.setText("");
                        tbPassLogin.setText("");
                    }
                }
                else{
                    Toast.makeText(LoginActivity.this,"That's not the right input. Sorry!",Toast.LENGTH_LONG).show();
                    tbUserLogin.setText("");
                    tbPassLogin.setText("");
                }
            }
        });

        btnToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toRegisterActivity = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(toRegisterActivity);
            }
        });
    }

    private class LoginTask extends AsyncTask<String,Void,String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
            String response = "";

            try {
                URL url = new URL("http://" + UserSessionManager.host + "/mdp_project/login.php");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                String parameter = "email=" + params[0] + "&password=" + params[1];

                OutputStream outputStream = conn.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));

                writer.write(parameter);
                writer.flush();
                writer.close();
                outputStream.close();

                int responseCode = conn.getResponseCode();
                if(responseCode == HttpURLConnection.HTTP_OK){
                    String line = "";
                    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    while((line = reader.readLine()) != null){
                        response += line;
                    }
                    reader.close();
                }
                else{
                    response = "failed";
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            catch(IOException e){
                e.printStackTrace();
            }
            return response;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            String response = s.split("-")[0];
            String user_id = s.split("-")[1];
            if (response.equalsIgnoreCase("login_success")){
                MainActivity.session.createUserLoginSession(user_id);
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);
            }
            else{
                tbUserLogin.setText("");
                tbPassLogin.setText("");
                Toast.makeText(LoginActivity.this,"Login Failed!! Please Try Again",Toast.LENGTH_LONG).show();
            }
        }
    }
}
