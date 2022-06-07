import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SettingsComponent } from './Components/settings/settings.component';
import { EventsComponent } from './Components/events/events.component';
import { GroupsComponent } from './Components/groups/groups.component';
import { HomeComponent } from './Components/home/home.component';
import { MessagesComponent } from './Components/messages/messages.component';
import { LoginComponent } from './Components/login/login.component';
import { RegisterComponent } from './Components/register/register.component';
import { ErrorPageComponent } from './Components/error-page/error-page.component';
import { ProfileComponent } from './Components/profile/profile.component';
import { ForgotPasswordComponent } from './Components/forgot-password/forgot-password.component';
import {AuthGuard} from './Shared/guard/auth.guard';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'forgotPassword', component: ForgotPasswordComponent},
  { path: 'home', component: HomeComponent, canActivate:[AuthGuard]},
  { path: 'messages', component: MessagesComponent,canActivate:[AuthGuard]},
  // { path: 'events', component: EventsComponent },
  // { path: 'groups', component: GroupsComponent },
  { path: 'settings', component: SettingsComponent,canActivate:[AuthGuard]},
  { path: 'profile', component: ProfileComponent,canActivate:[AuthGuard]},
  { path: '',   redirectTo: '/login', pathMatch: 'full' },
  { path: '**', component: ErrorPageComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
