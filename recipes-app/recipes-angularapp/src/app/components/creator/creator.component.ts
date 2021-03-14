import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Ingredient } from 'src/app/classes/ingredient';
import { Likes } from 'src/app/models/like/likes';
import { Recipe } from 'src/app/models/recipe/recipe';
import { LikesService } from 'src/app/services/likes/likes.service';
import { RecipeService } from 'src/app/services/recipes/recipe.service';

@Component({
  selector: 'app-creator',
  templateUrl: './creator.component.html',
  styleUrls: ['./creator.component.css']
})
export class CreatorComponent implements OnInit {

  form1: FormGroup;
  form2: FormGroup;

  name: string = '';
  flavour: string = '';
  bakedGood: string = '';
  prepTime: number = null;
  preparation: string = '';
  photo: string = '';
  numIngredients: number = null;
  quantity: string[] = [];
  product: string[] = [];
  ingCheck = false;
  recipe: Recipe;

  ingredients: Array<Ingredient> = new Array<Ingredient>(0);

  nameField: FormControl;
  prepTimeField: FormControl;
  flavourField: FormControl;
  bakedGoodField: FormControl;
  productField: FormControl;
  quantityField: FormControl;
  preparationField: FormControl;
  photoField: FormControl;
  numIngField: FormControl;

  constructor(
    private recipeService: RecipeService,
    private likesService: LikesService
  ) { 
    this.nameField = new FormControl('', [Validators.required]);
    this.prepTimeField = new FormControl('', [Validators.required]);
    this.flavourField = new FormControl('', [Validators.required]);
    this.bakedGoodField = new FormControl('', [Validators.required]);
    this.preparationField = new FormControl('', [Validators.required]);
    this.productField = new FormControl('', [Validators.required]);
    this.quantityField = new FormControl('', [Validators.required]);
    this.photoField = new FormControl('');
    this.numIngField = new FormControl('', [Validators.required]);


    this.form1 = new FormGroup({
      name: this.nameField,
      flavour: this.flavourField,
      bakedGood: this.bakedGoodField,
      prepTime: this.prepTimeField,
      preparation: this.preparationField,
      photo: this.photoField,
      numIngredients: this.numIngField
    });

    this.form2 = new FormGroup({
      product: this.productField,
      quantity: this.quantityField
    })
  }

  ngOnInit(): void {
  }


  onSubmit(): void {
    this.recipe = new Recipe(1, this.flavour, this.bakedGood, this.prepTime, this.ingredients, this.name, this.preparation, this.photo);
    this.recipeService.postRecipe(this.recipe).subscribe(dataResult => {
      console.log(dataResult);
    });
    let likes: Likes = new Likes(1, 0, 0);
    this.likesService.createLikes(likes).subscribe(result => {
        console.log(result);
    })
    this.ingCheck = false;
  }

  onSelect(): void {
    this.ingredients = new Array<Ingredient>((Number)(this.numIngredients));
    console.log(this.ingredients)
  }

  onClick(): void {
    for (let i = 0; i < this.ingredients.length; i++) {
      this.ingredients[i] = new Ingredient(this.product[i], this.quantity[i]);
    }
    this.ingCheck = true;
    console.log(this.ingredients)
  }

}
