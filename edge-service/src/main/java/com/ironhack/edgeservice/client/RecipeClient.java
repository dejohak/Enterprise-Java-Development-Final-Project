package com.ironhack.edgeservice.client;

import com.ironhack.edgeservice.dto.IngredientDTO;
import com.ironhack.edgeservice.dto.RecipeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@FeignClient("recipe-service")
public interface RecipeClient {
    @RequestMapping(value = "/recipes/", method = RequestMethod.GET)
    public List<RecipeDTO> getAllRecipes();

    @RequestMapping(value = "/recipes/ingredients", method = RequestMethod.GET)
    public List<IngredientDTO> getAllIngredients();

    @RequestMapping(value = "/recipes/{id}", method = RequestMethod.GET)
    public RecipeDTO getRecipeById(@PathVariable("id") Long id);

    @RequestMapping(value = "/recipes/ingredient/{ingredient}", method = RequestMethod.GET)
    public List<RecipeDTO> getRecipeByIngredient(@PathVariable("ingredient") String ingredient);

    @RequestMapping(value = "/recipes/food/{bakedGood}", method = RequestMethod.GET)
    public List<RecipeDTO> getRecipeByBakedGood(@PathVariable("bakedGood") String foodType);

    @RequestMapping(value = "/recipes/flavour/{flavour}", method = RequestMethod.GET)
    public List<RecipeDTO> getRecipeByFlavour(@PathVariable("flavour") String taste);

    @RequestMapping(value = "/recipes/name/{name}", method = RequestMethod.GET)
    public RecipeDTO getRecipeByName(@PathVariable("name") String name);

    @RequestMapping(value = "/recipes/", method = RequestMethod.POST)
    public RecipeDTO createRecipe(@RequestBody @Valid RecipeDTO recipeDTO);

    @RequestMapping(value = "/recipes/", method = RequestMethod.PUT)
    public void updateRecipe(@RequestBody @Valid RecipeDTO recipeDTO);

    @RequestMapping(value = "/recipes/{id}", method = RequestMethod.DELETE)
    public void deleteRecipe(@PathVariable("id") Long id);
}
