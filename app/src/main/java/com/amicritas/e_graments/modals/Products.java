package com.amicritas.e_graments.modals;

public class Products {
    String productId;
    String productTitle;
    String productCategory;
    String productSubCategory;

    public Products() {
    }

    public Products(String productId, String productTitle, String productCategory, String productSubCategory) {
        this.productId = productId;
        this.productTitle = productTitle;
        this.productCategory = productCategory;
        this.productSubCategory = productSubCategory;
    }

    public Products(String productId, String productTitle, String productCategory) {
        this.productId = productId;
        this.productTitle = productTitle;
        this.productCategory = productCategory;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductSubCategory() {
        return productSubCategory;
    }

    public void setProductSubCategory(String productSubCategory) {
        this.productSubCategory = productSubCategory;
    }
}
