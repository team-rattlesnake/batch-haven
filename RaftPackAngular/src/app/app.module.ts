import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { RegisterComponent } from './register/register.component';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { LoginService } from './login/login.service';
import { HttpModule } from '@angular/http';
import { NavbarComponent } from './navbar/navbar.component';

import { ModifyUserInfoComponent } from './modify-user-info/modify-user-info.component';
import { AppRoutingModule } from './app-routing.module';

import { HttpClientModule } from '@angular/common/http';
import { HttpClientInMemoryWebApiModule } from 'angular-in-memory-web-api';

import { ProfileComponent } from './profile/profile.component';
import { ProfileService } from './service/profile.service';
import { MessageService } from './service/message.service';
import { RegisterService } from './service/register.service';
import {UploadFileService} from './service/upload.service';
import { ProfileDetailComponent } from './profile-detail/profile-detail.component';
import { MessagesComponent } from './messages/messages.component';
import { PostComponent } from './post/post.component';
import { PostDetailsComponent } from './post-details/post-details.component';

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    LoginComponent,
    ModifyUserInfoComponent,
    ProfileComponent,
    MessagesComponent,
    PostComponent,
    PostDetailsComponent,
    ProfileDetailComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpModule,
    HttpClientModule
  ],
  providers: [ProfileService, MessageService, LoginService, RegisterService, UploadFileService],
  bootstrap: [AppComponent]
})
export class AppModule { }
