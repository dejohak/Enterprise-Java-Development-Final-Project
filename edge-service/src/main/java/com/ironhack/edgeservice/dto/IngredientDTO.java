package com.ironhack.edgeservice.dto;

public class IngredientDTO {
    private String product;
    private String quantity;

    public IngredientDTO() {
    }

    public IngredientDTO(String product, String quantity) {
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
