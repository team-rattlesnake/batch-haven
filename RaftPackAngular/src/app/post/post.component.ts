import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';
import { Post } from '../models/post.model';
import { ProfileService } from '../services/profile.service';
import { User } from '../models/user.model';
import { PostService } from '../services/post.service';
import { Message } from '../models/message.model';
@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {
  public posts: Post[] = [];
  post = new Post(0, '', null, 0, null);
  userId: number;
  message: Message;
  user = new User(0, '', '', '', '', '', '', '', '');
  constructor(private route: ActivatedRoute, private router: Router,
    private userService: ProfileService, private postService: PostService) {
  }

  ngOnInit() {
    this.getAllPosts(parseInt(document.cookie, 10));
    this.userService.getProfile(parseInt(document.cookie, 10)).subscribe(user => this.user = user);
  }

  createPost(postText: string) {

    this.post = { postId: 0, message: postText, image: null, numOfLikes: 0, user: this.user };
    this.postService.createPost(this.post).subscribe(message => {
      this.message = message; console.log(message);
    });
  }

  getAllPosts(userId: number): void {
    this.postService.getPosts(userId).subscribe(
      posts => {
        this.posts = posts; console.log(posts);
      });
  }



}
