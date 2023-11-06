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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.sbh.R;
import com.sbh.adapter.RoomHouseAdapter;
import com.sbh.api.RecyclerViewInterface;
import com.sbh.models.Account;
import com.sbh.models.AccountProfile;
import com.sbh.models.Room;
import com.sbh.models.RoomHouse;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ManagementActivity extends AppCompatActivity {

    private RecyclerView crvRoomHouse;
    private RoomHouseAdapter mRoomHouseAdapter;
    private TextView textView;
    RoomHouse roomHouse;
    List<RoomHouse> roomHouseList;
    Intent intentMotelDetailManage;
    private ConstraintLayout layoutContainer;

    ActivityResultLauncher<Intent> mActivityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode() == RESULT_OK) {
                Intent intent = result.getData();
                mRoomHouseAdapter.setmListRoomHouse(setRoomHouseTable());
                crvRoomHouse.setAdapter(mRoomHouseAdapter);
            }
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management);

        layoutContainer = (ConstraintLayout) findViewById(R.id.layout_container);
        crvRoomHouse = findViewById(R.id.rcvDataManageMotel);
        textView = (TextView) findViewById(R.id.txtViewManageMotel);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        crvRoomHouse.setLayoutManager(linearLayoutManager);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        crvRoomHouse.addItemDecoration(itemDecoration);

        mRoomHouseAdapter = new RoomHouseAdapter(setRoomHouseTable(), new RecyclerViewInterface() {
            @Override
            public void onItemClick(RoomHouse roomHouse) {
                onClickToMotelDetailManage(roomHouse);
            }

            @Override
            public void onRoomClickManage(Room room) {}

            @Override
            public void onRoomDetailClickManage(AccountProfile accountProfile) {}
        });

        crvRoomHouse.setAdapter(mRoomHouseAdapter);

        textView.setText(mRoomHouseAdapter.getItemCount() + " Nhà trọ đang quản lý");

//        intentMotelDetailManage = new Intent()
    }

    private List<RoomHouse> setRoomHouseTable() {
//        callApi
        List<RoomHouse> dataList = new ArrayList<>();
        dataList.add(new RoomHouse("Nha tro cua Hung"
                , 4000000, "Ninh Kieu - Can Tho"
                , " ", 4.7, 81));
        dataList.add(new RoomHouse("Nha tro cua Trinh"
                , 3000000, "Ninh Kieu - Can Tho"
                , " ", 4.7, 81));
        dataList.add(new RoomHouse("Nha tro cua Hung"
                , 4000000, "Ninh Kieu - Can Tho"
                , " ", 4.7, 81));
        dataList.add(new RoomHouse("Nha tro cua Trinh"
                , 3000000, "Ninh Kieu - Can Tho"
                , " ", 4.7, 81));
        return dataList;
    }

    public void onClickToMotelDetailManage(RoomHouse data) {
        Intent intent = new Intent(this, MotelDetailManageActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("dataTransfer", (Serializable) data);
        intent.putExtras(bundle);
        mActivityResultLauncher.launch(intent);
    }

//    private void addNewHouse() {
//
//    }
//
//    public void createPopUpWindow() {
//        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
//        View popUpView = inflater.inflate(R.layout.popup_addnew_house, null);
//        int width = ViewGroup.LayoutParams.MATCH_PARENT;
//        int heigh = ViewGroup.LayoutParams.WRAP_CONTENT;
//        boolean focusable = true;
//        PopupWindow popupWindow = new PopupWindow(popUpView, width, heigh, focusable);
//
//        Button btnAddNewHousePopup = (Button) popupWindow.getContentView().findViewById(R.id.btnCancelAddHouse);
//        Button btnCancelAddHousePopup = (Button) popupWindow.getContentView().findViewById(R.id.btnCancelAddHouse);
//
//        btnCancelAddHousePopup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                popupWindow.dismiss();
//            }
//        });
//
//        btnAddNewHousePopup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                addNewHouse();
//            }
//        });
//
//        layoutContainer.post(new Runnable() {
//            @Override
//            public void run() {
//                layoutContainer.setAlpha(0.5f);
//                popupWindow.showAtLocation(layoutContainer, Gravity.TOP, 0, 0);
//            }
//        });
//
//        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
//            @Override
//            public void onDismiss() {
//                layoutContainer.setAlpha(1f);
//            }
//        });
//    }
}