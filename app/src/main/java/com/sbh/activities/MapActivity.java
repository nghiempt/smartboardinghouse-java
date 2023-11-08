package com.sbh.activities;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.sbh.R;

import java.io.IOException;
import java.util.List;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {

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
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        System.out.println("aa");


//        GoogleMap mMap = googleMap;
//
//        // Lấy thông tin địa chỉ từ Intent
//        Intent intent = getIntent();
//        String diaChi = intent.getStringExtra("diaChi");
//
//        if (diaChi != null && !diaChi.isEmpty()) {
//            // Tìm kiếm và hiển thị địa chỉ trên bản đồ
//            // Ví dụ: sử dụng Geocoder để chuyển địa chỉ thành tọa độ và đánh dấu lên bản đồ.
//            // Đây là một ví dụ đơn giản:
//            Geocoder geocoder = new Geocoder(this);
//            try {
//                List<Address> addresses = geocoder.getFromLocationName(diaChi, 1);
//                if (!addresses.isEmpty()) {
//                    Address address = addresses.get(0);
//                    LatLng location = new LatLng(address.getLatitude(), address.getLongitude());
//                    mMap.addMarker(new MarkerOptions().position(location).title(diaChi));
//                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 12.0f)); // Zoom level
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }

}

