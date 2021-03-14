import { Component, OnInit } from '@angular/core';
import { RecipeService } from '../../services/recipes/recipe.service';
import { Recipe } from '../../models/recipe/recipe';
import { Ingredient } from '../../classes/ingredient';
import { LikesService } from '../../services/likes/likes.service';
import { Likes } from '../../models/like/likes';


@Component({
  selector: 'app-recipes',
  templateUrl: './recipes.component.html',
  styleUrls: ['./recipes.component.css']
})
export class RecipesComponent implements OnInit {

  recipes: Recipe[] = [];
  ingredients: Ingredient[] = [];
  likes: Likes[] = [];
  popularRecipe: Recipe = new Recipe(0, '', '', 0, this.ingredients, '', '', '');
  popularId: number = 0;

  likesCheck: boolean[] = [];
  dislikesCheck: boolean[] = [];
  mostLiked: number = -1;
  mostLikes: number = 0;
  
  p = 1;


  constructor(
    private recipeService: RecipeService,
    private likesService: LikesService
  ) {}

  ngOnInit(): void {
    this.getAllRecipes();
    this.getLikes();   
    this.getMostLikedRecipeId();
    this.getPopularRecipe(); 
  }

  getAllRecipes(): void {
    this.recipeService.getRecipes().subscribe(dataResult => {
      for (let i = 0; i < dataResult.length; i++) {
        for (let j = 0; j < dataResult[i].ingredients.length; j++) {
          this.ingredients.push(new Ingredient(dataResult[i].ingredients[j].product, dataResult[i].ingredients[j].quantity));
        }
      
        this.recipes.push(new Recipe(dataResult[i].id, dataResult[i].flavour, dataResult[i].foodType, dataResult[i].prepTime, this.ingredients, dataResult[i].name, 
          dataResult[i].preparation, dataResult[i].photo));
        this.ingredients = [];
      }  
        
    });
  }

  getIngredients(): void {
    this.recipeService.getIngredients().subscribe(dataResult => {
      dataResult.forEach(ingredient => this.ingredients.push(new Ingredient(ingredient.product, ingredient.quantity)));
    });
  }

  getLikes(): void {
    this.likesService.getAllLikes().subscribe(dataResult => {
      dataResult.forEach(like => this.likes.push(new Likes(like.id, like.likes, like.dislikes)));
    });
    for (let i = 0; i < this.likes.length; i++) {
      if (this.likes[i].likes > this.mostLikes) {
        this.mostLiked = this.likes[i].id;
        this.mostLikes = this.likes[i].likes;
        this.popularRecipe[0] = new Recipe(this.recipes[i].id, this.recipes[i].flavour, this.recipes[i].foodType, 
          this.recipes[i].prepTime, this.recipes[i].ingredients, this.recipes[i].name, this.recipes[i].preparation, this.recipes[i].photo);
      }
    }
  }

  onClickLike(i: number): void {
    if (this.likesCheck[i]) {
      this.likes[i].likes -= 1;
      this.likesCheck[i] = false;
    } else {
      this.likes[i].likes += 1;
      this.likesCheck[i] = true;
      if (this.dislikesCheck[i]) {
        this.onClickDislike(i);
      }
    }
    this.likesService.updateLikes(this.likes[i]).subscribe(dataResult => {
      console.log(dataResult);
    });
    this.updatePopularRecipe();
  }

  onClickDislike(i: number): void {
    if (this.dislikesCheck[i]) {
      this.likes[i].dislikes -= 1;
      this.dislikesCheck[i] = false;
    } else {
      this.likes[i].dislikes += 1;
      this.dislikesCheck[i] = true;
      if (this.likesCheck[i]) {
        this.onClickLike(i);
      }
    }
    this.likesService.updateLikes(this.likes[i]).subscribe(dataResult => {
      console.log(dataResult);
    });
    this.updatePopularRecipe();
  }

  updatePopularRecipe(): void {
    for (let i = 0; i < this.likes.length; i++) {
      if (this.likes[i].likes > this.mostLikes) {
        this.mostLiked = this.likes[i].id;
        this.mostLikes = this.likes[i].likes;
        this.popularRecipe = new Recipe(this.recipes[i].id, this.recipes[i].flavour, this.recipes[i].foodType, 
          this.recipes[i].prepTime, this.recipes[i].ingredients, this.recipes[i].name, this.recipes[i].preparation, this.recipes[i].photo);
      }
    }
  }

  getMostLikedRecipeId(): void {
    this.likesService.getPopularRecipe().subscribe(dataResult => {
      this.popularId = dataResult;
    });
  }

  getPopularRecipe(): void {
    this.recipeService.getRecipeById(this.popularId+1).subscribe(dataResult => {
      this.popularRecipe.id = dataResult.id;
      this.popularRecipe.flavour = dataResult.flavour;
        this.popularRecipe.foodType = dataResult.foodType;
        this.popularRecipe.name = dataResult.name;
        for (let j = 0; j < dataResult.ingredients.length; j++) {
          this.ingredients.push(new Ingredient(dataResult.ingredients[j].product, dataResult.ingredients[j].quantity));
        }
        this.popularRecipe.ingredients = this.ingredients;
        this.popularRecipe.prepTime = dataResult.prepTime;
        this.popularRecipe.preparation = dataResult.preparation;
        this.popularRecipe.photo = dataResult.photo;
        this.ingredients = []; 
    });
  }
}
