package com.example.testapp;

import android.media.Image;

public class DataModel {
    private String title;
    private String description;

    private int img;

    public DataModel(String title, String description,int img) {
        this.title = title;
        this.description = description;
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
    public int getImg() {
        return img;
    }
}
