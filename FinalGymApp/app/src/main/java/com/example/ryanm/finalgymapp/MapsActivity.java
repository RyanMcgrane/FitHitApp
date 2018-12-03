package com.example.ryanm.finalgymapp;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

//Fragment activity is just a generic activity type
//which allows us to create any sort of activity
//in this case a map here

//OnMapReady Callback allows us to do something when the map is
//ready example zoom in on the map
public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {


    //mMap of type GoogleMap
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);


        //The Async means that it will happen in the background
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    //Called when the map is ready
    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        mMap = googleMap;

        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        // Add a marker in Sydney and move the camera
        LatLng pheonixPark = new LatLng(53.358385, -6.330536);
        LatLng ColloseumGym = new LatLng(53.3335928,-6.3504409);
        LatLng B_ActiveGym = new LatLng(53.3388239,-6.5326613);
        LatLng GalwayGym= new LatLng(53.2786491,-9.0824196);
        LatLng RawGym= new LatLng(53.272826,-6.2071306);
        LatLng CorkGym= new LatLng(51.8977317,-8.4918339);
        LatLng AntrimGym = new LatLng(54.6873859,-6.3636475);
        LatLng MonaghanGym = new LatLng(54.2412505,-6.9801957);
        LatLng FlyeFitGym = new LatLng(53.3614175,-6.4109891);
        LatLng EndevaourGym = new LatLng(53.3614175,-6.4109891);



        mMap.addMarker(new MarkerOptions().position(pheonixPark).title("Marker in Dublin").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(pheonixPark, 8));

        mMap.addMarker(new MarkerOptions().position(ColloseumGym).title("Gym Marker").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        mMap.addMarker(new MarkerOptions().position(B_ActiveGym).title("Gym Marker").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        mMap.addMarker(new MarkerOptions().position(GalwayGym).title("Gym Marker").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        mMap.addMarker(new MarkerOptions().position(RawGym).title("Gym Marker").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        mMap.addMarker(new MarkerOptions().position(CorkGym).title("Gym Marker").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        mMap.addMarker(new MarkerOptions().position(AntrimGym).title("Gym Marker").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        mMap.addMarker(new MarkerOptions().position(MonaghanGym).title("Gym Marker").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        mMap.addMarker(new MarkerOptions().position(FlyeFitGym).title("Gym Marker").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        mMap.addMarker(new MarkerOptions().position(EndevaourGym).title("Gym Marker").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
    }
}
