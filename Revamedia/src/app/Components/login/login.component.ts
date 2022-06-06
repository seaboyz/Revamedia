import { Component, OnInit } from '@angular/core';

// Icons
import { faEye, faEyeSlash } from '@fortawesome/free-solid-svg-icons';
import { NgForm } from '@angular/forms';
import { AuthenticationService } from "../../Shared/services/auth-service/authentication.service";
import { FireAuthService } from "src/app/Shared/services/fire-auth-service/fire-auth.service";
import { Router } from "@angular/router";


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit
{

  constructor(public auth: FireAuthService, public router: Router) { }

  ngOnInit(): void
  {

  }

  public TEMPLogIn(loginForm: NgForm)
  {
    this.auth.login(loginForm.value.username, loginForm.value.password)
      .then(() => this.router.navigateByUrl('home'))
  }

  // Front End Work
  public faEye = faEye; //icon
  public faEyeSlash = faEyeSlash; // icon

  // Invalid username or password
  public invalid = false;

  // Show Password
  public showPassword = false;
  public toggleShowPassword()
  {
    this.showPassword = !this.showPassword;
  }

}
