import { Component, OnInit, Input } from '@angular/core';
import { PostService } from '../services/post.service';
import { Message } from '../models/message.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-post-details',
  templateUrl: './post-details.component.html',
  styleUrls: ['./post-details.component.css']
})
export class PostDetailsComponent implements OnInit {

  @Input() postId: number;
  @Input() userId: number;
  message: Message;
  constructor(private postService: PostService, private router: Router) { }

  likePost() {
    console.log(this.postId, this.userId);
    this.postService.likePost(this.postId, this.userId).subscribe(message => {
      this.message.text = message; console.log(message);
        window.location.href = '/dashboard';
    });


  }

  ngOnInit() {
  }

}
