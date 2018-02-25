import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';

import { User } from '../models/User.model';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Injectable()
export class LoginService {

  constructor(private http: Http) { }

  public fetchUserInformation(email: string): Observable<User> {
    return this.http
            .get(`http://localhost:9005/login/${email}`)
            .map((response: Response) => {
                return <User> response.json();
            })
            .catch(this.handleError);
}

private handleError(error: Response) {
    return Observable.throw(error.statusText);
}

}
