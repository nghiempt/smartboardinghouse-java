package com.sbh.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sbh.R;
import com.sbh.adapter.ChooseHouseAdapter;
import com.sbh.api.APIService;
import com.sbh.models.House;
import com.sbh.response.ListHouseResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChooseHouseActivity extends AppCompatActivity {

    List<House> listHouse;
    RecyclerView recyclerView;
    ChooseHouseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_house);

        recyclerView = findViewById(R.id.rcvListHouse);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                goToListRoom();
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));

        // get house by account ID
        getHouseByAccountID();
    }

    private void getHouseByAccountID() {
        APIService.apiService._getHouseByAccountID().enqueue(new Callback<ListHouseResponse>() {
            @Override
            public void onResponse(Call<ListHouseResponse> call, Response<ListHouseResponse> response) {
                System.out.println("================= SUCCESS =================");
                if (response.isSuccessful() && response.body() != null) {
                    listHouse = response.body().getData();
                    ChooseHouseAdapter adapter = new ChooseHouseAdapter(listHouse);
                    recyclerView.setAdapter(adapter);
                    System.out.println(response.body().getData());
                } else {
                    System.out.println("Response was not successful or was empty");
                }
                System.out.println("===========================================");
            }

            @Override
            public void onFailure(Call<ListHouseResponse> call, Throwable t) {
                System.out.println("================= ERROR =================");
                t.printStackTrace();
                System.out.println("=========================================");
            }
        });
    }


    public void goToListRoom() {
        Intent intent = new Intent(this, ListRoomActivity.class);
        startActivity(intent);
    }

}
