import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Post } from '../../models/post/post';
import { ForumService } from '../../services/forum/forum.service';
import { LikesService } from '../../services/likes/likes.service';
import { Likes } from '../../models/like/likes';



@Component({
  selector: 'app-forum',
  templateUrl: './forum.component.html',
  styleUrls: ['./forum.component.css']
})
export class ForumComponent implements OnInit {


  name: string = '';
  title: string = '';
  comment: string = '';
  date: Date = new Date();

  form: FormGroup;
  nameField: FormControl;
  titleField: FormControl;
  commentField: FormControl;

  posts: Post[] = [];

  p = 1;


  constructor(
    private forumService: ForumService,
  ) { 
    this.titleField = new FormControl('', [Validators.required])
    this.nameField = new FormControl('', [Validators.required, Validators.minLength(4)]);
    this.commentField = new FormControl('', [Validators.required, Validators.minLength(6)]);

    this.form = new FormGroup({
      title: this.titleField,
      name: this.nameField,
      comment: this.commentField
    });
  }

  ngOnInit(): void {
    this.getAllPosts();
  }

  getAllPosts(): void {
    this.forumService.getAllPosts().subscribe(dataResult => {
      dataResult.forEach(post => this.posts.push(new Post(post.id, post.title, post.name, post.comment)));
    });
  }

  createPost(newPost: Post): void {
    this.forumService.createPost(newPost).subscribe(dataResult => {
      this.posts.push(new Post(dataResult.id, dataResult.title, dataResult.name, dataResult.comment));
    });
  }

  deletePost(id: number): void {
    this.forumService.deletePost(id);
  }

  onSubmit(): void {
    let post: Post = new Post(this.posts.length+1, this.title, this.name, this.comment);
    this.posts.push(post);
    this.forumService.createPost(post).subscribe(dataResult => {
      console.log('Post ' + post.title + ' added.')
    });
  }


}
