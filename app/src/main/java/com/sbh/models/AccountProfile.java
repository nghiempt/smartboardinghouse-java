package com.sbh.models;

import java.io.Serializable;
import java.util.Date;

public class AccountProfile implements Serializable {
    private int ID;
    private String image;
    private Date birthday;
    private String fullName;
    private String phoneNumber;

    public AccountProfile() {
    }

    public AccountProfile(int ID, String image, Date birthday, String fullName, String phoneNumber) {
        this.ID = ID;
        this.image = image;
        this.birthday = birthday;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
