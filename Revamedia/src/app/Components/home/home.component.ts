import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
//icons
import { faHeart, faEllipsis, faBookmark, faComment, faShareFromSquare } from '@fortawesome/free-solid-svg-icons';
import { CommentService } from '../../services/comment.service';
import { UserPostsService } from 'src/app/services/user-posts-service/user-posts.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  postToLike : any = {
    userId : 1,
    postId : 1
  }

  users : any[] = [];
  following : any[] = [];
  posts : any[] = [];
  followPosts : any[] = [];
  comments : any[] = [];

  public totalLikes : number = 0;

  constructor(public CommentService: CommentService,private userPostsService : UserPostsService, private http : HttpClient) { }

  ngOnInit(): void {
    this.getAllComments();
  }

  // Variables Used In Home Component
  public comment: any = {};
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

  likePost(): void {

    this.userPostsService.updatePostLikes(this.postToLike).subscribe((data) => {
        console.log(data.body.likes.length);
        this.totalLikes = data.body.likes.length;
        
    });



     // get all comments for given post
        
        // console.log(data.body.comments);
        // console.log(data.body.comments[0]);
        // this.comments = data.body.comments;

        // for (var cur of this.comments) {
        //   console.log(cur);
        // }


    // get all users -> get all owned posts

    // this.userPostsService.getUsers().subscribe((data) => {

    //   this.users = data.body;
    //   console.log("all users:");
    //   console.log(this.users);

    //   // loop through all users
    //   for (var user of this.users) {
    //     // loop through all owned posts for each user
    //     for (var post of user.postsOwned)
    //       // add post to post array
    //       this.posts.push(post)
    //   }
    //   console.log("all posts:");
    //   console.log(this.posts);


    //   //for (var follow of this.currentuser.following)
    //       //getuser

    // });




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
}
