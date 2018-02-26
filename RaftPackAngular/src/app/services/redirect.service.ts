import { Injectable } from '@angular/core';
import { Http, RequestOptions, Headers, Response } from '@angular/http';
import { Router } from '@angular/router';
import { Observable } from 'rxjs/Observable';
import { User } from '../models/user.model';
import { ProfileService } from './profile.service';

@Injectable()
export class RedirectService {
  public redirectUrl: string;
  constructor(private http: Http,
    private router: Router, private profileService: ProfileService) { }

  // redirect(user: User) {
  //   this.profileService.getProfile(user).subscribe(profile => this.profile = profile);
  //   return this.router.navigate(['/post', this.profile.profileId]);
  // }

  private handleError(error: Response) {
    return Observable.throw(error.statusText);
  }
}
