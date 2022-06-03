import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }


  public data: any;
  // FRONT END WORK
  public openModal(modalType: string, data: any){
    // Screen
    const screen = document.getElementById('screen');
    screen?.classList.add('openScreen');
    // Modal
    const modal = document.getElementById(`${modalType}-modal`);
    modal?.classList.add('openModal');
  }

  public closeModal(modalType: string){
    // Screen
    const screen = document.getElementById('screen');
    screen?.classList.remove('openScreen');
    // Modal
    const modal = document.getElementById(`${modalType}-modal`);
    modal?.classList.remove('openModal');
  }
}
