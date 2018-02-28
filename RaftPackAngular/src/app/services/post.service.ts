import { Injectable } from '@angular/core';
import { MessageService } from './message.service';
import { Http, RequestOptions, Headers, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { Post } from '../models/post.model';
import { User } from 'aws-sdk/clients/mq';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Message } from '../models/message.model';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable()
export class PostService {

  constructor(private httpc: HttpClient,
    private messageService: MessageService) { }

  private log(message: string) {
    this.messageService.add(message);
  }

  public getPosts(profile: number): Observable<Post[]> {
    const body: string = JSON.stringify(profile);
    const headers: Headers = new Headers({ 'Content-Type': 'application/json' });
    const options: RequestOptions = new RequestOptions({ headers: headers });

    return this.httpc
      .post(`http://localhost:8090/RaftPackSpring/getPosts.app`, body, httpOptions)
      .catch(this.handleError);
  }

  public getAllPosts(): Observable<Post[]> {
    const headers: Headers = new Headers({ 'Content-Type': 'application/json' });
    const options: RequestOptions = new RequestOptions({ headers: headers });

    return this.httpc
      .get(`http://localhost:8090/RaftPackSpring/getAllPosts.app`, httpOptions)
      .catch(this.handleError);
  }

  public createPost(post: Post): Observable<Message> {
    const body: string = JSON.stringify(post);
    return this.httpc.post(`http://localhost:8090/RaftPackSpring/createPost.app`, body, httpOptions)
    .catch(this.handleError);
  }

  private handleError(error: Response) {
  return Observable.throw(error.statusText);
}

}
