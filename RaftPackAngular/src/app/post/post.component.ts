import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';
import { Post } from '../models/post.model';
import { ProfileService } from '../services/profile.service';
import { User } from '../models/user.model';
import { PostService } from '../services/post.service';
import { Message } from '../models/message.model';
import { UploadFileService } from '../services/upload.service';
import { FormdataUploadComponent } from './../form-data-upload/form-data-upload.component';
import { Socket } from 'ng-socket-io';
@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {
  public posts: Post[] = [];
  @Input() exists: boolean;
  post = new Post(0, '', null, 0, null, null);
  userId: number;
  url: string;
  selectedFiles: FileList;
  postImage: string;
  message: Message;
  user = new User(0, '', '', '', '', '', '', '', '');
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private userService: ProfileService,
    private postService: PostService,
    private uploadService: UploadFileService,
    ) { }

  ngOnInit() {
    this.getAllPosts(parseInt(document.cookie, 10));
    this.userService.getProfile(parseInt(document.cookie, 10)).subscribe(user => this.user = user);
  }

  createPost(postText: string, postImage: string) {
    if (postImage != null) {
      this.url = 'https://s3.amazonaws.com/jsa-angular-bucket/jsa-s3/' + postImage + '.png';
      this.post = { postId: 0, message: postText, image: this.url, numOfLikes: 0, user: this.user, date: null };
      this.postService.createPost(this.post).subscribe(message => {
        this.message = message; console.log(message);
      });
    } else { this.post = { postId: 0, message: postText, image: null, numOfLikes: 0, user: this.user, date: null };
    this.postService.createPost(this.post).subscribe(message => {
      this.message = message; console.log(message);
    });
   }
  }

  getAllPosts(userId: number): void {
    this.postService.getPosts(userId).subscribe(
      posts => {
        this.posts = posts; console.log(posts);
      });

  }



}
