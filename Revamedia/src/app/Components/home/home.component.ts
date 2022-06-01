import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
//icons
import { faHeart, faEllipsis, faBookmark, faComment, faShareFromSquare } from '@fortawesome/free-solid-svg-icons';
import { GiphyServiceService } from 'src/app/services/giphy-service.service';
import { CommentService } from '../../services/comment.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  constructor(public CommentService: CommentService, public gifService: GiphyServiceService) { }

  ngOnInit(): void {
    // this.getAllComments();
    this.getGifs('funny');
  }

  // Variables Used In Home Component
  public comment: any = {};
  public comments: any = [];
  public currentDate = new Date();
  public post: any;

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
        this.getCommentById(response.data.commentId);
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

  public fileName(event: any, target: string): void {
    var fileNames: any[] = event.target.files;
    const file = document.getElementById(`${target}-fileName`);
    for(let i = 0; i< fileNames.length; i++){
      file!.textContent = fileNames[i].name;
    }
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

  public openModal(modalType: string, post: any){
    // Screen
    const screen = document.getElementById('screen');
    screen?.classList.add('openScreen');
    // Form
    const form = document.getElementById(`${modalType}-post-modal`);
    form?.classList.add('openModal');
    if(modalType === "edit"){
      this.postsOptionsClicked = false;
    }
    if(modalType === "delete"){
      this.postsOptionsClicked = false;
    }
  }

  public closeModal(modalType: string){
    // Screen
    const screen = document.getElementById('screen');
    screen?.classList.remove('openScreen');
    // Form
    const form = document.getElementById(`${modalType}-post-modal`);
    form?.classList.remove('openModal');
  }

  // gifs
  public gifs: any[] = [];
  public getGifs(search: string): void {
    this.gifService.getGIFS(search).subscribe(
      (response: any) => {
        this.gifs = response.data;
        // console.log(this.gifs);
      },
      (error: HttpErrorResponse) => {
        console.log(error.message)
      }
    )
  }
  public searchGiphy(){
    const search = document.getElementById('giphySearch') as HTMLInputElement;
    let query = search?.value;
    let cleanQuery = query.trim();
    let cleanQuery2 = cleanQuery.replace(" ", "+");
    this.getGifs(cleanQuery2);
    if(query === ""){
      this.getGifs("Code");
    }
  }
  public selectedGiphy = "";
  public selectGiphy(url: any){
    this.selectedGiphy = url;
  }
}
