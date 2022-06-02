import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  userURL: string = "http://localhost:8080/user"


  getAllUsers() : Observable<any> {
    return this.http.get<any>(`${this.userURL}/allUsers`, {observe : `response`})
  }

  constructor(private http:HttpClient) { }
}