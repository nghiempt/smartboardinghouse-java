package com.sbh.models;

import java.util.Date;

public class UserComment {
    private int ID;
    private String content;
    private double rating;
    private Date time;

    public UserComment() {
    }

    public UserComment(int ID, String content, double rating, Date time) {
        this.ID = ID;
        this.content = content;
        this.rating = rating;
        this.time = time;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
