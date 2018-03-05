import { Component, OnInit, Input } from '@angular/core';
import { UserForm } from '../models/user-form';
import { ModifyUserService } from '../services/modify-user.service';
import { UploadFileService } from '../services/upload.service';
import { User } from '../models/user.model';
import { Message } from '../models/message.model';
import { ProfileService } from '../services/profile.service';
import {ProfileComponent} from '../profile/profile.component';
import { ActivatedRoute, Router } from '@angular/router';
import { FileUpload } from '../models/file-upload';
import { Observable } from 'rxjs/Observable';
@Component({
  selector: 'app-modify-user-info',
  templateUrl: './modify-user-info.component.html',
  styleUrls: ['./modify-user-info.component.css']

})
export class ModifyUserInfoComponent implements OnInit {
  @Input() exists: boolean;
  edit = false;
  message: Message;
  profileImageSession: any;
  show = false;
  selectedFiles: FileList;
  @Input() fileUpload: FileUpload;
  fileUploads: Observable<Array<FileUpload>>;
  user = new User(0, '', '', '', '', '', '', '', document.cookie);
  imageString: string;
  constructor(
    private profileService: ProfileService,
    private uploadService: UploadFileService,
    private route: ActivatedRoute,
    private modifyUserService: ModifyUserService,
    private router: Router) { }
  ngOnInit() {
    this.profileService.getProfile(parseInt(document.cookie, 10)).subscribe(user => this.user = user);
  }
  getUserFormData() {
    if (this.edit === false) { this.edit = true; }
    if (this.edit === true) { this.edit = false; }

    this.user.userId = parseInt(document.cookie, 10);
    this.modifyUserService.update(this.user).subscribe(
      user => this.user = user);
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


  upload() {
    const file = this.selectedFiles.item(0);
    this.uploadService.uploadfile(file).subscribe(profile_image => this.user.profile_image = profile_image);
    console.log(this.user);
    this.imageString = 'https://s3.amazonaws.com/jsa-angular-bucket/jsa-s3/' + this.user.profile_image + '.png';
    this.user.profile_image = this.imageString;
    this.modifyUserService.update(this.user).subscribe(user => this.user = user);
  }

  selectFile(event) {
    this.selectedFiles = event.target.files;
  }

}
