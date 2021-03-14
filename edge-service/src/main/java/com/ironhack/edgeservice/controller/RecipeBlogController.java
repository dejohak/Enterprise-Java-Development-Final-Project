package com.ironhack.edgeservice.controller;

import com.ironhack.edgeservice.dto.IngredientDTO;
import com.ironhack.edgeservice.dto.LikeDTO;
import com.ironhack.edgeservice.dto.PostDTO;
import com.ironhack.edgeservice.dto.RecipeDTO;
import com.ironhack.edgeservice.service.RecipeBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RecipeBlogController {

    @Autowired
    private RecipeBlogService service;

    // Recipe controller

    @RequestMapping(value = "/recipes/", method = RequestMethod.GET)
    public List<RecipeDTO> showRecipes() {
        return service.showRecipes();
    }

    @RequestMapping(value = "/recipes/ingredients", method = RequestMethod.GET)
    public List<IngredientDTO> showIngredients() {
        return service.showIngredients();
    }

    @RequestMapping(value = "/recipes/{id}", method = RequestMethod.GET)
    public RecipeDTO showRecipeById(@PathVariable("id") Long id) {
        return service.showRecipeById(id);
    }

    @RequestMapping(value = "/recipes/ingredient/{ingredient}", method = RequestMethod.GET)
    public List<RecipeDTO> showRecipeByIngredient(@PathVariable("ingredient") String ingredient) {
        return service.showRecipeByIngredient(ingredient);
    }

    @RequestMapping(value = "/recipes/food/{bakedGood}", method = RequestMethod.GET)
    public List<RecipeDTO> showRecipeByBakedGood(@PathVariable("bakedGood") String foodType) {
        return service.showRecipeByBakedGood(foodType);
    }

    @RequestMapping(value = "/recipes/flavour/{flavour}", method = RequestMethod.GET)
    public List<RecipeDTO> getRecipeByFlavour(@PathVariable("flavour") String taste) {
        return service.getRecipeByFlavour(taste);
    }

    @RequestMapping(value = "/recipes/name/{name}", method = RequestMethod.GET)
    public RecipeDTO getRecipeByName(@PathVariable("name") String name) {
        return service.showRecipeByName(name);
    }

    @RequestMapping(value = "/recipes/", method = RequestMethod.POST)
    public RecipeDTO postRecipe(@RequestBody @Valid RecipeDTO recipeDTO) {
        return service.postRecipe(recipeDTO);
    }

    @RequestMapping(value = "/recipes/", method = RequestMethod.PUT)
    public void editRecipe(@RequestBody @Valid RecipeDTO recipeDTO) {
        service.editRecipe(recipeDTO);
    }

    @RequestMapping(value = "/recipes/{id}", method = RequestMethod.DELETE)
    public void removeRecipe(@PathVariable("id") Long id) {
        service.removeRecipe(id);
    }

    // Forum controller

    @RequestMapping(value = "/forum/posts", method = RequestMethod.GET)
    public List<PostDTO> showPosts() {
        return service.showPosts();
    }

    @RequestMapping(value = "/forum/create/post", method = RequestMethod.POST)
    public PostDTO postPost(@RequestBody @Valid PostDTO postDTO) {
        return service.createPost(postDTO);
    }

    @RequestMapping(value = "/forum/delete/post/{id}", method = RequestMethod.DELETE)
    public void removePost(@PathVariable("id") Long id) {
        service.removePost(id);
    }

    // Likes controller

    @RequestMapping(value = "/recipes/likes", method = RequestMethod.GET)
    public List<LikeDTO> getAllLikes() {
        return service.getAllLikes();
    }

    @RequestMapping(value = "/recipes/likes/{id}", method = RequestMethod.GET)
    public LikeDTO getLikesById(@PathVariable("id") Long id) {
        return service.getLikesById(id);
    }

    @RequestMapping(value = "/recipes/popular", method = RequestMethod.GET)
    public Long getMostLikedRecipe() {
        return service.getPopularRecipe();
    }

    @RequestMapping(value = "/recipes/post/likes", method = RequestMethod.POST)
    public LikeDTO createLikes(@RequestBody @Valid LikeDTO likeDTO) {
        return service.postLikes(likeDTO);
    }

    @RequestMapping(value = "/recipes/update/likes/{id}", method = RequestMethod.PUT)
    public LikeDTO updateLikes(@PathVariable("id") Long id, @RequestBody @Valid LikeDTO likeDTO) {
        return service.editLikes(id, likeDTO);
    }

    @RequestMapping(value = "/recipes/delete/likes/{id}", method = RequestMethod.DELETE)
    public void deleteLikes(@PathVariable("id") Long id) {
        service.removeLikes(id);
    }
}
