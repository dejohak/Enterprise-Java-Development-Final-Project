package com.ironhack.recipesservice.classes;

public class Ingredient {
    private String product;
    // quantity is a string because the metric differs between foods
    private String quantity;

    public Ingredient() {
    }

    public Ingredient(String product, String quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
