import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Post } from 'src/app/models/post/post';

@Injectable({
  providedIn: 'root'
})
export class ForumService {

  readonly baseUrl: string = 'http://localhost:8082/forum/';

  constructor(
    private http: HttpClient
  ) { }

  getAllPosts(): Observable<IPost[]> {
    return this.http.get<IPost[]>(this.baseUrl + 'posts');
  }

  createPost(post: Post): Observable<IPost> {
    const headers1 = new HttpHeaders().set('Content-Type', 'application/json'); 
    let body = JSON.stringify(post);
    body = body.replace(/"_/g, '"');
    console.log(body);
    return this.http.post<IPost>(this.baseUrl + 'create/post', body, {headers: headers1})
  }

  deletePost(id: number): void {
    this.http.delete(this.baseUrl + 'delete/post/' + id).subscribe(() => console.log("Post successfully deleted."));
  }


}

interface IPost {
  id: number,
  title: string,
  name: string,
  comment: string
}
