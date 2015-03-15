package com.example.idk.myuber;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;

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
        String fname = owner.getOwner_first_name();
        String lname = owner.getOwner_last_name();
        String phoneNumber = owner.getOwner_phone_num();
        String email = owner.getEmail();
        String rating = String.valueOf(owner.getOwner_rating());
        String experience = String.valueOf(owner.getExperience());
       }

   }
