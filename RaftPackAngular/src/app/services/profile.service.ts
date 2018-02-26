import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { MessageService } from './message.service';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { catchError, map, tap } from 'rxjs/operators';
import { User } from '../models/user.model';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class ProfileService {

  constructor(
    private http: Http,
    private httpc: HttpClient,
    private messageService: MessageService) { }

  private log(message: string) {
    this.messageService.add(message);
  }

  public getProfile(userId: number): Observable<User> {
    const body: string = JSON.stringify(userId);
    const headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json'});

    return this.httpc
        .post(`http://localhost:9005/RaftPackSpring/getUser.app`, body, httpOptions)
        .catch(this.handleError);
  }

  private handleError(error: Response) {
      return Observable.throw(error.statusText);
  }

}

