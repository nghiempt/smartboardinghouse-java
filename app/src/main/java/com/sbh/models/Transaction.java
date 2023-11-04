package com.sbh.models;

import java.util.Date;

public class Transaction {
    private int ID;
    private int status;
    private Date date;
    private String type;
    private float total;

    public Transaction() {
    }

    public Transaction(int ID, int status, Date date, String type, float total) {
        this.ID = ID;
        this.status = status;
        this.date = date;
        this.type = type;
        this.total = total;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
