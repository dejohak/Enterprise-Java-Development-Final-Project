package com.ironhack.recipesservice.controller.impl;

import com.ironhack.recipesservice.controller.interfaces.IRecipeController;
import com.ironhack.recipesservice.dto.IngredientDTO;
import com.ironhack.recipesservice.dto.RecipeDTO;
import com.ironhack.recipesservice.service.interfaces.IRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/recipes")
@CrossOrigin(origins = "http://localhost:4200")
public class RecipeController implements IRecipeController {

    @Autowired
    private IRecipeService recipeService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<RecipeDTO> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @RequestMapping(value = "/ingredients", method = RequestMethod.GET)
    public List<IngredientDTO> getAllIngredients() {
        return recipeService.getIngredients();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public RecipeDTO getRecipeById(@PathVariable("id") Long id) {
        return recipeService.getRecipeById(id);
    }

    @RequestMapping(value = "/ingredient/{ingredient}", method = RequestMethod.GET)
    public List<RecipeDTO> getRecipeByIngredient(@PathVariable("ingredient") String ingredient) {
        return recipeService.getRecipeByIngredient(ingredient);
    }

    @RequestMapping(value = "/food/{bakedGood}", method = RequestMethod.GET)
    public List<RecipeDTO> getRecipeByBakedGood(@PathVariable("bakedGood") String foodType) {
        return recipeService.getRecipeByFoodType(foodType);
    }

    @RequestMapping(value = "/flavour/{flavour}", method = RequestMethod.GET)
    public List<RecipeDTO> getRecipeByFlavour(@PathVariable("flavour") String taste) {
        return recipeService.getRecipeByFlavour(taste);
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public RecipeDTO getRecipeByName(@PathVariable("name") String name) {
        return recipeService.getRecipeByName(name);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public RecipeDTO createRecipe(@RequestBody @Valid RecipeDTO recipeDTO) {
        return recipeService.postRecipe(recipeDTO);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public void updateRecipe(@RequestBody @Valid RecipeDTO recipeDTO) {
        recipeService.changeRecipe(recipeDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteRecipe(@PathVariable("id") Long id) {
        recipeService.deleteRecipe(id);
    }


}
