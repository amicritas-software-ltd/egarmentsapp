package com.amicritas.e_graments.activitys;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.amicritas.e_graments.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    double lat = 23.8757163;
    double lng = 90.3947515;
    View mapView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {


        mMap = googleMap;
        mMap.getFocusedBuilding();
        LatLng dhaka = new LatLng(lat, lng);
        mMap.addMarker(new MarkerOptions().position(dhaka).title("Marker in Dhaka"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(dhaka));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(dhaka,12.0f));
        mMap.addCircle(
                new CircleOptions()
                        .center(dhaka).radius(500).strokeWidth(.1f).fillColor(R.color.colorPrimary));
        //mMap.setMyLocationEnabled(true);
        mMap.isBuildingsEnabled();
        mMap.isIndoorEnabled();
        mMap.getUiSettings().isTiltGesturesEnabled();
        mMap.getUiSettings().isCompassEnabled();
        mMap.getUiSettings().isMapToolbarEnabled();
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().isRotateGesturesEnabled();
        mMap.getUiSettings().isScrollGesturesEnabledDuringRotateOrZoom();
    }
}
