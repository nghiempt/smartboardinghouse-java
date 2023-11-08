package com.sbh.models;

public class Room {
    private int ID;
    private int room_number;
    private int area;
    private int maxPeople;
    private int status;

    // Constructor
    public Room(int ID, int room_number, int area, int maxPeople, int status) {
        this.ID = ID;
        this.room_number = room_number;
        this.area = area;
        this.maxPeople = maxPeople;
        this.status = status;
    }

    // Getters
    public int getID() {
        return ID;
    }

    public int getRoomNumber() {
        return room_number;
    }

    public int getArea() {
        return area;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public int getStatus() {
        return status;
    }

    // Setters
    public void setID(int ID) {
        this.ID = ID;
    }

    public void setRoomNumber(int roomNumber) {
        this.room_number = roomNumber;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
