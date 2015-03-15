package com.example.idk.myuber;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by chrisgin on 3/15/15.
 */
public class rentalFinal extends Activity implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_menu_button:
                launch_rent_button();
                break;
        }

    }

    public void launch_rent_button() {
        Intent intent = new Intent(this, Main_Activity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rental_final);
        Button rent = (Button) findViewById(R.id.main_menu_button);
        rent.setOnClickListener(this);

        Httpget owner = new Httpget();
        JSONObject ownerInfo = new JSONObject();
        AsyncTask<String, Void, JSONArray> task = owner.new myTask().execute("1");
        String fname ="George "; //owner.getOwner_first_name();
        String lname ="Jetson"; //owner.getOwner_last_name();
        String phoneNumber = "831-555-1212";//owner.getOwner_phone_num();
        String email = owner.getEmail();
        TextView txtview = (TextView) findViewById(R.id.owner_name_info);
        txtview.setText(fname + " " + lname);
        TextView pnum = (TextView)findViewById(R.id.owner_phonenumber_info);
        txtview.setText(phoneNumber);
        TextView maile = (TextView) findViewById(R.id.owner_email_info);
        txtview.setText(email);
    }
}