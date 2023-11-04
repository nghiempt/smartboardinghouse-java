package com.sbh.activities;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

import com.sbh.R;
import com.sbh.adapter.RoomAdapter;
import com.sbh.api.RecyclerViewInterface;
import com.sbh.models.AccountProfile;
import com.sbh.models.Room;
import com.sbh.models.RoomHouse;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MotelDetailManageActivity extends AppCompatActivity {
    private RecyclerView rcvRoom;
    private RoomAdapter mRoomAdapter;

    Room room;
    List<Room> roomList;
    CardView btnAddNewRoom;
    CardView btnBackToManagement;
    Intent intentRoomDetailManage;
    private ConstraintLayout layoutContainer;

    ActivityResultLauncher<Intent> mActivityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode() == RESULT_OK) {
                Intent intent = result.getData();
                mRoomAdapter.setmListRoom(setRoomTable());
                rcvRoom.setAdapter(mRoomAdapter);
            }
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motel_detail_manage);

        layoutContainer = (ConstraintLayout) findViewById(R.id.layout_container);

        btnAddNewRoom = (CardView) findViewById(R.id.btnAddNewRoom);
        btnBackToManagement = (CardView) findViewById(R.id.btnBackToManagement);
        rcvRoom = findViewById(R.id.rcvRoomManage);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        rcvRoom.setLayoutManager(gridLayoutManager);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rcvRoom.addItemDecoration(itemDecoration);

        Intent intent = getIntent();
        if (intent != null && intent.getExtras() != null) {
            Bundle bundle = intent.getExtras();
            RoomHouse roomHouse = (RoomHouse) bundle.getSerializable("dataTransfer");
            // Bây giờ bạn có thể sử dụng roomHouse để làm gì đó.
        }

        mRoomAdapter = new RoomAdapter(setRoomTable(), new RecyclerViewInterface() {
            @Override
            public void onItemClick(RoomHouse roomHouse) {
            }

            @Override
            public void onRoomClickManage(Room room) {
                onClickRoomManage(room);
            }

            @Override
            public void onRoomDetailClickManage(AccountProfile accountProfile) {}
        });

        rcvRoom.setAdapter(mRoomAdapter);

        btnAddNewRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createPopUpWindow();
            }
        });

        btnBackToManagement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBtnBackToManagement();
            }
        });
    }

    void back2Main() {
        Intent intent = new Intent(this, MainActivity.class);
        setResult(RESULT_OK, intent);
        finish();
    }

    private List<Room> setRoomTable() {
//        call api
        List<Room> dataList = new ArrayList<>();
        Room room1 = new Room(1, 250.5, 150.00, 4, 1, 102);
        Room room2 = new Room(2, 300.0, 180.50, 3, 1, 103);
        Room room3 = new Room(3, 200.75, 220.25, 2, 0, 104);
        Room room4 = new Room(4, 180.0, 120.75, 2, 1, 105);
        Room room5 = new Room(5, 275.25, 200.00, 3, 0, 106);
        dataList.add(room1);
        dataList.add(room2);
        dataList.add(room3);
        dataList.add(room4);
        dataList.add(room5);

        return dataList;
    }

    public void onClickRoomManage(Room data) {
        Intent intent = new Intent(this, RoomDetailManageActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("roomTransfer", (Serializable) data);
        intent.putExtras(bundle);
        mActivityResultLauncher.launch(intent);
    }

    public void setBtnBackToManagement() {
        Intent intent = new Intent(this, ManagementActivity.class);
        startActivity(intent);
    }

    public void createPopUpWindow() {
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popUpView = inflater.inflate(R.layout.popup_addnew_room, null);
        int width = ViewGroup.LayoutParams.MATCH_PARENT;
        int heigh = ViewGroup.LayoutParams.WRAP_CONTENT;
        boolean focusable = true;
        PopupWindow popupWindow = new PopupWindow(popUpView, width, heigh, focusable);

//        Button btnAddNewRoomPopup = (Button) findViewById(R.id.btnAddRoom);
        Button btnCancelAddRoomPopup = (Button) popupWindow.getContentView().findViewById(R.id.btnCancelAddRoom);

        btnCancelAddRoomPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
            }
        });

        layoutContainer.post(new Runnable() {
            @Override
            public void run() {
                layoutContainer.setAlpha(0.5f);
                popupWindow.showAtLocation(layoutContainer, Gravity.CENTER, 0, 0);
            }
        });

        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                layoutContainer.setAlpha(1f);
            }
        });
    }
}