import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Ingredient } from '../../classes/ingredient';
import { Recipe } from '../../models/recipe/recipe';
import { RecipeService } from '../../services/recipes/recipe.service';

@Component({
  selector: 'app-searcher',
  templateUrl: './searcher.component.html',
  styleUrls: ['./searcher.component.css']
})
export class SearcherComponent implements OnInit {

  recipes: Recipe[] = [];
  ingredients: Ingredient[] = [];

  selected: string = '';
  search: string = '';
  submitted: boolean = false;

  form: FormGroup;
  optionField: FormControl;
  searchField: FormControl;

  constructor(
    private recipeService: RecipeService
  ) { 
    this.optionField = new FormControl('', [Validators.required]);
    this.searchField = new FormControl('', [Validators.required]);

    this.form = new FormGroup({
      option: this.optionField,
      search: this.searchField
    })
  }

  ngOnInit(): void {
  }

  onSubmit(): void {
    this.submitted = false;
    this.recipes = [];
    if (this.selected === 'ingredient') {
      this.getRecipesByIngredient();
      this.submitted = true;
    } else if (this.selected === 'baked-good'){
      this.getRecipesByBakedGood();
      this.submitted = true;
    } else if (this.selected === 'flavour') {
      this.getRecipesByFlavour();
      this.submitted = true;
    } else {
      this.getRecipesByName();
      this.submitted = true;
    }
  }

  getRecipesByIngredient(): void {
    this.recipeService.getRecipeByIngredient(this.search).subscribe(dataResult => {
      for (let i = 0; i < dataResult.length; i++) {
        for (let j = 0; j < dataResult[i].ingredients.length; j++) {
          this.ingredients.push(new Ingredient(dataResult[i].ingredients[j].product, dataResult[i].ingredients[j].quantity));
        }
        this.recipes.push(new Recipe(dataResult[i].id, dataResult[i].flavour, dataResult[i].foodType, dataResult[i].prepTime, 
          this.ingredients, dataResult[i].name, dataResult[i].preparation, dataResult[i].photo));
        this.ingredients = [];
        console.log(this.recipes[i]);
      }
    });
  }

  getRecipesByBakedGood(): void {
    this.recipeService.getRecipeByBakedGood(this.search).subscribe(dataResult => {
      for (let i = 0; i < dataResult.length; i++) {
        for (let j = 0; j < dataResult[i].ingredients.length; j++) {
          this.ingredients.push(new Ingredient(dataResult[i].ingredients[j].product, dataResult[i].ingredients[j].quantity));
        }
        this.recipes.push(new Recipe(dataResult[i].id, dataResult[i].flavour, dataResult[i].foodType, dataResult[i].prepTime, 
          this.ingredients, dataResult[i].name, dataResult[i].preparation, dataResult[i].photo));
        this.ingredients = [];
      }
    });
  }

  getRecipesByFlavour(): void {
    this.recipeService.getRecipeByFlavour(this.search).subscribe(dataResult => {
      for (let i = 0; i < dataResult.length; i++) {
        for (let j = 0; j < dataResult[i].ingredients.length; j++) {
          this.ingredients.push(new Ingredient(dataResult[i].ingredients[j].product, dataResult[i].ingredients[j].quantity));
        }
        this.recipes.push(new Recipe(dataResult[i].id, dataResult[i].flavour, dataResult[i].foodType, dataResult[i].prepTime, 
          this.ingredients, dataResult[i].name, dataResult[i].preparation, dataResult[i].photo));
        this.ingredients = [];
      }
    });
  }

  getRecipesByName(): void {
    this.recipeService.getRecipeByName(this.search).subscribe(dataResult => {
      for (let j = 0; j < dataResult.ingredients.length; j++) {
        this.ingredients.push(new Ingredient(dataResult.ingredients[j].product, dataResult.ingredients[j].quantity));
      }
      this.recipes.push(new Recipe(dataResult.id, dataResult.flavour, dataResult.foodType, dataResult.prepTime, 
          this.ingredients, dataResult.name, dataResult.preparation, dataResult.photo));
        this.ingredients = [];
    });
  }
}
