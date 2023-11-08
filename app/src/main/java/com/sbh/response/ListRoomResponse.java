package com.sbh.response;

import com.sbh.models.House;
import com.sbh.models.Room;

import java.util.List;

public class ListRoomResponse {
    private boolean result;
    private int status_code;
    private String message;
    private List<Room> data;

    public List<Room> getData() {
        return data;
    }

    public void setData(List<Room> data) {
        this.data = data;
    }
}
