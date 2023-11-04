package com.sbh.models;

import java.io.Serializable;

public class RoomHouse implements Serializable {
    private String name;
    private double price;
    private String address;
    private String image;
    private double rate;
    private int nfeedback;

    public RoomHouse() {
    }

    public RoomHouse(String name, double price, String address, String image, double rate, int nfeedback) {
        this.name = name;
        this.price = price;
        this.address = address;
        this.image = image;
        this.rate = rate;
        this.nfeedback = nfeedback;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getNfeedback() {
        return nfeedback;
    }

    public void setNfeedback(int nfeedback) {
        this.nfeedback = nfeedback;
    }
}
