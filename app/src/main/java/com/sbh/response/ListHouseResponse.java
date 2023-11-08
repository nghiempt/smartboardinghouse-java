package com.sbh.response;

import com.sbh.models.House;

import java.util.List;

public class ListHouseResponse {
    private boolean result;
    private int status_code;
    private String message;
    private List<House> data;

    public List<House> getData() {
        return data;
    }

    public void setData(List<House> data) {
        this.data = data;
    }
}

