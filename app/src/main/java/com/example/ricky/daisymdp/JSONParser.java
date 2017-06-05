package com.example.ricky.daisymdp;

/**
 * Created by Kevin on 6/4/2017.
 */

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

public class JSONParser {

    static InputStream is = null;
    static JSONObject jObj = null;
    static String json = "";

    // constructor
    public JSONParser() {

    }

    public static JSONObject getJSONFromUrl(String path) {

        try {
            URL url = new URL(path);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            InputStream stream = new BufferedInputStream(urlConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));
            StringBuilder builder = new StringBuilder();

            String inputString;
            while ((inputString = bufferedReader.readLine()) != null) {
                builder.append(inputString);
            }
            Log.e("Hasil JSON",builder.toString());
            JSONObject jObj = new JSONObject(builder.toString());

            urlConnection.disconnect();
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        // return JSON String
        return jObj;
    }
}