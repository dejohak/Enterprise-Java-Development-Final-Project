import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ForumComponent } from './components/forum/forum.component';
import { HomeComponent } from './home/home.component';
import { RecipesComponent } from './components/recipes/recipes.component';
import { SearcherComponent } from './components/searcher/searcher.component';
import { CreatorComponent } from './components/creator/creator.component';

const routes: Routes = [
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'recipes',
    component: RecipesComponent
  },
  {
    path: 'searcher',
    component: SearcherComponent
  },
  {
    path: 'forum',
    component: ForumComponent
  },
  {
    path: 'creator',
    component: CreatorComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
