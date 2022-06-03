import { Component, OnInit } from '@angular/core';
import { faEye, faEyeSlash, faWarning } from '@fortawesome/free-solid-svg-icons';
import { HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { RegisterService } from '../../Shared/services/register-service/register.service';
import { IRegisterError } from '../../Shared/interfaces/IRegisterError.interface';
import { IUserInterface } from '../../Shared/interfaces/IUserInterface';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  constructor(private register: RegisterService, private router: Router) { }
  username: string = "";
  password: string = "";
  confirmPassword: string = "";
  fName: string = "";
  lName: string = "";
  email: string = "";

  error : IRegisterError = {
    errorStatus :"",
    errorFirstName : "",
    errorLastName : "",
    errorEmail : "",
    errorUsername : "",
    errorPassword : ""
  };

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

    let options = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    }
    this.register.createUser(this.user, options).subscribe((data) => {
    
      this.router.navigateByUrl('/login')
      
    },(error) => {this.error = error}
    )
  }

  checkInput(data: string) {
    const input : any = document.querySelector("#" + data);
    if(!input.checkValidity()){
      switch(data) {
        case "fName" : this.error.errorFirstName = "First name should consist of letters only \nand minimum two characters";
        break;
        case "lName" : this.error.errorLastName = "Last name should consist of letters only \nand minimum two characters";
        break;
        case "email" : this.error.errorEmail = "Not a valid email";
        break;
        case "username" : this.error.errorUsername = "Username should be between 2 and 255 characters";
        break;
        case "password" : this.error.errorPassword= "Min 8 characters, at least 1 uppercase letter, 1 lowercase, 1 number and 1 special character";
        break;
      }
    }
    else{
      switch(data) {
        case "fName" : this.error.errorFirstName = "";
        break;
        case "lName" : this.error.errorLastName = "";
        break;
        case "email" : this.error.errorEmail = "";
        break;
        case "username" : this.error.errorUsername = "";
        break;
        case "password" : this.error.errorPassword= "";
        break;
      }
    }
  }

  // Front End Work
  public faEye = faEye; // icons
  public faEyeSlash = faEyeSlash; // icons
  public faWarning = faWarning; // icons

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



