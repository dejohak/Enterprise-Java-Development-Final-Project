import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Recipe } from 'src/app/models/recipe/recipe';

@Injectable({
  providedIn: 'root'
})
export class RecipeService {

  readonly baseUrl: string = 'http://localhost:8082/recipes/';

  constructor(
    private httpClient: HttpClient
  ) { }

  getRecipes(): Observable<IRecipe[]> {
    return this.httpClient.get<IRecipe[]>(this.baseUrl);
  }

  getIngredients(): Observable<Ingredient[]> {
    return this.httpClient.get<Ingredient[]>(this.baseUrl + 'ingredients')
  }

  getRecipeById(id: number): Observable<IRecipe> {
    return this.httpClient.get<IRecipe>(this.baseUrl + id);
  }

  getRecipeByIngredient(ingredient: string): Observable<IRecipe[]> {
    return this.httpClient.get<IRecipe[]>(this.baseUrl + 'ingredient/' + ingredient);
  }

  getRecipeByBakedGood(bakedGood: string): Observable<IRecipe[]> {
    return this.httpClient.get<IRecipe[]>(this.baseUrl + "food/" + bakedGood);
  }

  getRecipeByFlavour(flavour: string): Observable<IRecipe[]> {
    return this.httpClient.get<IRecipe[]>(this.baseUrl + 'flavour/' + flavour);
  }

  getRecipeByName(name: string): Observable<IRecipe> {
    return this.httpClient.get<IRecipe>(this.baseUrl + 'name/' + name);
  }

  postRecipe(recipe: Recipe): Observable<IRecipe> {
    const headers1 = new HttpHeaders().set('Content-Type', 'application/json'); 
    let body = JSON.stringify(recipe);
    body = body.replace(/"_/g, '"');
    return this.httpClient.post<Recipe>(this.baseUrl, body, {headers: headers1});
  }

  updateRecipe(recipe: Recipe): void {
    let body = JSON.stringify(recipe);
    body = body.replace(/"_/g, '"');
    this.httpClient.put(this.baseUrl, body);
  }

  deleteRecipe(id: number) {
    this.httpClient.delete(this.baseUrl + id).subscribe(() => console.log("Recipe successfully deleted."));
  }


}

interface IRecipe {
  id: number,
  name: string,
  flavour: string,
  foodType: string,
  prepTime: number,
  ingredients: Ingredient[],
  preparation: string,
  photo: string
}

interface Ingredient {
  product: string,
  quantity: string
}


