package com.sbh.api;

import com.sbh.models.Account;
import com.sbh.models.AccountProfile;
import com.sbh.models.Room;
import com.sbh.models.RoomHouse;

public interface RecyclerViewInterface {

    void onItemClick(RoomHouse roomHouse);

    void onRoomClickManage(Room room);

    void onRoomDetailClickManage(AccountProfile accountprofile);
}
