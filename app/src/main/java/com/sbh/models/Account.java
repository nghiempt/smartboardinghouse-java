package com.sbh.models;

public class Account {
    private int ID;
    private String username;
    private String password;
    private int role;
    private String key;

    public Account() {
    }

    public Account(int ID, String username, String password, int role, String key) {
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.role = role;
        this.key = key;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
