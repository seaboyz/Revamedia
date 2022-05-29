import { Component, OnInit } from '@angular/core';
// Icons
import { faHome, faEnvelope, faUserGear, faCalendarDays, faUsers, faDoorOpen } from '@fortawesome/free-solid-svg-icons';
import { Observable } from 'rxjs/internal/Observable';
import { AuthenticationService } from 'src/app/services/authentication.service';
@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  //Icons
  public faHome = faHome;
  public faEnvelope = faEnvelope;
  public faUserGear = faUserGear;
  public faCalendarDays = faCalendarDays;
  public faUsers = faUsers;
  public faDoorOpen = faDoorOpen;

  constructor(public auth: AuthenticationService) { }

  ngOnInit(): void {
  }

  public LogOut(){
    this.auth.logout();
  }

}
