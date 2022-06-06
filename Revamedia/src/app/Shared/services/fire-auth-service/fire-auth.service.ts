import { Injectable } from '@angular/core';
import { FirebaseError } from "@angular/fire/app";
import { Auth, signInWithEmailAndPassword, signOut, createUserWithEmailAndPassword, UserCredential, User } from '@angular/fire/auth';
import { doc, getDoc, getFirestore, setDoc } from '@angular/fire/firestore'
import { BehaviorSubject } from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class FireAuthService
{
  private currentUser: any;

  public loggedIn = new BehaviorSubject<boolean>(this.checkLoginStatus());

  checkLoginStatus(): boolean
  {
    const user = localStorage.getItem('user');
    return user !== null ? true : false
  }

  constructor(private auth: Auth)
  {
    auth.onAuthStateChanged(async user =>
    {
      if (!user) {
        localStorage.setItem('user', 'null');
        return;
      };
      try {
        const userRef = await this.createUserProfileDocument(user, {});
        if (!userRef) return;
        const userSnap = await getDoc(userRef);
        if (!userSnap.exists()) return;
        this.currentUser = { id: userSnap.id, ...userSnap.data() }
        localStorage.setItem('user', JSON.stringify(this.currentUser))

      } catch (error) {
        console.log('fail to get user info', error);
      }

    })
  }

  login(email: string, password: string)
  {
    return signInWithEmailAndPassword(this.auth, email, password)
  }

  logout()
  {
    signOut(this.auth)
      .then(() =>
      {
        localStorage.removeItem('user')
      });
  }

  async register(email: string, username: string, firstName: string, lastName: string, password: string)
  {
    let userCredential: UserCredential;
    let user: User;

    try {
      userCredential = await createUserWithEmailAndPassword(this.auth, email, password);
      user = userCredential.user;
    } catch (error) {
      throw (error);
    }

    const displayName = `${firstName} ${lastName}`;

    return await this.createUserProfileDocument(user, { username, displayName })


  }

  async createUserProfileDocument(user: User, additionalData: any)
  {
    if (!user) return;
    const db = getFirestore();
    const userRef = doc(db, 'users', user.uid);
    const userSnap = await getDoc(userRef);

    if (!userSnap.exists()) {
      const { displayName, email } = user;
      const createdAt = new Date();
      try {
        await setDoc(userRef, { displayName, email, createdAt, ...additionalData })
      } catch (error) {
        console.log('error creating user')
      }
    }

    return userRef;

  }



}
