import { Component, OnInit } from '@angular/core';
//icons
import { faHeart, faEllipsis, faBookmark, faComment, faShareFromSquare } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  //icons
  public faHeart = faHeart;
  public faEllipsis = faEllipsis;
  public faBookmark = faBookmark;
  public faComment = faComment;
  public faShareFromSquare = faShareFromSquare;

  constructor() { }

  ngOnInit(): void {
  }


  // hide Comments
  hideComments = true;
  public toggleHideComments() : void {
    this.hideComments = !this.hideComments;
  }

  // Add comment
  addComment = false;
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
  addReply = false;
  public openAddReply(){
    this.addReply = true;
  }
  public closeAddReply(){
    this.addReply = false;
  }
}
