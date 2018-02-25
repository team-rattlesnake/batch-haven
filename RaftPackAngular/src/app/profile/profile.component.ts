import { Component, OnInit } from '@angular/core';
import { Profile } from '../profile';
import { ProfileService } from './../profile.service';
import { User } from '../models/User.model';
import { LoginComponent } from '../login/login.component';
import { Message } from '../model/message.model';
import { UploadFileService } from '../upload.service';
@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  show = false;
  profile: Profile;
  selectedFiles: FileList;
  user = this.user = {
    userId: 123, userEmail: 'mnguyen5081@gmail.com', userPassword: 'password',
    firstName: 'Mary', lastName: 'Nguyen', monthOfBirth: 'July', dayOfBirth: 21, yearOfBirth: 1993, gender: 'Female',
    profile: null, myPosts: null, friends: null, likedPosts: null
  };
  loginComponent: LoginComponent;
  constructor(private profileService: ProfileService, private uploadService: UploadFileService) {
  }

  public message: Message = new Message('No profile to display.');

  getProfile(): void {
    this.profileService.getProfile(this.user).subscribe(
      profile => this.profile = profile,
      error => this.message.text = `Couldn't find Hero.`);
  }

  ngOnInit(): void {
    this.getProfile();
  }

  upload() {
    const file = this.selectedFiles.item(0);
    this.uploadService.uploadfile(file);
  }

  selectFile(event) {
    this.selectedFiles = event.target.files;
  }

  showFiles(enable: boolean) {
    this.show = enable;

  }
}
