package com.example.idk.myuber;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.Button;


import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by Mikaami13 on 3/14/2015.
 */


public class PostBike extends Fragment {
    private int requestCode;
    private int resultCode;
    private Intent data;


    Button next;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        test();

        return inflater.inflate(R.layout.activity_postbike1, container, false);

    }

    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
            if (resultCode == getActivity().RESULT_OK) {
                // Image captured and saved to fileUri specified in the Intent
                Toast.makeText(getActivity(), "Image saved to:\n" +
                        intent.getData(), Toast.LENGTH_LONG).show();
            } else if (resultCode == getActivity().RESULT_CANCELED) {
                // User cancelled the image capture
            } else {
                // Image capture failed, advise user
            }
        }
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
