package com.example.idk.myuber;

import android.os.Build;
import android.support.v4.app.Fragment;
import android.os.Bundle;

import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONObject;


public class MapsActivity extends Fragment {


    private static GoogleMap mMap = null;
    private static Marker position = null;
    private SupportMapFragment fragment;


    public  static View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        if(container == null)
            return null;
        view = (FrameLayout) inflater.inflate(R.layout.activity_maps, container, false);
        SetupMapIfNeeded();
        return view;
    }

    public void SetupMapIfNeeded()
    {
        test();
        if(mMap == null)
        {
            mMap = getMapFragment().getMap();
            if(mMap != null)
                SetupMap();

        }

    }
    private SupportMapFragment getMapFragment() {
        Main_Activity.fragmentManager = getChildFragmentManager();

        SupportMapFragment t = (SupportMapFragment) Main_Activity.fragmentManager.findFragmentById(R.id.map);


        return t;
}

    private static void SetupMap()
    {
        position = mMap.addMarker(new MarkerOptions().position(new LatLng(36.999 , -122)).title("Origin"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.7833,-122.4167), 8));

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(mMap != null) {
            Main_Activity.fragmentManager.beginTransaction().remove(Main_Activity.fragmentManager.findFragmentById(R.id.map)).commit();
            mMap = null;
        }
    }

    public void test() {

        String first_name;
        String last_name;
        Httpget tst = new Httpget();
        JSONObject obj = new JSONObject();
        obj = tst.getUser("1");
        tst.parseUser(obj);
        first_name = tst.getOwner_first_name();
        last_name = tst.getOwner_last_name();
        //Log.v("Post", "TEST");
        //Log.v("Post", last_name);

    }
}
