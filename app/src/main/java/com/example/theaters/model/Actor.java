package com.example.theaters.model;

import java.io.Serializable;

public class Actor implements Serializable {
    private String name;
    private String imgUrl;

    public Actor() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
