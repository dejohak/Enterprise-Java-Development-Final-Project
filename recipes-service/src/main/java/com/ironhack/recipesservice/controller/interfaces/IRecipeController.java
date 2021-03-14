package com.ironhack.recipesservice.controller.interfaces;

import com.ironhack.recipesservice.dto.IngredientDTO;
import com.ironhack.recipesservice.dto.RecipeDTO;

import java.util.List;

public interface IRecipeController {
    List<RecipeDTO> getAllRecipes();

    List<IngredientDTO> getAllIngredients();

    RecipeDTO getRecipeById(Long id);

    List<RecipeDTO> getRecipeByIngredient(String ingredient);

    void deleteRecipe(Long id);

    List<RecipeDTO> getRecipeByBakedGood(String foodType);

    List<RecipeDTO> getRecipeByFlavour(String taste);

    RecipeDTO createRecipe(RecipeDTO recipeDTO);

    void updateRecipe(RecipeDTO recipeDTO);

    RecipeDTO getRecipeByName(String name);
}
