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
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sbh.R;
import com.sbh.adapter.ChooseHouseAdapter;
import com.sbh.adapter.ListRoomAdapter;
import com.sbh.api.APIService;
import com.sbh.models.Room;
import com.sbh.response.ListHouseResponse;
import com.sbh.response.ListRoomResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import retrofit2.Call;

public class ListRoomActivity extends AppCompatActivity {

    CardView back;
    ImageView map;

    RecyclerView recyclerView;
    ListRoomAdapter adapter;
    List<Room> listRoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_room);

        recyclerView = findViewById(R.id.rcvListRoom);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                goToRoomDetail();
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));
        back = findViewById(R.id.btnBackToManagement);
        map = findViewById(R.id.imageView);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToMap();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        getRoomByHouseID();

    }

    private void getRoomByHouseID() {
        APIService.apiService._getRoomByHouseID().enqueue(new Callback<ListRoomResponse>() {
            @Override
            public void onResponse(Call<ListRoomResponse> call, Response<ListRoomResponse> response) {
                System.out.println("================= SUCCESS =================");
                if (response.isSuccessful() && response.body() != null) {
                    listRoom = response.body().getData();
                    ListRoomAdapter adapter = new ListRoomAdapter(listRoom);
                    recyclerView.setAdapter(adapter);
                    System.out.println(response.body().getData().get(1).getRoomNumber());
                } else {
                    System.out.println("Response was not successful or was empty");
                }
                System.out.println("===========================================");
            }

            @Override
            public void onFailure(Call<ListRoomResponse> call, Throwable t) {
                System.out.println("================= ERROR =================");
                t.printStackTrace();
                System.out.println("=========================================");
            }
        });
    }


    public void goToRoomDetail() {
        Intent intent = new Intent(this, RoomDetailActivity.class);
        startActivity(intent);
    }

    public void goToMap() {
        Intent intent = new Intent(this, MapActivity.class);
        startActivity(intent);
    }

    private void openAddRoom(int gravity){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.layout_popup_add_room);

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
        EditText edtGiaTien = dialog.findViewById(R.id.edtGiaTien);
        EditText edtSoNguoi = dialog.findViewById(R.id.edtSoNguoi);
        Button btnTaoPhong = dialog.findViewById(R.id.btnTaoPhong);
        btnTaoPhong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ListRoomActivity.this,"Thanh cong", Toast.LENGTH_LONG).show();
                getData().add("7");
                overlayLayout.setVisibility(View.GONE);
                dialog.dismiss();
            }
        });
        dialog.show();
    }




    public void goToRoomDetail() {
        Intent intent = new Intent(this, RoomDetailActivity.class);
        startActivity(intent);
    }
    public void goToMap() {
        Intent intent = new Intent(this, MapActivity.class);
        startActivity(intent);
    }
    public void goToRoomEmpty() {
        Intent intent = new Intent(this, RoomEmptyActivity.class);
        startActivity(intent);
    }

}