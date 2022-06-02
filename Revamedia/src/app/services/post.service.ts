import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
//import { baseUrl } from //TODO
//import { User } from //TODO
//import { UserComments } from //TODO
//import { UserGroups } from //TODO
@Injectable({
  providedIn: 'root'
})
export class PostService {
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
url=baseUrl+'/post';
constructor(private httpClient:HttpClient){}
getPostAll():Observable<any>{
return this.httpClient.get<any>(this.url+'/getAllPosts',)
}
getPostId(id:number):Observable<any>{
return this.httpClient.get<any>(this.url+'/getPostById/'+id);
}
createPost(post:UserPosts):Observable<any>{
return this.httpClient.post<any>(this.url+'/addPost',post);
}
updatePost(post:UserPosts):Observable<any>{
return this.httpClient.put<any>(this.url+'/updatePost',post);
}
deletePost(post:UserPosts):Observable<any>{
return this.httpClient.request<any>('delete',this.url+'/deletePost',{body:post});
}
}
export interface UserPosts{
postId:number;
ownerId:User;
comments:UserComments[];
groupId:UserGroups[];
message:String;
youtubeLink:String;
image:String;
likes:number;
postLifetime:String;
dateCreated:String;
}
//temporary, probably
export let baseUrl:String='http://localhost:4200'
export interface User{
  userId:number;
  username:string;
  eamil:string;
  password:string;
  firstName:string;
  lastName:string;
  profilePicture:string;
  dateCreated:string;
  followers:User[];
  following:User[];
  postsOwned:UserPosts[];
}
export interface UserComments{
  commentId:number;
  ownerId:User;
  postId:UserPosts;
  replies:UserReplies[];
  message:string;
  dateCreated:string;
}
export interface UserGroups{
  groupId:number;
  ownerId:User;
  usersJoined:User[];
  posts:UserPosts[];
  dateCreated:string;
}
export interface UserReplies{
replyId:number;
ownerId:User;
commentId:UserComments;
message:string;
dateCreated:string;
}