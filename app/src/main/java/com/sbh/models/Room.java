package com.sbh.models;

import java.io.Serializable;

public class Room implements Serializable {
    private int ID;
    private double area;
    private double price;
    private int maxPeople;
    private int status;
    private int numberRoom;

    public Room() {
    }

    public Room(int ID, double area, double price, int maxPeople, int status, int numberRoom) {
        this.ID = ID;
        this.area = area;
        this.price = price;
        this.maxPeople = maxPeople;
        this.status = status;
        this.numberRoom = numberRoom;
    }

    public int getID() {
        return ID;
    }

    public int getNumberRoom() {
        return numberRoom;
    }

    public void setNumberRoom(int numberRoom) {
        this.numberRoom = numberRoom;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
