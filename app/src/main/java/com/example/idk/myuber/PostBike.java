package com.example.idk.myuber;

import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by Mikaami13 on 3/14/2015.
 */


public class PostBike extends Fragment {
    Button next;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        test();

        return inflater.inflate(R.layout.activity_postbike1, container, false);

    }


    public void test() {

        String first_name;
        String last_name;
        Httpget tst = new Httpget();
        JSONArray obj = new JSONArray();
        //obj = tst.getUser("1");
        tst.parseUser(obj);
        first_name = tst.getOwner_first_name();
        last_name = tst.getOwner_last_name();
        Log.v("Post", first_name) ;
        Log.v("Post", last_name);

    }


}
