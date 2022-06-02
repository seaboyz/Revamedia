import { Injectable } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { BehaviorSubject } from 'rxjs/internal/BehaviorSubject';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  public loggedIn = new BehaviorSubject<boolean>(this.checkLoginStatus());

  constructor(private router: Router, private http: HttpClient) { }

  checkLoginStatus(): boolean {
    var loginCookie = sessionStorage.getItem('LoggedIn');
    if (loginCookie == "1") {
      return true;
    } else {
      return false;
    }
  }
  public login(loginForm: NgForm) {

    let user = {
      username: loginForm.value.username,
      password: loginForm.value.password
    }
    //Post request to attempt to login the user
    this.http.post('http://localhost:8080/login', user, {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'mode': 'login'
      })
    }).subscribe((response: any) => {
      //If login was successful store the user's info in session storage
      user = response;
      sessionStorage.setItem('userid', response.userId.toString());
      sessionStorage.setItem('username', response.username);
      sessionStorage.setItem('email', response.email);
      sessionStorage.setItem('firstname', response.firstName);
      sessionStorage.setItem('lastname', response.lastName);
      sessionStorage.setItem('phone', response.phone);
      this.loggedIn.next(true);
      sessionStorage.setItem('LoggedIn', '1');

    }, (error: HttpErrorResponse) => {
      const message = document.getElementById('invalid');
      message?.classList.toggle('show');
      console.log(error);
    })
    this.router.navigateByUrl('/home');
  }

  public logout() {
    this.loggedIn.next(false);
    this.router.navigateByUrl('/login');
    sessionStorage.clear();
  }
}
