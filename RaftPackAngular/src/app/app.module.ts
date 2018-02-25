import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { RegisterComponent } from './register/register.component';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { LoginService } from './login/login.service';
import { HttpModule } from '@angular/http';

import { ModifyUserInfoComponent } from './modify-user-info/modify-user-info.component';
import { AppRoutingModule } from './app-routing.module';
import { PasswordResetComponent } from './password-reset/password-reset.component';

import { HttpClientModule } from '@angular/common/http';
import { HttpClientInMemoryWebApiModule } from 'angular-in-memory-web-api';
import { InMemoryDataService } from './in-memory-data.service';

import { ProfileComponent } from './profile/profile.component';
import { ProfileDetailComponent } from './profile-detail/profile-detail.component';
import { ProfileService } from './profile.service';
import { MessageService } from './message.service';
import { RegisterService } from './service/register.service';

import { MessagesComponent } from './messages/messages.component';

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    LoginComponent,
    ModifyUserInfoComponent,
    ProfileComponent,
    ProfileDetailComponent,
    MessagesComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpModule,
    HttpClientModule,
    HttpClientInMemoryWebApiModule.forRoot(
      InMemoryDataService, { dataEncapsulation: false })
  ],
  providers: [ProfileService, MessageService, LoginService, RegisterService],
  bootstrap: [AppComponent]
})
export class AppModule { }
