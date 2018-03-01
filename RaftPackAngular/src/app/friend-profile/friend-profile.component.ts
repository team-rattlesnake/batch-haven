import { Message } from './../models/message.model';
import { Component, OnInit } from '@angular/core';
import { ProfileService } from '../services/profile.service';
import { User } from '../models/user.model';


@Component({
  selector: 'app-friend-profile',
  templateUrl: './friend-profile.component.html',
  styleUrls: ['./friend-profile.component.css']
})
export class FriendProfileComponent implements OnInit {
  
  user = new User(0, '', '', '', '', '', '', '', '');

  constructor(private profileService: ProfileService ) {
  }

  public message: Message = new Message('No profile to display.');

  getProfile() {
    this.profileService.getProfile(1).subscribe(
      user => {
        this.user = user;
        console.log(this.user);
        console.log(document.cookie = this.user.userId.valueOf().toString());
      },
      error => this.message.text = `Couldn't find Profile.`);
  }

  ngOnInit(): void {
    this.getProfile();
  }

}
