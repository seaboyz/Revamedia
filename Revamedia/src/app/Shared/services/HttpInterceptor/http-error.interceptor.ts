import { HttpEvent,HttpInterceptor,HttpHandler,HttpRequest,HttpErrorResponse } from '@angular/common/http';
import { ErrorHandler, Injectable } from '@angular/core';
   
   import { BehaviorSubject, Observable, throwError } from 'rxjs';
   
   import { retry, catchError } from 'rxjs/operators';

   
   @Injectable({
     providedIn: 'root'
   })
   export class HttpErrorInterceptor implements HttpInterceptor {

    public errorList: string[] = [];

    public getErrorList(){
      console.log('list of errors', this.errorList)
      return this.errorList;
    }

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
      return next.handle(request)
        .pipe(
          retry(1),
          catchError((error: HttpErrorResponse) => {
            let errorMessage : any = {}
            if (error.error instanceof ErrorEvent) {
              // client-side error
              errorMessage = `Error: ${error.error.message}`;
            } else {
              // server-side error
              errorMessage.errorStatus = error.status;
              errorMessage.errorFirstName = error.error.firstName;
              errorMessage.errorLastName = error.error.lastName;
              errorMessage.errorEmail = error.error.email;
              errorMessage.errorUsername = error.error.username;
              errorMessage.errorPassword = error.error.password;
            }
            //window.alert(errorMessage);
            return throwError(()=> errorMessage);
          })
        )
    }
  }