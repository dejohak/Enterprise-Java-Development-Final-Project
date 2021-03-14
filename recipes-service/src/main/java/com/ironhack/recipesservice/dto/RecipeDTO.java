package com.ironhack.recipesservice.dto;

import com.ironhack.recipesservice.classes.Ingredient;

import javax.validation.constraints.*;
import java.util.List;

public class RecipeDTO {
    @NotNull
    @Positive
    private Long id;
    @NotBlank
    @Size(min = 4, max = 50, message = "Recipes' names must be between 4 and 50 characters.")
    private String name;
    private String flavour;
    private String foodType;
    @Min(value = 1, message = "A recipe's prep time cannot be less than 1 minute.")
    @Max(value = 480, message = "A recipe's prep time cannot be more than 8 hours.")
    private Integer prepTime;
    @NotEmpty(message = "Recipes must have a list of ingredients!")
    private List<Ingredient> ingredients;
    @NotBlank(message = "There must be a description of the preparation ")
    private String preparation;
    private String photo;

    public RecipeDTO() {
    }

    public RecipeDTO(@NotNull @Positive Long id, @NotBlank @Size(min = 4, max = 50, message = "Recipes' names must be between 4 and 50 characters.") String name, String flavour, String foodType, @Min(value = 1, message = "A recipe's prep time cannot be less than 1 minute.") @Max(value = 480, message = "A recipe's prep time cannot be more than 8 hours.") Integer prepTime, @NotEmpty(message = "Recipes must have a list of ingredients!") List<Ingredient> ingredients, @NotBlank(message = "There must be a description of the preparation ") String preparation, String photo) {
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

    public String getFlavour() {
        return flavour;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
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
