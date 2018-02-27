import { Component, OnInit, Input } from '@angular/core';
import { UserForm } from '../models/user-form';
import { ModifyUserService} from '../services/modify-user.service';
import { UploadFileService } from '../services/upload.service';

@Component({
  selector: 'app-modify-user-info',
  templateUrl: './modify-user-info.component.html',
  styleUrls: ['./modify-user-info.component.css']

})
export class ModifyUserInfoComponent implements OnInit {
  userform: UserForm;
  userformRet: UserForm;
  message : String = "";
  profileImageSession: any;
  userId: Number = 0;

  constructor(private modifyuserinfoService : ModifyUserService, private uploadfileservice: UploadFileService) {}

  ngOnInit() {

  }
  getUserFormData(profilepic,firstname, lastname, useremail, gender, biography) {
//Since I have only tomight to work on this - I will not go into trying to find the means fo 
// getting the session User Id. I assume that the id is needed. 
    this.userform = {
      userId: this.userId, profileImage: profilepic,firstname: firstname, lastname: lastname, useremail: useremail,
      gender: gender, biography: biography};
      //This holds the image for fileupload - server side unknown
      
      
    
    this.modifyuserinfoService.modifyuserinfoGo(this.userform).subscribe(
               message => this.userformRet = message,
               error => this.message = 'An error has occured...');
  
    // Here I will have another function of uploadfileservice ready for the image
    // The goal for the image is to show the image when modified and save the image
    // session wide. In addition, the image is sent to be persisted Spring side.
  }

}