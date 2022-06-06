import { Injectable } from '@angular/core';


import { Message } from "../../interfaces/message";

import { Observable } from "rxjs";



@Injectable({
  providedIn: 'root'
})
export class MessageService
{


  constructor()
  {

  }

  sendMessage(message: string)
  {
    console.log("sending message: ", message)
  }
}
