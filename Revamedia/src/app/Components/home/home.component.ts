import { Component, OnInit } from '@angular/core';
//icons
import { faHeart, faEllipsis, faBookmark, faComment, faShareFromSquare } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  // Front End Work
  public faHeart = faHeart; //icon
  public faEllipsis = faEllipsis; //icon
  public faBookmark = faBookmark; //icon
  public faComment = faComment; //icon
  public faShareFromSquare = faShareFromSquare; //icon

  // hide Comments
  public hideComments = true;
  public toggleHideComments() : void {
    this.hideComments = !this.hideComments;
  }

  // Add comment
  public addComment = false;
  public openAddComment() {
    this.addComment = true;
  }
  public closeAddComment(): void {
    this.addComment = false;
  }

  public fileName(event: any): void {
    var fileName = event.target.files[0];
    const file = document.getElementById('file-name');
    file!.textContent = fileName.name;
  }

  // Add Reply
  public addReply = false;
  public openAddReply(){
    this.addReply = true;
  }
  public closeAddReply(){
    this.addReply = false;
  }

  // post optional
  public postsOptionsClicked = false;
  public togglePostsOptions(){
    this.postsOptionsClicked = !this.postsOptionsClicked;
  }

}
