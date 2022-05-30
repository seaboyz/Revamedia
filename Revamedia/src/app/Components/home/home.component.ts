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

}
