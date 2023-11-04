package com.sbh.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.sbh.R;
import com.sbh.fragment.HomeFragment;
import com.sbh.fragment.MessageFragment;
import com.sbh.fragment.ProfileFragment;
import com.sbh.fragment.SearchFragment;

public class MainActivity extends AppCompatActivity {
    private TextView username;
    private TextView password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            Fragment selectedFragment = null;

            if (item.getItemId() == R.id.navigation_home) {
                selectedFragment = new HomeFragment();
            } if (item.getItemId() == R.id.navigation_search) {
                selectedFragment = new SearchFragment();
            } else if (item.getItemId() == R.id.navigation_message) {
                selectedFragment = new MessageFragment();
            } else if (item.getItemId() == R.id.navigation_profile) {
                selectedFragment = new ProfileFragment();
            }

            if (selectedFragment != null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, selectedFragment)
                        .commit();
            }

            return true;
        });

//        username = findViewById(R.id.username1);
//        password = findViewById(R.id.password1);

        // Set the default fragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new HomeFragment())
                .commit();
    }
}