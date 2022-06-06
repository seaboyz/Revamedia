import { Injectable } from '@angular/core';
import { FirebaseError } from "@angular/fire/app";
import { Auth, signInWithEmailAndPassword, signOut, createUserWithEmailAndPassword, UserCredential, User, AdditionalUserInfo } from '@angular/fire/auth';
import { doc, getDoc, getFirestore, setDoc } from '@angular/fire/firestore'

@Injectable({
  providedIn: 'root'
})
export class FireAuthService
{

  constructor(private auth: Auth) { }

  login(email: string, password: string)
  {

    signInWithEmailAndPassword(this.auth, email, password)
      .then(console.log);
  }

  logout()
  {
    signOut(this.auth);
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
