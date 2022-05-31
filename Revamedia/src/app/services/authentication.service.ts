import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject } from 'rxjs/internal/BehaviorSubject';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  public loggedIn = new BehaviorSubject<boolean>(this.checkLoginStatus());

  constructor(private router: Router,) { }

  checkLoginStatus(): boolean {
    var loginCookie = sessionStorage.getItem('LoggedIn');
    if (loginCookie == "1") {
      return true;
    } else {
      return false;
    }
  }
  public login(){
    this.loggedIn.next(true);
    sessionStorage.setItem('LoggedIn', '1');
    this.router.navigateByUrl('/home');
  }

  public logout() {
    this.loggedIn.next(false);
    this.router.navigateByUrl('/login');
    sessionStorage.clear();
  }
}
