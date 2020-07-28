package com.ujjani.localjsonfile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<CountryList> arrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView= findViewById(R.id.listView);
        arrayList = new ArrayList<>();

        JSONObject object = null;
        try {
            object = new JSONObject(readJSON());
            JSONArray array = object.getJSONArray("data");

            for (int i = 0; i < array.length(); i++) {

                JSONObject jsonObject = array.getJSONObject(i);
                String name = jsonObject.getString("name");
                String countryCode = jsonObject.getString("country_code");

                CountryList countryList = new CountryList();
                countryList.setName(name);
                countryList.setCountryCode(countryCode);

                arrayList.add(i, countryList);


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        CustomAdapter adapter = new CustomAdapter(this, arrayList);
        listView.setAdapter(adapter);




    }

    public String readJSON() {
        String json = null;
        try {
            // Opening CountryCode.json file
            InputStream inputStream = getAssets().open("CountryCode.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            // read values in the byte array
            inputStream.read(buffer);
            inputStream.close();
            // convert byte to string
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return json;
        }
        return json;
    }



}