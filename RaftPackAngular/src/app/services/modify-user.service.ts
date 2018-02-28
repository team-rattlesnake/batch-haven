import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { UserForm } from '../models/user-form';

@Injectable()
export class ModifyUserService {


constructor(private http: Http) { }

  modifyuserinfoGo( userForm : UserForm) : Observable<UserForm>{
        const body  = JSON.stringify(userForm);
        const headers = new Headers({ 'Content-Type': 'application/json' });
        const options: RequestOptions = new RequestOptions({ headers: headers });

        return this.http
            .post(`http://localhost:8090/RaftPackSpring/modifyuser.app`, body, options)
            .map((response: Response) => {
                return <String>response.json();
            })
            .catch(this.handleError);
    }

    private handleError(error: Response) {
        return Observable.throw(error.statusText);
    }
  }
