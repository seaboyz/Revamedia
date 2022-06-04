
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserPostsService {
  userPostURL: string = "http://localhost:8080/posts"

  constructor(private http: HttpClient) { }

  public getAllPosts(): Observable<any> {
    return this.http.get<any[]>(`${this.userPostURL}/getAllPosts`);
  }

  public getPostById(id: Number): Observable<any> {
    return this.http.get<any>(`${this.userPostURL}/${id}`)
  }

  public addPost(post: any): Observable<any> {
    return this.http.post<any>(`${this.userPostURL}/addPost`, post);
  }

  public updatePost(post: any): Observable<any> {
    return this.http.put<any>(`${this.userPostURL}/updatePost`, post);
  }

  public deletePost(post: any): Observable<any> {
    return this.http.delete<any>(`${this.userPostURL}`, post);
  }

  //array of posts
  //behavior value of inital value of array of posts

  // update post function sends put requests and updates 
  updatePostLikes(updatePostLikesDto: any): Observable<any> {
    return this.http.put<any>(`${this.userPostURL}/likes`, updatePostLikesDto, { observe: `response` })
  }

}
