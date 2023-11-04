package com.sbh.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sbh.R;
import com.sbh.adapter.AccountProfileAdapter;
import com.sbh.api.RecyclerViewInterface;
import com.sbh.models.AccountProfile;
import com.sbh.models.Room;
import com.sbh.models.RoomHouse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RoomDetailManageActivity extends AppCompatActivity {

    private RecyclerView rcvMember;
    private AccountProfileAdapter mAccountProfileAdapter;
    private CardView btnBackToMotelDetailManage;
    AccountProfile accountProfile;
    List<AccountProfile> accountProfileList;
    Intent intentMemberManage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_detail_manage);

        btnBackToMotelDetailManage = (CardView) findViewById(R.id.btnBackToMotelDetailManage);

        rcvMember = findViewById(R.id.rcvRoomDetailManage);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcvMember.setLayoutManager(linearLayoutManager);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rcvMember.addItemDecoration(itemDecoration);

        Intent intent = getIntent();
        if (intent != null && intent.getExtras() != null) {
            Bundle bundle = intent.getExtras();
            Room room = (Room) bundle.getSerializable("roomTransfer");
            // Bây giờ bạn có thể sử dụng roomHouse để làm gì đó.
        }

        mAccountProfileAdapter = new AccountProfileAdapter(setMemberTable(), new RecyclerViewInterface() {
            @Override
            public void onItemClick(RoomHouse roomHouse) {

            }

            @Override
            public void onRoomClickManage(Room room) {

            }

            @Override
            public void onRoomDetailClickManage(AccountProfile accountprofile) {

            }
        });

        rcvMember.setAdapter(mAccountProfileAdapter);

        btnBackToMotelDetailManage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back2MotelDetailManage();
            }
        });
    }

    void back2MotelDetailManage() {
        Intent intent = new Intent(this, MotelDetailManageActivity.class);
        setResult(RESULT_OK, intent);
        finish();
    }

    private List<AccountProfile> setMemberTable() {
        List<AccountProfile> dataList = new ArrayList<>();
        AccountProfile acc1 = new AccountProfile(1, "image", new Date(), "hai bang", "0822766300");
        AccountProfile acc2 = new AccountProfile(2, "image", new Date(), "hung", "0822766300");
        AccountProfile acc3 = new AccountProfile(3, "image", new Date(), "nghiem", "0822766300");
        dataList.add(acc1);
        dataList.add(acc2);
        dataList.add(acc3);
        return dataList;
    }
}