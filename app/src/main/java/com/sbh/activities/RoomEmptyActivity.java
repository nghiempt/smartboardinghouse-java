package com.sbh.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
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
import android.widget.Toast;

import com.sbh.R;

public class RoomEmptyActivity extends AppCompatActivity {
    CardView back;
    AppCompatButton bt;
    FrameLayout overlayLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_empty);

        back= findViewById(R.id.btnBackToManagement);
        overlayLayout = findViewById(R.id.lo_toimau);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        bt = findViewById(R.id.btnAddMember);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAddMember(Gravity.CENTER);
                overlayLayout.setVisibility(View.VISIBLE);
            }
        });

    }
    private void openAddMember(int gravity){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.layout_popup_add_member);

        Window window = dialog.getWindow();
        if (window == null){
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams windowAttributes = window.getAttributes();
        windowAttributes.gravity = gravity;
        window.setAttributes(windowAttributes);


        if (Gravity.CENTER == gravity){
            overlayLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss(); // Tắt popup
                    overlayLayout.setVisibility(View.GONE);
                }
            });
        }else {
            dialog.setCancelable(false);
        }
        EditText edtTen = dialog.findViewById(R.id.edtTen);
        EditText edtSdt = dialog.findViewById(R.id.edtSdt);
        Button btnThem = dialog.findViewById(R.id.btnThem);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(RoomEmptyActivity.this,"Thanh cong", Toast.LENGTH_LONG).show();
                dialog.dismiss();
                overlayLayout.setVisibility(View.GONE);
            }
        });
        dialog.show();
    }
}