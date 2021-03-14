package com.ironhack.recipesservice.repository;

import com.ironhack.recipesservice.enums.FoodType;
import com.ironhack.recipesservice.model.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecipeRepository extends MongoRepository<Recipe, Long> {
     Optional<Recipe> findByFoodType(FoodType foodType);
     Optional<Recipe> findByName(String name);
}
