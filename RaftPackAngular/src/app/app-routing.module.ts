import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { PostDetailComponent } from './post-detail/post-detail.component';


const routes: Routes = [
  { path: '', redirectTo: '/post', pathMatch: 'full' },
  { path: 'post/:id', component: PostDetailComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
