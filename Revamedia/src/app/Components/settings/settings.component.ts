import { Component, OnInit } from '@angular/core';
// Icons
import { faSun, faMoon } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-settings',
  templateUrl: './settings.component.html',
  styleUrls: ['./settings.component.scss']
})
export class SettingsComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  // Front End Work
  public faSun = faSun; // icon
  public faMoon = faMoon; // icon

  public darkTheme = false;
  public changeTheme() {
    document.body.classList.toggle('darkMode');
    this.darkTheme = !this.darkTheme;
  }
}
