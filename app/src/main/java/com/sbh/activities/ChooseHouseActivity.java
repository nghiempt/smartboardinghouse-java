package com.sbh.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sbh.R;
import com.sbh.adapter.ChooseHouseAdapter;

import java.util.ArrayList;
import java.util.List;

public class ChooseHouseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_house);

        RecyclerView recyclerView;
        ChooseHouseAdapter adapter;
        List<String> data;

        recyclerView = findViewById(R.id.rcvListHouse);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        data = getData();
        adapter = new ChooseHouseAdapter(data);
        recyclerView.setAdapter(adapter);
    }

    private List<String> getData() {
        List<String> data = new ArrayList<>();
        data.add("Nhà trọ Pham Nghiem");
        data.add("Nhà trọ Hung Nguyen");
        data.add("Nhà trọ Trinh Phung");
        data.add("Nhà trọ Bang Ngo");
        return data;
    }
}