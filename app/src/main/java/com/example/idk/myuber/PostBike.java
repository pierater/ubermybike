package com.example.idk.myuber;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Button;


import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by Mikaami13 on 3/14/2015.
 */


public class PostBike extends Fragment implements View.OnClickListener {
    private int requestCode;
    private int resultCode;
    private Intent data;

    String uri;
    Button next;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        test();
        view = inflater.inflate(R.layout.activity_postbike1, container, false);
        Button launch = (Button) view.findViewById(R.id.launch_camera_button);
        next = (Button) view.findViewById(R.id.next_button);
        next.setOnClickListener(this);
        launch.setOnClickListener(this);
        return view;

    }

    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }
    public void launch_camera()
    {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
    }
    public void next_page()
    {
        Intent intent = new Intent(getActivity(), PostBike2.class);
        EditText edittext = (EditText)view.findViewById(R.id.post_description_string);
        String description = edittext.getText().toString();
        intent.putExtra("1",description);
        intent.putExtra("0",uri);
        startActivity(intent);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
            if (resultCode == getActivity().RESULT_OK) {
                // Image captured and saved to fileUri specified in the Intent
               // Toast.makeText(getActivity(), "Image saved to:\n" +
                        //intent.getData(), Toast.LENGTH_LONG).show();
                ImageView imgview =(ImageView)view.findViewById(R.id.pic_of_bike_post);
                Uri imgUri=Uri.parse(intent.getData().toString());
                uri = intent.getData().toString();
                imgview.setImageURI(null);
                imgview.setImageURI(imgUri);
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


    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.launch_camera_button:
                launch_camera();
                break;
            case R.id.next_button:
                next_page();
                break;

        }
    }
}
