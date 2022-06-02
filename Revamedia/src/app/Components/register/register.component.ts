import { RegisterService } from './../../services/register.service';
import { Component, OnInit } from '@angular/core';
// Icons
import { faEye, faEyeSlash } from '@fortawesome/free-solid-svg-icons';
import { HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  constructor(private register : RegisterService) { }
  username: string = "";
  password: string = "";
  fName: string = "";
  lName: string = "";
  email: string = "";

  ngOnInit(): void {
  }

  registerHandler(username: string, password: string, fName: string, lName: string, email: string){


      let user = new User(username, password, fName, lName, email);
      console.log(user)
      let options = {
        headers: new HttpHeaders({
          'Content-Type': 'application/json'
        })
      }
      this.register.createUser(user, options).subscribe((data) => {
        console.log(data)
    })
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


export class User {
  id: number | undefined;
  username: string;
  password: string;
  firstName: string;
  lastName: string;
  email: string;

  constructor(_username: string, _password: string, _fName: string, _lName: string, _email: string) {
    this.username = _username;
    this.password = _password;
    this.firstName = _fName;
    this.lastName = _lName;
    this.email = _email;

  }
}
