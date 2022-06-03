import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule,HTTP_INTERCEPTORS } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NavbarComponent } from './Components/navbar/navbar.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { SettingsComponent } from './Components/settings/settings.component';
import { EventsComponent } from './Components/events/events.component';
import { GroupsComponent } from './Components/groups/groups.component';
import { HomeComponent } from './Components/home/home.component';
import { MessagesComponent } from './Components/messages/messages.component';
import { LoginComponent } from './Components/login/login.component';
import { RegisterComponent } from './Components/register/register.component';
import { ErrorPageComponent } from './Components/error-page/error-page.component';
import { ProfileComponent } from './Components/profile/profile.component';
import { ValidateEqualModule } from 'ng-validate-equal';
import { CookieService } from 'ngx-cookie-service';
import { CommentService } from './Shared/services/user-comments-service/comment.service';
import { GiphyService } from './Shared/services/giphy-service/giphy.service';
import { AuthenticationService } from './Shared/services/auth-service/authentication.service';
import { HttpErrorInterceptor } from './Shared/services/HttpInterceptor/http-error.interceptor';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    SettingsComponent,
    EventsComponent,
    GroupsComponent,
    HomeComponent,
    MessagesComponent,
    LoginComponent,
    RegisterComponent,
    ErrorPageComponent,
    ProfileComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FontAwesomeModule,
    FormsModule,
    HttpClientModule,
    FormsModule,
    ValidateEqualModule
  ],
  providers: [AuthenticationService, CommentService, GiphyService, CookieService, { provide: HTTP_INTERCEPTORS,useClass: HttpErrorInterceptor,multi: true }],
  bootstrap: [AppComponent]
})
export class AppModule { }
