import { Component, OnInit } from '@angular/core';
import { NgModule } from '@angular/core';

import { LoginService } from '../services/login.service';

import { User } from '../models/user.model';
import { Message } from '../models/message.model';
import { Router } from '@angular/router';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public user: User = new User(0, '', '', '', '', '', '');

  constructor(private loginService: LoginService, private router: Router) {
  }

  public login(): void {
    this.getUserCredentials();
  }

  getUserCredentials(): void {
    this.loginService.login(this.user)
      .subscribe(
        user => this.user = user,
        error => console.log(`Error: ${error}`)
      );
    if (this.user.userId > 0) {
      console.log(this.user.user_email + ' \n ' + this.user.user_password);
      this.router.navigate(['./profile']);
    } else {
      console.log('Invalid credentials');
      this.router.navigate(['./register']);
    }
  }

  ngOnInit() {
  }

}
