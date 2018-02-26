import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';

import { User } from '../models/user.model';
import { Message } from '../models/message.model';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Injectable()
export class LoginService {

    constructor(private http: Http) { }

    public login(user: User): Observable<User> {
        const body  = JSON.stringify(user);
        const headers = new Headers({ 'Content-Type': 'application/json' });
        const options: RequestOptions = new RequestOptions({ headers: headers });

        return this.http
            .post(`http://localhost:8090/RaftPackSpring/login.app`, body, options)
            .map((response: Response) => {
                return <User>response.json();
            })
            .catch(this.handleError);
    }

    private handleError(error: Response) {
        return Observable.throw(error.statusText);
    }

}
