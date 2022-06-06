import { Component, OnInit } from '@angular/core';
// Icons
import { faHome, faEnvelope, faUserGear, faCalendarDays, faUsers, faDoorOpen } from '@fortawesome/free-solid-svg-icons';
import { FireAuthService } from "src/app/Shared/services/fire-auth-service/fire-auth.service";
import { AuthenticationService } from "../../Shared/services/auth-service/authentication.service";


@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit
{


  constructor(public auth: FireAuthService) { }

  ngOnInit(): void
  {
  }

  public LogOut()
  {
    this.auth.logout();
  }

  // Front End Work
  public faHome = faHome; //Icon
  public faEnvelope = faEnvelope; //Icon
  public faUserGear = faUserGear; //Icon
  public faCalendarDays = faCalendarDays; //Icon
  public faUsers = faUsers; //Icon
  public faDoorOpen = faDoorOpen;  //Icon

}
