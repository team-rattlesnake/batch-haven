import { Injectable } from '@angular/core';
import { MessageService } from './message.service';
import { Http, RequestOptions, Headers, Response } from '@angular/http';
import { Profile } from '../models/profile.model';
import { Observable } from 'rxjs/Observable';
import { Post } from '../models/post.model';

@Injectable()
export class PostService {

  constructor(private http: Http,
    private messageService: MessageService) { }

  private log(message: string) {
    this.messageService.add(message);
  }

  public getPosts(profile: number): Observable<Post[]> {
    const body: string = JSON.stringify(profile);
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
