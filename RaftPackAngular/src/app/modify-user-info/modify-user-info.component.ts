import { Component, OnInit, Input } from '@angular/core';
import { UserForm } from '../user-form';

@Component({
  selector: 'app-modify-user-info',
  templateUrl: './modify-user-info.component.html',
  styleUrls: ['./modify-user-info.component.css']

})
export class ModifyUserInfoComponent implements OnInit {
  userform: UserForm;

  constructor() {

  }

  ngOnInit() {

  }
  getUserFormData(firstname, lastname, company, pack, email, username, password, confirmation) {
    this.userform = {
      firstname: firstname, lastname: lastname, company: company,
      pack: pack, email: email, username: username, password: password, pass_confirm: confirmation
    };

    console.log(this.userform.firstname, this.userform.lastname, this.userform.company,
      this.userform.pack, this.userform.email, this.userform.username, this.userform.password,
      this.userform.pass_confirm);
  }

}


