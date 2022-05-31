import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
//icons
import { faHeart, faEllipsis, faBookmark, faComment, faShareFromSquare } from '@fortawesome/free-solid-svg-icons';
import { CommentService } from '../../services/comment.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  constructor(public CommentService: CommentService) { }

  ngOnInit(): void {
    this.getAllComments();
  }

  // Variables Used In Home Component
  public comment: any = {};
  public comments: any = [];
  public currentDate = new Date();

  // Back End Work
  public getCommentById(id: number){
    this.CommentService.getCommentById(id).subscribe(
      (response: any) => {
        this.comment = response.data;
        console.log(this.comment);
      },
      (error: HttpErrorResponse) => {
        console.log(error.message)
      }
    )
  }

  public onAddComment(commentForm: NgForm): void{
    this.CommentService.addComment(commentForm.value).subscribe(
      (response: any) => {
        console.log(response);
      },
      (error: HttpErrorResponse) => {
        console.log(error.message)
      }
    )
  }

  public onEditComment(commentForm: NgForm): void{
    this.CommentService.updateComment(commentForm.value).subscribe(
      (response: any) => {
        console.log(response);
      },
      (error: HttpErrorResponse) => {
        console.log(error.message)
      }
    )
  }

  // Get All Comments
  public getAllComments(): void{
    this.CommentService.getAllComments().subscribe(
      (response: any) => {
        this.comments.push(response.data);
      },
      (error: HttpErrorResponse) => {
        console.log(error.message)
      }
    )
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
