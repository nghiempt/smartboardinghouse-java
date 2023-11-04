package com.sbh.models;

public class BoardingHouse {
    private int ID;
    private int numberOfRooms;
    private String province;
    private String district;
    private String ward;
    private String phoneNumber;

    public BoardingHouse() {
    }

    public BoardingHouse(int ID, int numberOfRooms, String province, String district, String ward, String phoneNumber) {
        this.ID = ID;
        this.numberOfRooms = numberOfRooms;
        this.province = province;
        this.district = district;
        this.ward = ward;
        this.phoneNumber = phoneNumber;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
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
}
