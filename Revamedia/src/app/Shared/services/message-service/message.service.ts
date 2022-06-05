import { Injectable } from '@angular/core';


import { Message } from "../../interfaces/message";
import { AngularFirestore, AngularFirestoreCollection } from '@angular/fire/compat/firestore';
import { AngularFireAuth } from '@angular/fire/compat/auth';

import { Observable } from "rxjs";



@Injectable({
  providedIn: 'root'
})
export class MessageService
{
  private messagesCollection: AngularFirestoreCollection<Message>;
  messages: Observable<Message[]>;

  constructor(private afs: AngularFirestore, private auth: AngularFireAuth)
  {
    this.messagesCollection = afs.collection<Message>('messages');
    this.messages = this.messagesCollection.valueChanges();
  }

  sendMessage(message: string)
  {
    // const timestamp = this.getTimeStramp();
    // const email = this.user.email;
    // this.messages = this.getMessages();
    // this.messages.push({
    //   message: message,
    //   timeSent: timestamp,
    //   username: this.userName,
    //   email: email
    // })
  }
}
