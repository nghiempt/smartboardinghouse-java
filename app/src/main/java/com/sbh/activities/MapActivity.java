package com.sbh.activities;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.cardview.widget.CardView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.sbh.R;

import java.io.IOException;
import java.util.List;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {

    CardView back;

    CardView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        assert mapFragment != null;
        mapFragment.getMapAsync(this);

        back = findViewById(R.id.btnBackToManagement);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            finish();
            }
        });

        back = findViewById(R.id.btnBackToManagement);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            finish();
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        // Add a marker in Sydney and move the camera
        LatLng location = new LatLng(10.02181, 105.76712); // Replace with your desired latitude and longitude
        MarkerOptions markerOptions = new MarkerOptions()
                .position(location)
                .title("Nhà trọ Tiến Phúc") // Replace with your desired title
                .snippet("Hưng lợi, Ninh Kiều, Cần Thơ"); // Optional: You can also add a description

        // Add the marker to the map
        Marker marker = googleMap.addMarker(markerOptions);

        // Set the zoom level to 12 and move the camera
        float zoomLevel = 14.0f; //This goes up to 21
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, zoomLevel));

        // Show the info window for the marker
        marker.showInfoWindow();
    }

}

