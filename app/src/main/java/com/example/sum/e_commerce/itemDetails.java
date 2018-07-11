package com.example.sum.e_commerce;

public class itemDetails {
    private String name;
    private String discription;
    private int price;
    private int image;

    public itemDetails(String name, String discription,  int price, int image) {
        this.name = name;
        this.discription = discription;
        this.price = price;
        this.image=image;
    }

    public String getDiscription() {
        return discription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public int getImage(){
        return image;
    }
}
