package com.sbh.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.sbh.R;

public class ContrastActivity extends AppCompatActivity {

    private CardView btnBackToProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contrast);

        btnBackToProfile = (CardView) findViewById(R.id.btnBackToProfile);

        btnBackToProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backToProfile();
            }
        });
    }

    public void backToProfile() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}