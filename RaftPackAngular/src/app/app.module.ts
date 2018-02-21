import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule }   from '@angular/forms';//practice

import { AppComponent } from './app.component';
import { ModifyUserInfoComponent } from './modify-user-info/modify-user-info.component';
import { AppRoutingModule } from './app-routing.module';


@NgModule({
  declarations: [
    AppComponent,
    ModifyUserInfoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
],

  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
