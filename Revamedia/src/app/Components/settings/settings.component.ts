import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
// Icons
import { faSun, faMoon, faEye, faEyeSlash } from '@fortawesome/free-solid-svg-icons';
import { UserService } from 'src/app/Shared/services/user-service/user.service';

@Component({
  selector: 'app-settings',
  templateUrl: './settings.component.html',
  styleUrls: ['./settings.component.scss']
})
export class SettingsComponent implements OnInit {

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.getUserData();
  }

  // Back end work
  public user: any;
  public editUser: any; // Used for edit modal
  public deleteUser: any; // Used for delete modal

  // GET CURRENT USER
  public getUserData(){
    this.userService.getCurrentUser().subscribe(
      (response: any) => {
        this.user = response;
        console.log(this.user);
      },
      (error: HttpErrorResponse) => {
        console.log(error.message)
      }
    );
  }

  // ICONS
  public faSun = faSun;
  public faMoon = faMoon;
  public faEyeSlash = faEyeSlash;
  public faEye = faEye;
  // ICONS

  // DARK THEME
  public darkTheme = false;
  public changeTheme() {
    document.body.classList.toggle('darkMode');
    this.darkTheme = !this.darkTheme;
  }
  // DARK THEME

  // SHOW PASSWORD
  // Show Password
  public showPassword = false;
  public toggleShowPassword() {
    this.showPassword = !this.showPassword;
  }
  // SHOW PASSWORD

  // MODALS FUNCTION
  public openModal(mode: string, user: any){
    // Screen
    const screen = document.getElementById('screen');
    screen?.classList.add('openScreen');
    // Form
    const form = document.getElementById(`${mode}-account-modal`);
    form?.classList.add('openModal');
    if(mode === 'edit'){
      this.editUser = this.user;
    }
    if(mode === 'delete'){
      this.deleteUser = this.user;
    }
  }

  public closeModal(modalType: string){
    // Screen
    const screen = document.getElementById('screen');
    screen?.classList.remove('openScreen');
    // Form
    const form = document.getElementById(`${modalType}-account-modal`);
    form?.classList.remove('openModal');
  }
// MODALS FUNCTION END
}
