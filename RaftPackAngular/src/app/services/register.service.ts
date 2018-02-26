import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
// For Map
// tslint:disable-next-line:import-blacklist
import 'rxjs/Rx';

import { User } from '../models/user.model';
import { Message } from '../models/message.model';

@Injectable()
export class RegisterService {
    constructor(private http: Http) { }

    public registerUser(user: User): Observable<Message> {
        const body  = JSON.stringify(user);
        const headers = new Headers({ 'Content-Type': 'application/json' });
        const options: RequestOptions = new RequestOptions({ headers: headers });
        console.log('Sending: ' + body);



        return this.http
            .post(`http://localhost:8090/RaftPackSpring/registerUser.app`, body, options)
            .map((response: Response) => {

                return <Message>response.json();
            })
            .catch(this.handleError);
    }

    private handleError(error: Response) {
        return Observable.throw(error.statusText);
    }
}
