import { Component, OnInit, Input } from '@angular/core';
import { UserForm } from '../user-form';
import { ModifyUserInfoService} from '../modify-user-info.service';

@Component({
  selector: 'app-modify-user-info',
  templateUrl: './modify-user-info.component.html',
  styleUrls: ['./modify-user-info.component.css']

})
export class ModifyUserInfoComponent implements OnInit {
  userform: UserForm;
  userformRet: UserForm;
  message : String = "";

  constructor(private modifyuserinfoService : ModifyUserInfoService) {}

  ngOnInit() {

  }
  getUserFormData(profilepic,firstname, lastname, useremail, pack, gender, biography) {
    this.userform = {
      profilepic: profilepic,firstname: firstname, lastname: lastname, useremail: useremail,
      pack: pack, gender: gender, biography: biography};
    
    this.modifyuserinfoService.modifyuserinfoGo(this.userform).subscribe(
               message => this.userformRet = message,
               error => this.message = 'An error has occured...');
      
  }
}
