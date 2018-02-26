import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { MessageService } from './message.service';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { catchError, map, tap } from 'rxjs/operators';
import { Profile } from '../models/profile.model';
import { User } from '../models/user.model';
import { ProfileDetailComponent } from '../profile-detail/profile-detail.component';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class ProfileService {
  private profileUrl = 'api/profile';

  constructor(
    private http: Http,
    private httpc: HttpClient,
    private messageService: MessageService) { }

  private log(message: string) {
    this.messageService.add(message);
  }

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

  getProfiles(): Observable<Profile[]> {
    return this.httpc.get<Profile[]>(this.profileUrl);
  }

  getProfilec(id: number): Observable<Profile> {
    const url = `${this.profileUrl}/${id}`;
    return this.httpc.get<Profile>(url).pipe(
      tap(_ => this.log(`profile id=${id}`))
    );
  }

  updateProfile(profile: Profile): Observable<any> {
    return this.httpc.put(this.profileUrl, profile, httpOptions).pipe(
      tap(_ => this.log(`updated name=${profile.user.first_name} |
      updated email=${profile.user.user_email}`))
    );
  }
}

