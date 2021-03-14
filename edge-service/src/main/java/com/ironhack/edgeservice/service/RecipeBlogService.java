package com.ironhack.edgeservice.service;

import com.ironhack.edgeservice.client.ForumClient;
import com.ironhack.edgeservice.client.LikesClient;
import com.ironhack.edgeservice.client.RecipeClient;
import com.ironhack.edgeservice.dto.IngredientDTO;
import com.ironhack.edgeservice.dto.LikeDTO;
import com.ironhack.edgeservice.dto.PostDTO;
import com.ironhack.edgeservice.dto.RecipeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


import javax.validation.Valid;
import java.util.List;

@Service
public class RecipeBlogService {
    @Autowired
    private RecipeClient recipeClient;

    @Autowired
    private ForumClient forumClient;

    @Autowired
    private LikesClient likesClient;

    public List<RecipeDTO> showRecipes() {
        return recipeClient.getAllRecipes();
    }

    public List<IngredientDTO> showIngredients() {
        return recipeClient.getAllIngredients();
    }

    public RecipeDTO showRecipeById(Long id) {
        return recipeClient.getRecipeById(id);
    }

    public List<RecipeDTO> showRecipeByIngredient(String ingredient) {
        return recipeClient.getRecipeByIngredient(ingredient);
    }

    public List<RecipeDTO> showRecipeByBakedGood(String foodType) {
        return recipeClient.getRecipeByBakedGood(foodType);
    }

    public List<RecipeDTO> getRecipeByFlavour(String taste) {
        return recipeClient.getRecipeByFlavour(taste);
    }

    public RecipeDTO showRecipeByName(String name) {
        return recipeClient.getRecipeByName(name);
    }

    public RecipeDTO postRecipe(RecipeDTO recipeDTO) {
        return recipeClient.createRecipe(recipeDTO);
    }

    public void editRecipe(RecipeDTO recipeDTO) {
        recipeClient.updateRecipe(recipeDTO);
    }

    public void removeRecipe(Long id) {
        recipeClient.deleteRecipe(id);
    }

    public List<PostDTO> showPosts() {
        return forumClient.getAllPosts();
    }

    public PostDTO createPost(PostDTO postDTO) {
        return forumClient.createPost(postDTO);
    }

    public void removePost(Long id) {
        forumClient.deletePost(id);
    }

    public List<LikeDTO> getAllLikes() {
        return likesClient.getAllLikes();
    }

    public LikeDTO getLikesById(Long id) {
        return likesClient.getLikesById(id);
    }

    public Long getPopularRecipe() {
        return likesClient.getMostLikedRecipe();
    }

    public LikeDTO postLikes(LikeDTO likeDTO) {
        return likesClient.createLikes(likeDTO);
    }

    public LikeDTO editLikes(Long id, LikeDTO likeDTO) {
        return likesClient.updateLikes(id, likeDTO);
    }

    public void removeLikes(Long id) {
        likesClient.deleteLikes(id);
    }
}
