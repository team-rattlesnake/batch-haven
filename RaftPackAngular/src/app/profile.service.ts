import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { MessageService } from './message.service';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { catchError, map, tap } from 'rxjs/operators';
import { Profile } from './profile';
import { ProfileDetailComponent } from './profile-detail/profile-detail.component';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable()
export class ProfileService {
  constructor(
    private http: HttpClient,
    private messageService: MessageService) { }
    private log(message: string) {
      this.messageService.add(message);
    }
    // tslint:disable-next-line:member-ordering
    private profileUrl = 'api/profile';
    getProfiles (): Observable<Profile[]> {
      return this.http.get<Profile[]>(this.profileUrl);
    }
    getProfile(id: number): Observable<Profile> {
      const url = `${this.profileUrl}/${id}`;
      return this.http.get<Profile>(url).pipe(
        tap(_ => this.log(`profile id=${id}`))
      );
    }
    updateHero (profile: Profile): Observable<any> {
      return this.http.put(this.profileUrl, profile, httpOptions).pipe(
        tap(_ => this.log(`updated name=${profile.name} |
        updated email=${profile.email}`))
      );
    }
}

