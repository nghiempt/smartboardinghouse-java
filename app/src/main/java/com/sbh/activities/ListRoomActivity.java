package com.sbh.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sbh.R;
import com.sbh.adapter.ListRoomAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListRoomActivity extends AppCompatActivity {

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
    }

    private List<String> getData() {
        List<String> data = new ArrayList<>();
        data.add("1");
        data.add("2");
        data.add("3");
        data.add("4");
        return data;
    }
}