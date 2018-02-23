import { NgModule } from '@angular/core';

import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { ModifyUserInfoComponent } from './modify-user-info/modify-user-info.component';

export const routes: Routes = [
    { path: '', component: LoginComponent },
    { path: 'login', component: LoginComponent },
    { path: 'modify-user-info', component : ModifyUserInfoComponent}

];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [ RouterModule ]
})

export class AppRoutingModule {}
