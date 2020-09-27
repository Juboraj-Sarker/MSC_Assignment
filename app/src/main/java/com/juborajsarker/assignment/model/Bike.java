package com.juborajsarker.assignment.model;

public class Bike {

    String bikeName;
    String brandName;
    String brandOrigin;
    String price;
    int imageID;

    public Bike() {

    }


    public Bike(String bikeName, String brandName, String brandOrigin, String price, int imageID) {
        this.bikeName = bikeName;
        this.brandName = brandName;
        this.brandOrigin = brandOrigin;
        this.price = price;
        this.imageID = imageID;
    }

    public String getBikeName() {
        return bikeName;
    }

    public void setBikeName(String bikeName) {
        this.bikeName = bikeName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandOrigin() {
        return brandOrigin;
    }

    public void setBrandOrigin(String brandOrigin) {
        this.brandOrigin = brandOrigin;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }




}
