
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserPostsService {
  userPostURL: string = "http://localhost:8080/posts"

  //array of posts
  //behavior value of inital value of array of posts

  //update post function sends put requests and updates



  updatePostLikes(updatePostLikesDto: any) : Observable<any> {


    return this.http.put<any>(`${this.userPostURL}/likes`, updatePostLikesDto, {observe : `response`})

  }


  constructor(private http:HttpClient) { }
}
