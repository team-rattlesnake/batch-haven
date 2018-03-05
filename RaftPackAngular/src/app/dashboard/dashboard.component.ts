import { Component, OnInit } from '@angular/core';
import { Socket } from 'ng-socket-io';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/of';
import 'rxjs/add/operator/timeout';

import { defer as _defer } from 'lodash';
import { NotificationsService } from 'angular2-notifications';
@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor(private socket: Socket,  private notificationsService: NotificationsService) {
    socket.on('new notification', function (data) {
        notificationsService.info('', data, {
        timeOut: 3000,
        pauseOnHover: true,
        clickToClose: true
      });
      // alert(data);
    });
  }

  ngOnInit() {
  }

}
