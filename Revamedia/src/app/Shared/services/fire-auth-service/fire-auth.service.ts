import { Injectable } from '@angular/core';
import { Auth, signInWithEmailAndPassword, signOut, createUserWithEmailAndPassword } from '@angular/fire/auth';
import { NgForm } from "@angular/forms";

@Injectable({
  providedIn: 'root'
})
export class FireAuthService
{

  constructor(private auth: Auth) { }

  login(email: string, password: string)
  {

    return signInWithEmailAndPassword(this.auth, email, password);
  }

  logout()
  {
    signOut(this.auth);
  }

  register(email: string, password: string)
  {
    return createUserWithEmailAndPassword(this.auth, email, password)
  }



}
