package com.sbh.models;

public class RoomImage {
    private int roomID;
    private String link;

    public RoomImage() {
    }

    public RoomImage(int roomID, String link) {
        this.roomID = roomID;
        this.link = link;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
