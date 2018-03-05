import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { RegisterComponent } from './register/register.component';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { LoginService } from './services/login.service';
import { HttpModule } from '@angular/http';
import { NavbarComponent } from './navbar/navbar.component';
import { FormdataUploadComponent } from './form-data-upload/form-data-upload.component';
import { ReactiveFormsModule } from '@angular/forms';
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
import { FriendProfileComponent } from './friend-profile/friend-profile.component';
import { SearchComponent } from './search/search.component';
import { SearchService } from './services/search.service';
import { SocketIoModule, SocketIoConfig } from 'ng-socket-io';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { SimpleNotificationsModule } from 'angular2-notifications';
import { ProfilePostsComponent } from './profile-posts/profile-posts.component';
const config: SocketIoConfig = {
  url: 'http://localhost:8000', options: {}};


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
    FriendProfileComponent,
    SearchComponent,
    FormdataUploadComponent,
    ProfilePostsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpModule,
    HttpClientModule,
    ReactiveFormsModule,
    SocketIoModule.forRoot(config),
    BrowserAnimationsModule,
    SimpleNotificationsModule.forRoot()
  ],
  providers: [ProfileService, MessageService, LoginService, RegisterService, UploadFileService, ModifyUserService, PostService,
    SearchService, PostComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }
