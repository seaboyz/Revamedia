import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MessageService
{

  constructor() { }

  sendMessage(message: string)
  {
    console.log(message)
  }
}
