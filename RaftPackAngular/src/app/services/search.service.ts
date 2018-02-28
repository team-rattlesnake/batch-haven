import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { User } from '../models/user.model';
import { of } from 'rxjs/observable/of';
import { catchError, tap } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class SearchService {

  private users: User[];

  constructor(private http: HttpClient) { }

  searchUsers(term: string): Observable<User[]> {
    if (!term.trim()) {
      // if not search term, return empty hero array.
      return of([]);
    }
    return this.http.get<User[]>(`http://localhost:8090/RaftPackSpring/getUsersByFirstName.app?firstName=${term}`).pipe(
      tap(_ => console.log(`found users matching "${term}"`)),
      catchError(this.handleError<User[]>('searchUsers', []))
    );
  }

  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

  /*search(terms: Observable<string>) {
    return terms.debounceTime(400)
      .distinctUntilChanged()
      .switchMap(term => this.searchEntries(term));
  }

  searchEntries(term) {
    return this.http
        .get(`http://localhost:9005/RaftPackSpring/getPosts.app?firstName=` + term)
        .map((response: Response) => {
          return response.json();
      });
  }*/

}
