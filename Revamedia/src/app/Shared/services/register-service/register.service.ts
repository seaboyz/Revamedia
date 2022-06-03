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
      .pipe(
        retry(3),
        catchError(this.errorHandler)
      )
  }

  errorHandler(error: any): any {
    let errorMessage : any = {};

    if (error.error instanceof ErrorEvent) {
      // Get client-side error
      errorMessage = error.error.message;

    } else {
      // Get server-side error
      errorMessage.errorStatus = error.status;
      errorMessage.errorFirstName = error.error.firstName;
      errorMessage.errorLastName = error.error.lastName;
      errorMessage.errorEmail = error.error.email;
      errorMessage.errorUsername = error.error.username;
      errorMessage.errorPassword = error.error.password;
      //errorMessage = Error Code: ${error.status}\nMessage: ${error.error.firstName};
    }
    //return errorMessage;
    return throwError(() => errorMessage);
  }


}