import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-message-input',
  templateUrl: './message-input.component.html',
  styleUrls: ['./message-input.component.scss']
})
export class MessageInputComponent implements OnInit
{

  message = "";

  constructor() { }

  ngOnInit(): void
  {
  }

  handleSubmit(event: Event)
  {
    console.log(event)
  }

  send()
  {
    console.log("send!")
  }

}
