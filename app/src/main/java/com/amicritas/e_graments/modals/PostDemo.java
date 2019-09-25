package com.amicritas.e_graments.modals;

public class PostDemo {
    String title;
    String postedBy;
    String Price;

    public PostDemo() {
    }

    public PostDemo(String title, String postedBy, String price) {
        this.title = title;
        this.postedBy = postedBy;
        Price = price;
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
