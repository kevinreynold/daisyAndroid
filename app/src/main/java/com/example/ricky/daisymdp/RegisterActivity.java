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

public class RegisterActivity extends AppCompatActivity {
    private EditText tbUserRegister,tbEmailRegister,tbPassRegister,tbCPassRegister;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        tbUserRegister = (EditText) findViewById(R.id.tbUserRegister);
        tbEmailRegister = (EditText) findViewById(R.id.tbEmailRegister);
        tbPassRegister = (EditText) findViewById(R.id.tbPassRegister);
        tbCPassRegister = (EditText) findViewById(R.id.tbCPassRegister);
        btnRegister = (Button) findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = tbUserRegister.getText().toString();
                String email = tbEmailRegister.getText().toString();
                String pass = tbPassRegister.getText().toString();
                String cpass = tbCPassRegister.getText().toString();

                if(canRegister(name,email,pass,cpass))
                    new RegisterTask().execute(name,email,pass);
            }
        });
    }

    public boolean canRegister(String name, String email, String pass, String cpass){
        if(name.trim().equals("") || email.trim().equals("") || pass.trim().equals("") || cpass.trim().equals("")){
            resetInput();
            Toast.makeText(RegisterActivity.this, "That's not the right input. Sorry!", Toast.LENGTH_LONG).show();
            return false;
        }
        else {
            if(!Validation.isValidEmail(email)){
                resetInput();
                Toast.makeText(RegisterActivity.this,"That's not the right email. Sorry!",Toast.LENGTH_LONG).show();
                return false;
            }

            if(!pass.equals(cpass)){
                tbPassRegister.setText("");
                tbCPassRegister.setText("");
                Toast.makeText(RegisterActivity.this,"Password does not match. Sorry!",Toast.LENGTH_LONG).show();
                return false;
            }
        }
        return true;
    }

    public void resetInput(){
        tbUserRegister.setText("");
        tbEmailRegister.setText("");
        tbPassRegister.setText("");
        tbCPassRegister.setText("");
    }

    private class RegisterTask extends AsyncTask<String,Void,String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
            String response = "";

            try {
                URL url = new URL("http://" + UserSessionManager.host + "/mdp_project/register.php");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                String parameter = "nama_user=" + params[0] + "&email=" + params[1] + "&password=" + params[2];

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
            if (s.equalsIgnoreCase("email_taken")) {
                resetInput();
                Toast.makeText(RegisterActivity.this,"Email Address already used. Please use antoher email address :)",Toast.LENGTH_LONG).show();
            }
            else if (s.equalsIgnoreCase("register_success")){
                Toast.makeText(RegisterActivity.this,"Register Success!!",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
            else{
                resetInput();
                Toast.makeText(RegisterActivity.this,"Register Failed!! Please Try Again",Toast.LENGTH_LONG).show();
            }
        }
    }
}
