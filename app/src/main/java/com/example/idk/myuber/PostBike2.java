package com.example.idk.myuber;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by idk on 3/14/15.
 */
public class PostBike2 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String description =intent.getStringExtra("1");
        String uri = getIntent().getStringExtra("0");
        ImageView imgview =(ImageView)findViewById(R.id.pic_of_bike_post);
        Uri imgUri=Uri.parse(uri);
        uri = intent.getData().toString();
        imgview.setImageURI(null);
        imgview.setImageURI(imgUri);
        TextView txtview =(TextView)findViewById(R.id.post_description_string);
        txtview.setText(description);
        setContentView(R.layout.activity_postbike_two);
    }
}