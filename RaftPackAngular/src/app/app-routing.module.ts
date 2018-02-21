import { NgModule } from '@angular/core';
import { RouterModule, Routes} from '@angular/router';
import { ModifyUserInfoComponent } from './modify-user-info/modify-user-info.component';

const routes: Routes = [
 { path: 'modify-user-info',component : ModifyUserInfoComponent}
]


@NgModule({
  imports: [
    RouterModule.forRoot(routes),
  ],
  exports :[RouterModule],
  declarations: []
})
export class AppRoutingModule { }
