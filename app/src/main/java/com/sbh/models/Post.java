package com.sbh.models;

public class Post {
    private int ID;
    private String title;
    private String location;
    private String content;
    private String image;

    public Post() {
    }

    public Post(int ID, String title, String location, String content, String image) {
        this.ID = ID;
        this.title = title;
        this.location = location;
        this.content = content;
        this.image = image;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
