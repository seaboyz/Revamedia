import { RegisterService } from './../../services/register.service';
import { Component, OnInit } from '@angular/core';
// Icons
import { faEye, faEyeSlash } from '@fortawesome/free-solid-svg-icons';
import { HttpHeaders } from '@angular/common/http';

import { IUserInterface } from 'src/app/shared/interfaces/IUserInterface';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  constructor(private register: RegisterService) { }
  username: string = "";
  password: string = "";
  fName: string = "";
  lName: string = "";
  email: string = "";

  public user: IUserInterface = {
    username: "",
    id: undefined,
    password: '',
    firstName: '',
    lastName: '',
    email: ''
  };

  ngOnInit(): void {
  }

  registerHandler(username: string, password: string, fName: string, lName: string, email: string) {

    this.user.firstName = fName;
    this.user.lastName = lName;
    this.user.username = username;
    this.user.password = password;
    this.user.email = email;
    console.log(this.user);
    //let user = new User(username, password, fName, lName, email);
    //console.log(user)
    let options = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    }
    this.register.createUser(this.user, options).subscribe((data) => {
      console.log(data)
    })
  }


  // Front End Work
  public faEye = faEye; // icons
  public faEyeSlash = faEyeSlash; // icons

  // Show Password
  public showPassword = false;
  public toggleShowPassword() {
    this.showPassword = !this.showPassword;
  }
  public showConfirmPassword = false;
  public toggleShowConfirmPassword() {
    this.showConfirmPassword = !this.showConfirmPassword;
  }
}

