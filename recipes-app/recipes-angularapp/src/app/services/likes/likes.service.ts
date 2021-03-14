import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Likes } from 'src/app/models/like/likes';


@Injectable({
  providedIn: 'root'
})
export class LikesService {

  readonly baseUrl: string = 'http://localhost:8082/recipes/';

  constructor(
    private http: HttpClient
  ) { }

  getAllLikes(): Observable<Like[]> {
    return this.http.get<Like[]>(this.baseUrl + 'likes');
  }

  getLikesById(id: number): Observable<Like> {
    return this.http.get<Like>(this.baseUrl + 'likes/' + id);
  }

  createLikes(likes: Likes): Observable<Like> {
    const headers1 = new HttpHeaders().set('Content-Type', 'application/json'); 
    let body = JSON.stringify(likes);
    body = body.replace(/"_/g, '"');
    return this.http.post<Like>(this.baseUrl + 'post/likes', body, {headers: headers1});
  }

  updateLikes(likes: Likes): Observable<Like> {
    const headers1 = new HttpHeaders().set('Content-Type', 'application/json'); 
    let body = JSON.stringify(likes);
    body = body.replace(/"_/g, '"');
    console.log(body)
    console.log(this.baseUrl + 'update/likes/' + likes.id)
    return this.http.put<Like>(this.baseUrl + 'update/likes/' + likes.id, body, {headers: headers1});
  }

  deleteLikes(id: number): void {
    this.http.delete(this.baseUrl + 'delete/likes/' + id).subscribe(() => console.log('Likes deleted.'));
  }

  getPopularRecipe(): Observable<number> {
    return this.http.get<number>(this.baseUrl + 'popular');
  }

}

interface Like {
  id: number,
  likes: number,
  dislikes: number
}
