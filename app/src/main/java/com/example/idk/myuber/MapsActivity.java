package com.example.idk.myuber;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapsActivity extends FragmentActivity {

    private GoogleMap mMap = null;
    private Marker position = null;
    private LatLngBounds SanFran = new LatLngBounds(
            new LatLng(37, -122), new LatLng(37, -122));
    /*
Set the camera to the greatest possible zoom level that includes the
bounds
*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setUpMapIfNeeded();
    }
    private  void setUpMapIfNeeded()
    {
        if (mMap == null) {
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
            if(mMap != null){
                SetupMap();
            }
        }
    }
    private void SetupMap()
    {
        position = mMap.addMarker(new MarkerOptions().position(new LatLng(36.999 , -122)).title("Origin"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.7833,-122.4167), 8));
    }

}

