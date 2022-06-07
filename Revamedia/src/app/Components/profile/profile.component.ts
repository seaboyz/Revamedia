import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { AnimationService } from 'src/app/Shared/services/animation/animation.service';
import { UserService } from 'src/app/Shared/services/user-service/user.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {

  constructor(private userService: UserService, public animationService: AnimationService) { }

  ngOnInit(): void {
    this.getCurrentUserData();
    this.openingAnimation();
  }

  // User data
  public user: any;
  // Posts
  public posts: any[] = [];
  // GET CURRENT USER
  // GET CURRENT USER
  public getCurrentUserData(){
    this.userService.getUser().subscribe(
      (response: any) => {
        this.user = response;
        console.log(this.user);
      },
      (error: HttpErrorResponse) => {
        console.log(error.message)
      }
    );
  }

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

  // ANIMATION
  public openingAnimation() {
    const anim = this.animationService;
    const main = '#profile';
    anim.fadeIn(main, 0.7, 0, 0.6);
  }
}
