import { Component, OnInit } from '@angular/core';
import { Post } from '../post';
import { PostService } from '../post.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-post-detail',
  templateUrl: './post-detail.component.html',
  styleUrls: ['./post-detail.component.css']
})
export class PostDetailComponent implements OnInit {

  current: Post;

  constructor(
    private postService: PostService,
    private route: ActivatedRoute
  ) { }

  ngOnInit() {
  }

  getCurrent(): Post {
    return this.current;
  }

  setCurrent(id: number, message: string, imageUrl: string, likesAmount: number): void {
    this.current.id = id;
    this.current.message = message;
    this.current.imageUrl = imageUrl;
    this.current.likesAmount = likesAmount;
  }

  create(post: Post) {

  }

  delete(post: Post) {

  }

  like(post: Post) {

  }

  unlike(post: Post) {

  }

}
