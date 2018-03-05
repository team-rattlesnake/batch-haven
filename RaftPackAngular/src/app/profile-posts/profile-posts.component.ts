import { Component, OnInit } from '@angular/core';
import { ProfileService } from '../services/profile.service';
import { PostService } from '../services/post.service';
import { Post } from '../models/post.model';
import { User } from '../models/user.model';
import { UploadFileService } from '../services/upload.service';
import { ActivatedRoute, Router } from '@angular/router';
import { ModifyUserService } from '../services/modify-user.service';
import { Message } from '../models/message.model';

@Component({
  selector: 'app-profile-posts',
  templateUrl: './profile-posts.component.html',
  styleUrls: ['./profile-posts.component.css']
})
export class ProfilePostsComponent implements OnInit {
  public posts: Post[] = [];
  user = new User(0, '', '', '', '', '', '', '', '');
  constructor(private userService: ProfileService,
    private postService: PostService,
    private profileService: ProfileService,
    private uploadService: UploadFileService,
    private route: ActivatedRoute,
    private modifyUserService: ModifyUserService,
    private router: Router) { }
    public message: Message = new Message('No profile to display.');
  ngOnInit() {
    this.getAllPosts(parseInt(document.cookie, 10));
    this.getProfile();
    // this.userService.getProfile(parseInt(document.cookie, 10)).subscribe(user => this.user = user);
  }
  getProfile() {
    const id = +this.route.snapshot.paramMap.get('id');
    if (id) {
      this.profileService.getProfile(id).subscribe(
        user => this.user = user,
        error => this.message.text = `Couldn't find Profile.`
      );
    } else {
      this.profileService.getProfile(parseInt(document.cookie, 10)).subscribe(
        user => {
          this.user = user;
          console.log(this.user);
          console.log(document.cookie = this.user.userId.valueOf().toString());
        },
        error => this.message.text = `Couldn't find Profile.`);
    }
  }


  getAllPosts(userId: number): void {
    this.postService.getPosts(userId).subscribe(
      posts => {
        this.posts = posts; console.log(posts);
      });

  }
}
