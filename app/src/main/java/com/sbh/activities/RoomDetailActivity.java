package com.sbh.activities;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.sbh.R;

public class RoomDetailActivity extends AppCompatActivity {

    CardView back, hopdong, bill;
    TextView lichsu;

    FrameLayout overlayLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_detail);

        back= findViewById(R.id.btnBackToManagement);
        hopdong= findViewById(R.id.btnAddRoom);
        lichsu= findViewById(R.id.txtTransactionHistory);
        overlayLayout = findViewById(R.id.lo_toimau);
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
        bill = findViewById(R.id.btnBill);
        bill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAddBill(Gravity.CENTER);
                overlayLayout.setVisibility(View.VISIBLE);
            }
        });
    }

    private void openAddBill(int gravity){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.layout_popup_bill);

        Window window = dialog.getWindow();
        if (window == null){
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams windowAttributes = window.getAttributes();
        windowAttributes.gravity = gravity;
        window.setAttributes(windowAttributes);

        if (Gravity.BOTTOM == gravity){
            dialog.setCancelable(true);
        }else {
            dialog.setCancelable(false);
        }
        EditText edtThang = dialog.findViewById(R.id.edtThang);
        EditText edtDien = dialog.findViewById(R.id.edtDien);
        EditText edtNuoc = dialog.findViewById(R.id.edtNuoc);
        Button btnThongbao = dialog.findViewById(R.id.btnThongbao);
        btnThongbao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(RoomDetailActivity.this,"Thanh cong", Toast.LENGTH_LONG).show();
                overlayLayout.setVisibility(View.GONE);
                dialog.dismiss();
            }
        });
        dialog.show();
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