import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';
import { MessageService } from './message.service';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { catchError, map, tap } from 'rxjs/operators';
import { Profile } from '../models/profile.model';
import { User } from '../models/user.model';

@Injectable()
export class ProfileService {
  constructor(
    private http: Http,
    private messageService: MessageService) { }
    private log(message: string) {
      this.messageService.add(message);
    }
    // tslint:disable-next-line:member-ordering
    // getProfiles (): Observable<Profile[]> {
    //   return this.http.get<Profile[]>(this.profileUrl);
    // }
    public getProfile(user: User): Observable<Profile> {
      const body: string = JSON.stringify(user);
      const headers: Headers = new Headers({ 'Content-Type': 'application/json'});
      const options: RequestOptions = new RequestOptions({ headers: headers });

      return this.http
          .post(`http://localhost:8090/RaftPackSpring/getProfile.app`, body, options)
          .map((response: Response) => {
              return <Profile>response.json();
          })
          .catch(this.handleError);
  }

  private handleError(error: Response) {
      return Observable.throw(error.statusText);
  }

}

