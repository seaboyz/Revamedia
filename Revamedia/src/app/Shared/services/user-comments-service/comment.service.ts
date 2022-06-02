import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';
import {environment} from "../../../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class CommentService {

  // API Base Url
  private baseUrl = `${environment.baseUrl}/comment`;

  constructor(private httpClient: HttpClient) { }

  public addComment(comment: any): Observable<any> {
    return this.httpClient.post<any>(`${this.baseUrl}/add`, comment);
  }

  public getCommentById(commentId: number): Observable<any> {
    return this.httpClient.get<any>(`${this.baseUrl}/${commentId}`);
  }

  public getAllComments(): Observable<any[]>{
    return this.httpClient.get<any[]>(`${this.baseUrl}/all`);
  }

  public updateComment(comment: any): Observable<any> {
    return this.httpClient.put<any>(`${this.baseUrl}/update`, comment);
  }

}
