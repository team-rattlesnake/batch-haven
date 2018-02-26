import { Component, OnInit, Input } from '@angular/core';
import { UserForm } from '../models/user-form';
import { User } from '../models/user.model';

@Component({
  selector: 'app-modify-user-info',
  templateUrl: './modify-user-info.component.html',
  styleUrls: ['./modify-user-info.component.css']

})
export class ModifyUserInfoComponent implements OnInit {
  userform: UserForm;
  user: User;

  constructor() {

  }

  ngOnInit() {

  }

  getUserFormData(firstname, lastname, company, pack, email, username, password, confirmation) {
    this.userform = {
      firstname: firstname, lastname: lastname, company: company,
      pack: pack, email: email, username: username, password: password, pass_confirm: confirmation
    };
    /* need to combine these somehow... */
    this.user = new User(0, firstname, lastname, email, password, 'female', '07/21/1993');

    console.log(this.userform.firstname, this.userform.lastname, this.userform.company,
      this.userform.pack, this.userform.email, this.userform.username, this.userform.password,
      this.userform.pass_confirm);
  }

}


