package com.example.idk.myuber;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapsActivity extends Fragment {

    private GoogleMap mMap = null;
    private Marker position = null;
    private SupportMapFragment fragment;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.activity_maps, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        FragmentManager fm=getChildFragmentManager();
        fragment = (SupportMapFragment)fm.findFragmentById(R.id.map);
        if(fragment == null)
        {
            fragment = SupportMapFragment.newInstance();
            fm.beginTransaction().replace(R.id.map, fragment).commit();

        }

    }


    private void SetupMap()
    {
        position = mMap.addMarker(new MarkerOptions().position(new LatLng(36.999 , -122)).title("Origin"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.7833,-122.4167), 8));
    }

}

