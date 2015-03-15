package com.example.idk.myuber;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by idk on 3/14/15.
 */
public class PostBike2 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postbike_two);
        Intent intent = getIntent();
        String description =intent.getStringExtra("1");
        String uri = getIntent().getStringExtra("0");
        ImageView imgview =(ImageView)findViewById(R.id.rent_bike_image);
        Uri imgUri=Uri.parse(uri);
        imgview.setImageURI(imgUri);
        TextView txtview =(TextView)findViewById(R.id.post_description_string);
        txtview.setText(description);
        Button postBike = (Button)findViewById(R.id.post_bike_post_button);
        postBike.setOnClickListener((View.OnClickListener) this);

    }
    protected void onDestroy(){
        super.onDestroy();
    }

    public void onClick(View v){
        switch (v.getId()) {
            case R.id.post_bike_post_button:
                Httpget post = new Httpget();
                JSONObject postobj = new JSONObject();
                AsyncTask<String, Void, Void> task = post.new newBike();
                task.execute("1");
                break;
        }

    }

}