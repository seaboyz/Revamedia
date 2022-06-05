import { Component, OnInit } from '@angular/core';
import { MessageService } from "src/app/Shared/services/message-service/message.service";

@Component({
  selector: 'app-message-input',
  templateUrl: './message-input.component.html',
  styleUrls: ['./message-input.component.scss']
})
export class MessageInputComponent implements OnInit
{

  message = "";

  constructor(private messageSerive: MessageService) { }

  ngOnInit(): void
  {
  }

  handleSubmit(event: any)
  {
    if (event.keyCode === 13) {
      this.send();
    }
  }

  send()
  {
    this.messageSerive.sendMessage(this.message);
  }


}
