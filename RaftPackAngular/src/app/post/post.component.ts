import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';
import { Post } from '../models/post.model';
import { Profile } from '../models/profile.model';
import { ProfileService } from '../services/profile.service';
import { User } from '../models/user.model';
import { PostService } from '../services/post.service';
@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {
  public posts: Post[] = [];
  userId: number;

  constructor(private route: ActivatedRoute, private router: Router, private postService: PostService) {
    this.route.params.subscribe(res => {
      this.userId = res.id;
    console.log(res.id);
  });
}

  ngOnInit() {
    this.getAllPosts(this.userId);
  }

  getAllPosts(profileId: number): void {
    this.postService.getPosts(this.userId).subscribe(
      posts => this.posts = posts);
  }



}
