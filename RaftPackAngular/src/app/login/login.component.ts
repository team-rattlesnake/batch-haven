import { Component, OnInit } from '@angular/core';
import { NgModule } from '@angular/core';

import { LoginService } from './login.service';

import { User } from '../models/User.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public user: User = new User(0, '', '', '', '', '', 0,
                               0, '', null, null, null, null);
  private enteredPassword: string;

  constructor(private loginService: LoginService) {
  }

  public login(): void {
    this.getUserCredentials();
  }

  getUserCredentials(): void {
    if (this.user.userEmail.length > 0 && this.user.userPassword.length > 0) {
      this.enteredPassword = this.user.userPassword;
      this.loginService.fetchUserInformation(this.user.userEmail)
        .subscribe(
          user => this.user = user,
          error => console.log(`Error: ${error}`)
        );
      if (this.enteredPassword === this.user.userPassword) {
        console.log(this.user.userEmail + ' \n ' + this.user.userPassword);
      } else {
        console.log('Invalid credentials');
      }
    } else {
      console.log('The field(s) are missing input.');
    }
  }

  ngOnInit() {
  }

}
