import { RegisterComponent } from './register/register.component';
import { NgModule } from '@angular/core';

import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { ModifyUserInfoComponent } from './modify-user-info/modify-user-info.component';
import { ProfileComponent } from './profile/profile.component';
import { PostComponent } from './post/post.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { PostDetailsComponent } from './post-details/post-details.component';
import { FriendProfileComponent } from './friend-profile/friend-profile.component';




export const routes: Routes = [
    { path: '', component: LoginComponent },
    { path: 'login', component: LoginComponent },
    { path: 'login/register', component : RegisterComponent},
    { path: 'modify-user-info', component : ModifyUserInfoComponent},
    { path: 'profile', component : ProfileComponent},
    { path: 'profile/:id', component : ProfileComponent},
    { path: 'createPost', component : PostComponent},
    { path: 'post', component: PostDetailsComponent },
    { path: 'dashboard', component : DashboardComponent},
    { path: 'register', component : RegisterComponent},
    { path: 'friend-profile', component : FriendProfileComponent}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
exports: [ RouterModule ]
})

export class AppRoutingModule {}
