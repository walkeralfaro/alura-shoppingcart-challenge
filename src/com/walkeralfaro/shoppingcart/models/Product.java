package com.walkeralfaro.shoppingcart.models;

public class Product {
    private String description;
    private int price;

    public Product(String description, int price) {
        this.description = description;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }
}
