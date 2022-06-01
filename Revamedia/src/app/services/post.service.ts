import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BaseUrl } from //TODO
import { User } from //TODO
import { UserComments } from //TODO
import { UserGroups } from //TODO
@Injectable({
  providedIn: 'root'
})
export class PostService {
url=BaseUrl+'/post';
constructor(private httpClient:HttpClient){}
getPostAll():Observable<any>{
return this.httpClient.get<any>(this.url+'/getAllPosts')
}
getPostId(id:number):Observable<any>{
return this.httpClient.get<any>(this.url+'/getPostById/'+id)
}
createPost(post:UserPost):Observable<any>{
return this.httpClient.post<any>(this.url+'/addPost',post)
}
updatePost(post:UserPost):Observable<any>{
return this.httpClient.put<any>(this.url+'/updatePost',post)
}
deletePost(post:UserPost):Observable<any>{
return this.httpClient.delete<any>(this.url+'/deletePost',post)
}
}
export interface UserPost{
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