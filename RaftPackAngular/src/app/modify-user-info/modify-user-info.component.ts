import { Component, OnInit, Input } from '@angular/core';
import {UserForm} from '../user-form';

@Component({
  selector: 'app-modify-user-info',
  templateUrl: './modify-user-info.component.html',
  styleUrls: ['./modify-user-info.component.css']
 
})
export class ModifyUserInfoComponent implements OnInit {
  userform : UserForm;

  constructor()
   { 
  
  }

  ngOnInit() {
    
  }
  getUserFormData(firstname,lastname,company,email,username,password,confirmation){
    this.userform = {firstname : firstname,lastname : lastname, company : company,
    email : email, username : username,password : password, pass_confirm : confirmation};
    console.log(this.userform.firstname, this.userform.password);
   }
  //  hero: Hero = {
  //   id: 1,
  //   name: 'Windstorm'
  // };

  }


