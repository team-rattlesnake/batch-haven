import { Component, OnInit } from '@angular/core';
import { User } from '../model/user/user.model';
import { RegisterService } from '../service/register.service';
import { Message } from '../model/message.model';



@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  title = 'User Registration';

  constructor(private registerService: RegisterService) { }
  emailTyped: Boolean = false;

  passwordTyped: Boolean = false;
  // For data binding
  public user: User = new User('', '', '', '', '', '');

  // To message the user
  public message: Message = new Message('');

  registerUser(): void {
    this.registerService.registerUser(this.user).subscribe(
      message => this.message = message,
      error => this.message.text = 'An error has occured...');
  }

  ngOnInit(): void {

  }

}
