package com.ironhack.recipesservice.service.interfaces;

import com.ironhack.recipesservice.dto.IngredientDTO;
import com.ironhack.recipesservice.dto.RecipeDTO;

import java.util.List;

public interface IRecipeService {
    List<RecipeDTO> getAllRecipes();

    RecipeDTO getRecipeById(Long id);

    List<RecipeDTO> getRecipeByIngredient(String ingredient);

    void deleteRecipe(Long id);

    List<RecipeDTO> getRecipeByFoodType(String foodType);

    RecipeDTO postRecipe(RecipeDTO recipeDTO);

    void changeRecipe(RecipeDTO recipeDTO);

    List<IngredientDTO> getIngredients();

    List<RecipeDTO> getRecipeByFlavour(String taste);

    RecipeDTO getRecipeByName(String name);
}
