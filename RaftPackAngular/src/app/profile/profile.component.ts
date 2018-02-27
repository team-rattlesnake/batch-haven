import { Component, OnInit } from '@angular/core';
import { ProfileService } from '../services/profile.service';
import { User } from '../models/user.model';
import { LoginComponent } from '../login/login.component';
import { Message } from '../models/message.model';
import { UploadFileService } from '../services/upload.service';
@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  show = false;
  selectedFiles: FileList;
  user = new User(0, '', '', '', '', '', '', '', '');
  // loginComponent: LoginComponent;
  constructor(private profileService: ProfileService, private uploadService: UploadFileService) {
  }

  public message: Message = new Message('No profile to display.');

  getProfile() {
    this.profileService.getProfile(parseInt(document.cookie, 10)).subscribe(
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
