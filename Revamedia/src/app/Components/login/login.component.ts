import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/app/services/authentication.service';
// Icons
import { faEye, faEyeSlash } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  constructor(public auth: AuthenticationService) { }

  ngOnInit(): void {
  }
  public TEMPLogIn(){
    this.auth.login();
  }

  // Front End Work
  public faEye = faEye; //icon
  public faEyeSlash = faEyeSlash; // icons

  // Show Password
  public showPassword = false;
  public toggleShowPassword(){
    this.showPassword = !this.showPassword;
  }

}
