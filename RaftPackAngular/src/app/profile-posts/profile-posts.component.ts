import { Component, OnInit } from '@angular/core';
import { ProfileService } from '../services/profile.service';
import { PostService } from '../services/post.service';
import { Post } from '../models/post.model';
import { User } from '../models/user.model';

@Component({
  selector: 'app-profile-posts',
  templateUrl: './profile-posts.component.html',
  styleUrls: ['./profile-posts.component.css']
})
export class ProfilePostsComponent implements OnInit {
  public posts: Post[] = [];
  user = new User(0, '', '', '', '', '', '', '', '');
  constructor(private userService: ProfileService, private postService: PostService) { }

  ngOnInit() {
    this.getAllPosts(parseInt(document.cookie, 10));
    this.userService.getProfile(parseInt(document.cookie, 10)).subscribe(user => this.user = user);
  }

  getAllPosts(userId: number): void {
    this.postService.getPosts(userId).subscribe(
      posts => {
        this.posts = posts; console.log(posts);
      });

  }
}
