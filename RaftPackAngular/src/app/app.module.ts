import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { LoginService } from './login/login.service';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { ModifyUserInfoComponent } from './modify-user-info/modify-user-info.component';
import { AppRoutingModule } from './app-routing.module';

import { HttpClientModule } from '@angular/common/http';
import { HttpClientInMemoryWebApiModule } from 'angular-in-memory-web-api';
import { InMemoryDataService } from './in-memory-data.service';

import { ProfileComponent } from './profile/profile.component';
import { ProfileDetailComponent } from './profile-detail/profile-detail.component';
import { ProfileService } from './profile.service';
import { MessageService } from './message.service';
import { MessagesComponent } from './messages/messages.component';

@NgModule({
  declarations: [
    AppComponent,
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
  providers: [ProfileService, MessageService,LoginService],
  bootstrap: [AppComponent]
})
export class AppModule { }
