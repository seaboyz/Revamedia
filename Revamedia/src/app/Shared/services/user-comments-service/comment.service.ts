import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';
import {environment} from "../../../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class CommentService {

  // API Base Url
  private baseUrl = `${environment.apiBaseUrl}`;

  constructor(private httpClient: HttpClient) { }

  public addComment(comment: any): Observable<any> {
    return this.httpClient.post<any>(`${this.baseUrl}/comment/add`, comment);
  }

  public getCommentById(commentId: number): Observable<any> {
    return this.httpClient.get<any>(`${this.baseUrl}/comment/${commentId}`);
  }

  public getAllComments(): Observable<any[]> {
    return this.httpClient.get<any[]>(`${this.baseUrl}/comment/all`);
  }

  public updateComment(comment: any): Observable<any> {
    return this.httpClient.put<any>(`${this.baseUrl}/comment/update`, comment);
  }

  public deleteComment(id: number): Observable<any> {
    return this.httpClient.delete<any>(`${this.baseUrl}/comment/delete/${id}`);
  }

  public addReply(reply: any): Observable<any> {
    return this.httpClient.post<any>(`${this.baseUrl}/reply/add`, reply);
  }

  public updateReply(message: any, id: number): Observable<any> {
    return this.httpClient.put<any>(`${this.baseUrl}/reply/update/${id}`, message);
  }

  public deleteReply(id: number): Observable<any> {
    return this.httpClient.delete<any>(`${this.baseUrl}/reply/delete/${id}`);
  }

}
