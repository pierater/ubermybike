package com.example.idk.myuber;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by idk on 3/15/15.
 */

public class Owner extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner);
        Httpget owner = new Httpget();
        JSONObject ownerInfo = new JSONObject();
        AsyncTask<String,Void, JSONArray> task = owner.new myTask().execute("1");
        String fname ="George "; //owner.getOwner_first_name();
        String lname ="Jetson"; //owner.getOwner_last_name();
        String phoneNumber = "831-555-1212";//owner.getOwner_phone_num();
        String email ="george@jetson.com"; //owner.getEmail();
        String rating = "5 / 5";//String.valueOf(owner.getOwner_rating());
        String experience ="10 Rentals"; //String.valueOf(owner.getExperience());

        Log.v("STRING", fname);
        Log.v("STRING", lname);
        Log.v("STRING", phoneNumber);
        Log.v("STRING", email);
        /*TextView txtview =(TextView)findViewById(R.id.owner);
        txtview.setText(fname+ " " + lname);
        TextView pnum =(TextView)findViewById(R.id.owner_phonenumber);
        pnum.setText(phoneNumber);
        TextView maile =(TextView)findViewById(R.id.owner_email);
        maile.setText(email);
        TextView rate =(TextView)findViewById(R.id.owner_rating);
        rate.setText(rating);
        TextView exp =(TextView)findViewById(R.id.owner_experience);
        exp.setText(experience);
        */

       }

   }
