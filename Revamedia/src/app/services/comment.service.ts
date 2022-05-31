import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class CommentService {

  // API Base Url
  private baseUrl = environment.baseUrl;

  constructor(private httpClient: HttpClient) { }

  public addComment(comment: any): Observable<any> {
    return this.httpClient.post<any>(`${this.baseUrl}/comment/add`, comment);
  }

  public getCommentById(commentId: number): Observable<any> {
    return this.httpClient.get<any>(`${this.baseUrl}/comment/${commentId}`);
  }

}
