package com.example.theaters.model;

import java.io.Serializable;

public class Theater implements Serializable {

    private int imageId;
    private String name;
    private String address;
    private String site;
    private String vk;
    private String tel;
    private String troupeUrl;

    public Theater() {
    }

    public int getImageId() { return imageId; }
    public void setImageId(int imageId) { this.imageId = imageId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getSite() { return site; }
    public void setSite(String site) { this.site = site; }

    public String getVk() { return vk; }
    public void setVk(String vk) { this.vk = vk; }

    public String getTel() { return tel; }
    public void setTel(String tel) { this.tel = tel; }

    public String getTroupeUrl() { return troupeUrl; }
    public void setTroupeUrl(String troupeUrl) { this.troupeUrl = troupeUrl; }
}
