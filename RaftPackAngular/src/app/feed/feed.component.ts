import { Component, OnInit } from '@angular/core';
import { PostService } from './../services/post.service';
import { Observable } from 'rxjs/Observable';
import { Post } from '../models/post.model';

@Component({
  selector: 'app-feed',
  templateUrl: './feed.component.html',
  styleUrls: ['./feed.component.css']
})
export class FeedComponent implements OnInit {
  public posts: Post[] = [];
  constructor(private postService: PostService) { }
  viewFeed(): void {
    this.postService.getAllPosts().subscribe(posts => this.posts = posts);
  }
  ngOnInit() {
    this.viewFeed();
  }

}
