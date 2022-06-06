import { Injectable } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { BehaviorSubject } from 'rxjs/internal/BehaviorSubject';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { CookieService } from 'ngx-cookie-service';
import { environment } from 'src/environments/environment';


@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  public loggedIn = new BehaviorSubject<boolean>(this.checkLoginStatus());

  constructor(private router: Router, private http: HttpClient, private cookieService: CookieService) { }

  checkLoginStatus(): boolean {
    var loginCookie = sessionStorage.getItem('LoggedIn');
    if (loginCookie == "1") {
      return true;
    } else {
      return false;
    }
  }

  authUrl: string = environment.apiBaseUrl + "/auth/login";
  public login(loginForm: NgForm) {

    let user = {
      username: loginForm.value.username,
      password: loginForm.value.password
    }

    //Post request to attempt to login the user

    this.http.post(this.authUrl, user, {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      }),
      'withCredentials': true
    }).subscribe((response: any) => {
      //If login was successful store the user's info in session storage
      // user = response;
      // sessionStorage.setItem('userid', response.userId.toString());
      // sessionStorage.setItem('username', response.username);
      // sessionStorage.setItem('email', response.email);
      // sessionStorage.setItem('firstname', response.firstName);
      // sessionStorage.setItem('lastname', response.lastName);
      // sessionStorage.setItem('phone', response.phone);

      sessionStorage.setItem('LoggedIn', '1');
      this.loggedIn.next(true);
      this.router.navigateByUrl('/home');
    }, (error: HttpErrorResponse) => {
      document.getElementById('invalid')!.style.display = "flex";
      console.log(error);
    })

  }

  public logout() {
    this.loggedIn.next(false);
    this.router.navigateByUrl('/login');
    this.cookieService.deleteAll();
    sessionStorage.removeItem('LoggedIn');
  }
}
