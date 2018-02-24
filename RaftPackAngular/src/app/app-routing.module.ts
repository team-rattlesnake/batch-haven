import { NgModule } from '@angular/core';
import { RouterModule, Routes} from '@angular/router';
import { ModifyUserInfoComponent } from './modify-user-info/modify-user-info.component';
import { PasswordResetComponent } from './password-reset/password-reset.component'

const routes: Routes = [
 { path: 'modify-user-info',component : ModifyUserInfoComponent},
 { path: 'password-reset', component : PasswordResetComponent}
]


@NgModule({
  imports: [
    RouterModule.forRoot(routes),
  ],
  exports :[RouterModule],
  declarations: []
})
export class AppRoutingModule { }
