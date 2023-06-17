package com.example.express_application;

import android.net.Uri;

public class Servies {
    private String name;
    private String Price;
    private String image;
    private String Description;


    public Servies (){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Servies(String name, String Price, String image, String Description) {
        this.name = name;
        this.Price = Price;
        this.image = image;
        this.Description = Description;
    }

}