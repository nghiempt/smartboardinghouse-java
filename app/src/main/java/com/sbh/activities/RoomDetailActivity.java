package com.sbh.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.sbh.R;

public class RoomDetailActivity extends AppCompatActivity {

    CardView back, hopdong;
    TextView lichsu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_detail);

        back= findViewById(R.id.btnBackToManagement);
        hopdong= findViewById(R.id.btnAddRoom);
        lichsu= findViewById(R.id.txtTransactionHistory);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        hopdong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToHopDong();
            }
        });
        lichsu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToLichSu();
            }
        });
    }

    public void goToHopDong() {
        Intent intent = new Intent(this, TransactionActivity.class);
        startActivity(intent);
    }

    public void goToLichSu() {
        Intent intent = new Intent(this, TransactionHistoryActivity.class);
        startActivity(intent);
    }
}