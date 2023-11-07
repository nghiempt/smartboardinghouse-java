package com.sbh.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sbh.R;
import com.sbh.adapter.TransactionHistoryAdapter;

import java.util.ArrayList;
import java.util.List;

public class TransactionHistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_history);

        RecyclerView recyclerView;
        TransactionHistoryAdapter adapter;
        List<String> data;

        recyclerView = findViewById(R.id.rcvTransactionHistory);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        data = getData();
        adapter = new TransactionHistoryAdapter(data);
        recyclerView.setAdapter(adapter);
    }

    private List<String> getData() {
        List<String> data = new ArrayList<>();
        data.add("Thanh toán tiền trọ (07/11/2023)");
        data.add("Thanh toán tiền trọ (06/11/2023)");
        data.add("Thanh toán tiền trọ (05/11/2023)");
        data.add("Thanh toán tiền trọ (04/11/2023)");
        return data;
    }
}