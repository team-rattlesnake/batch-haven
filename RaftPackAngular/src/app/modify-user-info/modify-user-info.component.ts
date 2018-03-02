import { Component, OnInit, Input } from '@angular/core';
import { UserForm } from '../models/user-form';
import { ModifyUserService } from '../services/modify-user.service';
import { UploadFileService } from '../services/upload.service';
import { User } from '../models/user.model';
import { Message } from '../models/message.model';
import { ProfileService } from '../services/profile.service';
import {ProfileComponent} from '../profile/profile.component';
@Component({
  selector: 'app-modify-user-info',
  templateUrl: './modify-user-info.component.html',
  styleUrls: ['./modify-user-info.component.css']

})
export class ModifyUserInfoComponent implements OnInit {
  user: User;
  edit = false;
  message: Message;
  profileImageSession: any;

  constructor(private profileService: ProfileService,
    private modifyuserinfoService: ModifyUserService, private uploadfileservice: UploadFileService) { }

  ngOnInit() {
    this.profileService.getProfile(parseInt(document.cookie, 10)).subscribe(user => this.user = user);
  }
  getUserFormData() {
    if (this.edit === false) { this.edit = true; }
    if (this.edit === true) { this.edit = false; }

    this.user.userId = parseInt(document.cookie, 10);
    this.modifyuserinfoService.update(this.user).subscribe(
      user => this.user = user);
  }

}
