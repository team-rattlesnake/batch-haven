import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { RegisterComponent } from './register/register.component';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { LoginService } from './services/login.service';
import { HttpModule } from '@angular/http';
import { NavbarComponent } from './navbar/navbar.component';

import { ModifyUserInfoComponent } from './modify-user-info/modify-user-info.component';
import { AppRoutingModule } from './app-routing.module';

import { HttpClientModule } from '@angular/common/http';
import { HttpClientInMemoryWebApiModule } from 'angular-in-memory-web-api';

import { ProfileComponent } from './profile/profile.component';
import { ProfileService } from './services/profile.service';
import { MessageService } from './services/message.service';
import { RegisterService } from './services/register.service';
import { UploadFileService } from './services/upload.service';
import { MessagesComponent } from './messages/messages.component';
import { PostComponent } from './post/post.component';
import { PostDetailsComponent } from './post-details/post-details.component';
import { ModifyUserService } from './services/modify-user.service';
import { PostService } from './services/post.service';
import { DashboardComponent } from './dashboard/dashboard.component';
import { FeedComponent } from './feed/feed.component';
import { SearchComponent } from './search/search.component';
import { SearchService } from './services/search.service';

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
    NavbarComponent,
    DashboardComponent,
    FeedComponent,
    SearchComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpModule,
    HttpClientModule
  ],
  providers: [ProfileService, MessageService, LoginService, RegisterService, UploadFileService, ModifyUserService, PostService,
    SearchService],
  bootstrap: [AppComponent]
})
export class AppModule { }
