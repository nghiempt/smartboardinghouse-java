package com.sbh.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sbh.R;
import com.sbh.adapter.ListRoomAdapter;
import com.sbh.api.APIService;
import com.sbh.models.Room;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

public class ListRoomActivity extends AppCompatActivity {

    CardView back;
    ImageView map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_room);

        RecyclerView recyclerView;
        ListRoomAdapter adapter;
        List<String> data;

        recyclerView = findViewById(R.id.rcvListRoom);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        data = getData();
        adapter = new ListRoomAdapter(data);
        recyclerView.setAdapter(adapter);
        // Đăng ký một ItemClickListener cho RecyclerView
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                // Xử lý sự kiện click ở đây
                goToRoomDetail();
            }

            @Override
            public void onLongItemClick(View view, int position) {
                // Xử lý sự kiện long click ở đây nếu cần
            }
        }));
        back = findViewById(R.id.btnBackToManagement);
        map= findViewById(R.id.imageView);
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
    }

    private List<String> getData() {
        Call<List<Room>> rooms = APIService.apiService.getAllRoom();
        List<String> data = new ArrayList<>();


//        data.add("1");
//        data.add("2");
//        data.add("3");
//        data.add("4");
//        data.add("5");
//        data.add("6");
//        data.add("7");
//        data.add("8");
//        data.add("9");
//        data.add("10");
        return data;
    }


    public void goToRoomDetail() {
        Intent intent = new Intent(this, RoomDetailActivity.class);
        startActivity(intent);
    }
    public void goToMap() {
        Intent intent = new Intent(this, MapActivity.class);
        startActivity(intent);
    }

}