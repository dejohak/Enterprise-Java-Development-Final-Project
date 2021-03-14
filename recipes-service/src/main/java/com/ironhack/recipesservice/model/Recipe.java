package com.ironhack.recipesservice.model;

import com.ironhack.recipesservice.classes.Ingredient;
import com.ironhack.recipesservice.enums.Flavour;
import com.ironhack.recipesservice.enums.FoodType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "recipes")
public class Recipe {
    @Id
    private Long id;
    private String name;
    private Flavour flavour;
    private FoodType foodType;
    private Integer prepTime;
    private List<Ingredient> ingredients;
    private String preparation;
    private String photo;

    public Recipe(Long id, String name, Flavour flavour, FoodType foodType, Integer prepTime, List<Ingredient> ingredients, String preparation, String photo) {
        this.id = id;
        this.name = name;
        this.flavour = flavour;
        this.foodType = foodType;
        this.prepTime = prepTime;
        this.ingredients = ingredients;
        this.preparation = preparation;
        this.photo = photo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Flavour getFlavour() {
        return flavour;
    }

    public void setFlavour(Flavour flavour) {
        this.flavour = flavour;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    public Integer getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(Integer prepTime) {
        this.prepTime = prepTime;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public String getPreparation() {
        return preparation;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
