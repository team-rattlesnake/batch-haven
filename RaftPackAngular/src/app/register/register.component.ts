import { Component, OnInit } from '@angular/core';
import { User } from '../models/user.model';
import { RegisterService } from '../services/register.service';
import { Message } from '../models/message.model';
import { Router } from '@angular/router';



@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  title = 'User Registration';

  constructor(private registerService: RegisterService, private router: Router) { }
  emailTyped: Boolean = false;
  passwordTyped: Boolean = false;
  // For data binding
  public user: User = new User(0, '', '', '', '', '', '');

  // To message the user
  public message: Message = new Message('');
  // For data binding
  // public user: User = new User(0, '', '', '', '', '', 0,
  // 0, '', null, null, null, null);

  registerUser(): void {
    this.registerService.registerUser(this.user).subscribe(
      message => this.message = message,
      error => console.log(`Error: ${error}`));
    if (this.message.text.length > 0) {
      this.router.navigate(['./login']);
    }
  }

  ngOnInit(): void {

  }

}
