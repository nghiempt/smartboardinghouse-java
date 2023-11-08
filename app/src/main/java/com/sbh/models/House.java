package com.sbh.models;

import java.util.List;

public class House {
    private int ID;
    private String name;
    private int numberOfRooms;
    private int numberOfRoomsAvailable;
    private List<String> houseImage;
    private String lat;
    private String lng;
    private String province;
    private String district;
    private String ward;
    private String phoneNumber;
    private String price;
    private int accountID;

    public House() {
    }

    public House(int ID, String name, int numberOfRooms, int numberOfRoomsAvailable, List<String> houseImage, String lat, String lng, String province, String district, String ward, String phoneNumber, String price, int accountID) {
        this.ID = ID;
        this.name = name;
        this.numberOfRooms = numberOfRooms;
        this.numberOfRoomsAvailable = numberOfRoomsAvailable;
        this.houseImage = houseImage;
        this.lat = lat;
        this.lng = lng;
        this.province = province;
        this.district = district;
        this.ward = ward;
        this.phoneNumber = phoneNumber;
        this.price = price;
        this.accountID = accountID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public int getNumberOfRoomsAvailable() {
        return numberOfRoomsAvailable;
    }

    public void setNumberOfRoomsAvailable(int numberOfRoomsAvailable) {
        this.numberOfRoomsAvailable = numberOfRoomsAvailable;
    }

    public List<String> getHouseImage() {
        return houseImage;
    }

    public void setHouseImage(List<String> houseImage) {
        this.houseImage = houseImage;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }
}

