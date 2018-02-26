import { RegisterComponent } from './register/register.component';
import { NgModule } from '@angular/core';

import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { ModifyUserInfoComponent } from './modify-user-info/modify-user-info.component';
import { ProfileComponent } from './profile/profile.component';
import { PostComponent } from './post/post.component';

export const routes: Routes = [
    { path: '', component: LoginComponent },
    { path: 'login', component: LoginComponent },
    { path: 'register', component : RegisterComponent},
    { path: 'modify-user-info', component : ModifyUserInfoComponent},
    { path: 'profile', component : ProfileComponent},
    { path: 'post/:id', component : PostComponent}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
exports: [ RouterModule ]
})

export class AppRoutingModule {}
