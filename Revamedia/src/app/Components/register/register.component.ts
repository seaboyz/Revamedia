import { Component, OnInit } from '@angular/core';
// Icons
import { faEye, faEyeSlash } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  // Front End Work
  public faEye = faEye; // icons
  public faEyeSlash = faEyeSlash; // icons

  // Show Password
  public showPassword = false;
  public toggleShowPassword(){
    this.showPassword = !this.showPassword;
  }
  public showConfirmPassword = false;
  public toggleShowConfirmPassword(){
    this.showConfirmPassword = !this.showConfirmPassword;
  }
}
