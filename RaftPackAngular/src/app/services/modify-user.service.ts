import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { UserForm } from '../models/user-form';
import { User } from '../models/user.model';
import { Message } from './../models/message.model';
import { HttpClient, HttpHeaders } from '@angular/common/http';
const httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
@Injectable()
export class ModifyUserService {


    constructor(private httpc: HttpClient) { }

    update(user: User): Observable<User> {
        const body = JSON.stringify(user);
        const headers = new Headers({ 'Content-Type': 'application/json' });

        return this.httpc
            .post(`http://localhost:8090/RaftPackSpring/update.app`, body, httpOptions)
            .catch(this.handleError);
    }

    private handleError(error: Response) {
        return Observable.throw(error.statusText);
    }
}
