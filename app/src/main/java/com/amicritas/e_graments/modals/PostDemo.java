package com.amicritas.e_graments.modals;

public class PostDemo {
    String title;
    String postedBy;
    String Price;
    int img;
    String fevoriteStatus;
    String flagStatus;

    public PostDemo(String title, String postedBy, String price, int img, String fevoriteStatus, String flagStatus) {
        this.title = title;
        this.postedBy = postedBy;
        Price = price;
        this.img = img;
        this.fevoriteStatus = fevoriteStatus;
        this.flagStatus = flagStatus;
    }

    public PostDemo(String title, String postedBy, String price, int img) {
        this.title = title;
        this.postedBy = postedBy;
        Price = price;
        this.img = img;
    }

    public PostDemo() {
    }

    public String getFevoriteStatus() {
        return fevoriteStatus;
    }

    public void setFevoriteStatus(String fevoriteStatus) {
        this.fevoriteStatus = fevoriteStatus;
    }

    public String getFlagStatus() {
        return flagStatus;
    }

    public void setFlagStatus(String flagStatus) {
        this.flagStatus = flagStatus;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }
}
