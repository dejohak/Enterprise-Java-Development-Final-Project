package com.ironhack.recipesservice.service.impl;

import com.ironhack.recipesservice.classes.Ingredient;
import com.ironhack.recipesservice.dto.IngredientDTO;
import com.ironhack.recipesservice.dto.RecipeDTO;
import com.ironhack.recipesservice.enums.Flavour;
import com.ironhack.recipesservice.enums.FoodType;
import com.ironhack.recipesservice.model.Recipe;
import com.ironhack.recipesservice.repository.RecipeRepository;
import com.ironhack.recipesservice.service.interfaces.IRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeService implements IRecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public List<RecipeDTO> getAllRecipes() {
        List<Recipe> recipes = recipeRepository.findAll();
        List<RecipeDTO> recipeDTOList = new ArrayList<>();
        for (Recipe recipe : recipes) {
            recipeDTOList.add(new RecipeDTO(recipe.getId(),recipe.getName(),recipe.getFlavour().toString(),
                    recipe.getFoodType().toString(), recipe.getPrepTime(),recipe.getIngredients(),recipe.getPreparation(),
                    recipe.getPhoto()));
        }
        return recipeDTOList;
    }

    public RecipeDTO getRecipeById(Long id) {
        Optional<Recipe> recipe = recipeRepository.findById(id);
        if (recipe.isPresent()) {
            return new RecipeDTO(recipe.get().getId(),recipe.get().getName(),recipe.get().getFlavour().toString(),
                    recipe.get().getFoodType().toString(), recipe.get().getPrepTime(),recipe.get().getIngredients(),
                    recipe.get().getPreparation(),recipe.get().getPhoto());
        } else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Recipe not found");
    }

    public List<RecipeDTO> getRecipeByIngredient(String ingredient) {
        List<Recipe> recipes = recipeRepository.findAll();
        List<RecipeDTO> recipeDTOList = new ArrayList<>();
        boolean isOnList = false;
        for (Recipe recipe : recipes) {
            List<Ingredient> ingredients = recipe.getIngredients();
            for (Ingredient ingredientSearch : ingredients) {
                if (ingredientSearch.getProduct().toLowerCase().contains(ingredient.toLowerCase()) ||
                    ingredient.toLowerCase().contains(ingredientSearch.getProduct().toLowerCase())) {
                     if (!isOnList) {
                         recipeDTOList.add(new RecipeDTO(recipe.getId(), recipe.getName(), recipe.getFlavour().toString(),
                                 recipe.getFoodType().toString(), recipe.getPrepTime(), recipe.getIngredients(),
                                 recipe.getPreparation(), recipe.getPhoto()));
                         isOnList = true;
                     }
                }
            }
            isOnList = false;
        }
        if (recipeDTOList.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There are no recipes containing this ingredient.");
        } else return recipeDTOList;
    }

    public void deleteRecipe(Long id) {
        if (recipeRepository.existsById(id)) {
            recipeRepository.deleteById(id);
        } else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Recipe not found");
    }

    public List<RecipeDTO> getRecipeByFoodType(String foodType) {
        List<Recipe> recipes = recipeRepository.findAll();
        List<RecipeDTO> recipeDTOList = new ArrayList<>();
        for (Recipe recipe : recipes) {
            if (FoodType.valueOf(foodType.toUpperCase()).equals(recipe.getFoodType())) {
                recipeDTOList.add(new RecipeDTO(recipe.getId(), recipe.getName(), recipe.getFlavour().toString(),
                        recipe.getFoodType().toString(), recipe.getPrepTime(), recipe.getIngredients(),
                        recipe.getPreparation(), recipe.getPhoto()));
            }
        }
        if (recipeDTOList.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There are no recipes containing this baked good.");
        } else return recipeDTOList;
    }

    public List<RecipeDTO> getRecipeByFlavour(String taste) {
        List<Recipe> recipes = recipeRepository.findAll();
        List<RecipeDTO> recipeDTOList = new ArrayList<>();
        for (Recipe recipe : recipes) {
            if (Flavour.valueOf(taste.toUpperCase()).equals(recipe.getFlavour())) {
                recipeDTOList.add(new RecipeDTO(recipe.getId(), recipe.getName(), recipe.getFlavour().toString(),
                        recipe.getFoodType().toString(), recipe.getPrepTime(), recipe.getIngredients(),
                        recipe.getPreparation(), recipe.getPhoto()));
            }
        }
        if (recipeDTOList.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There are no recipes containing this flavour.");
        } else return recipeDTOList;
    }

    public RecipeDTO getRecipeByName(String name) {
        List<Recipe> recipes = recipeRepository.findAll();
        RecipeDTO recipeDTO = new RecipeDTO();
        boolean found = false;
        for (Recipe recipe : recipes) {
            if (recipe.getName().toLowerCase().contains(name) || name.toLowerCase().contains(recipe.getName())) {
                recipeDTO.setId(recipe.getId());
                recipeDTO.setName(recipe.getName());
                recipeDTO.setFlavour(recipe.getFlavour().toString());
                recipeDTO.setFoodType(recipe.getFoodType().toString());
                recipeDTO.setIngredients(recipe.getIngredients());
                recipeDTO.setPreparation(recipe.getPreparation());
                recipeDTO.setPrepTime(recipe.getPrepTime());
                recipeDTO.setPhoto(recipe.getPhoto());
                found = true;
            }
        } if (!found) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Recipe not found.");
        } else {
            return recipeDTO;
        }
    }


    public RecipeDTO postRecipe(RecipeDTO recipeDTO) {
        List<Recipe> recipes = recipeRepository.findAll();
        if (recipes.size() > 0) {
            recipeDTO.setId(recipes.get(recipes.size() - 1).getId() + 1);
        } else {
            recipeDTO.setId(1L);
        }
        recipeRepository.save(new Recipe(recipeDTO.getId(), recipeDTO.getName(),
                Flavour.valueOf(recipeDTO.getFlavour().toUpperCase()), FoodType.valueOf(recipeDTO.getFoodType().toUpperCase()),
                recipeDTO.getPrepTime(), recipeDTO.getIngredients(), recipeDTO.getPreparation(), recipeDTO.getPhoto()));
        return recipeDTO;
    }

    public void changeRecipe(RecipeDTO recipeDTO) {
        Optional<Recipe> recipe = recipeRepository.findById(recipeDTO.getId());
        if (recipe.isPresent()) {
            recipe.get().setIngredients(recipeDTO.getIngredients());
            recipe.get().setName(recipeDTO.getName());
            recipe.get().setPrepTime(recipeDTO.getPrepTime());
            recipe.get().setPreparation(recipeDTO.getPreparation());
            recipe.get().setPhoto(recipeDTO.getPhoto());
            recipeRepository.save(recipe.get());
        } else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Recipe not found");
    }

    public List<IngredientDTO> getIngredients() {
        List<Recipe> recipes = recipeRepository.findAll();
        List<IngredientDTO> ingredients = new ArrayList<>();
        for (Recipe recipe : recipes) {
            for (Ingredient ingredient : recipe.getIngredients()) {
                ingredients.add(new IngredientDTO(ingredient.getProduct(), ingredient.getQuantity()));
            }
        }
        if (ingredients.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There are no ingredients");
        } else {
            return ingredients;
        }
    }


}
