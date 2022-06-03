import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, retry, throwError, catchError } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  baseUrl: string = "http://localhost:8080/auth/register";

  constructor(private http : HttpClient) { }
  createUser(body: object, options: object): Observable<any> {
    console.log("Post: ", this.baseUrl, body, options)
    return this.http.post<any>(this.baseUrl ,  JSON.stringify(body), options)

  }

  // errorHandler(e: any): any {
  //   console.log(e)
  //   console.log("Error handler invoked...");
  //   let errorMessage = '';
  //   if (e.error instanceof ErrorEvent) {
  //     // Get client-side error
  //     errorMessage = e.error.message;

  //   } else {
  //     // Get server-side error
  //     errorMessage = `Error Code: ${e.status}\nMessage: ${e.message}`;

  //   }
  //   console.log(errorMessage);
  //   return throwError(() => new Error(errorMessage));
  // }


}
