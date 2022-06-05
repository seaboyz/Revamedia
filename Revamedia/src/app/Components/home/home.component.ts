import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
//icons
import { faHeart, faEllipsis, faBookmark, faComment, faShareFromSquare, faFaceGrinStars,faFaceGrinTongueSquint } from '@fortawesome/free-solid-svg-icons';
import { CommentService } from 'src/app/Shared/services/user-comments-service/comment.service';
import { UserPostsService } from 'src/app/Shared/services/user-posts-service/user-posts.service';
import { HttpClient } from '@angular/common/http';
import { UserService } from 'src/app/Shared/services/user-service/user.service';
import { GiphyService } from 'src/app/Shared/services/giphy-service/giphy.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  postToLike: any = {
    userId: 1,
    postId: 1
  }

  public user: any;
  users: any[] = [];
  following: any[] = [];
  posts: any[] = [];
  followPosts: any[] = [];
  comments: any[] = [];

  public totalLikes: number = 0;

  constructor(public CommentService: CommentService, private userPostsService: UserPostsService, private http: HttpClient, public userService: UserService, public gifService: GiphyService) { }


  ngOnInit(): void {
    // this.getAllComments();
    this.getGifs('funny');
    this.getStickers('funny');
    this.userService.getCurrentUser().subscribe({
      next: response => {
        this.user = response;

        let f: any;
        this.posts = [];
        for(f of response.following) {
          this.posts.push(f.followedId.postsOwned);
        }
        this.posts = this.posts.flat();
        //b.date.getTime() - a.date.getTime();

      },
      error: err => {
        console.error(err);
      }
    });
  }


  // Variables Used In Home Component
  public comment: any = {};
  public currentDate = new Date();
  public post: any;

  // // Back End Work
  public onAddComment(commentForm: NgForm): void{
    this.CommentService.addComment(commentForm.value).subscribe(
      (response: any) => {
        this.comment = response.data;
        console.log(this.comment);
      },
      (error: HttpErrorResponse) => {
        console.log(error.message)
      }
    )
  }
  // // public onEditComment(commentForm: NgForm): void{
  // //   this.CommentService.updateComment(commentForm.value).subscribe(
  // //     (response: any) => {
  // //       console.log(response);
  // //     },
  // //     (error: HttpErrorResponse) => {
  // //       console.log(error.message)
  // //     }
  // //   )
  // // }

  // likePost(currentPost: any): void {

  //   this.userPostsService.updatePostLikes(this.postToLike).subscribe(
  //     (data) => {
  //       console.log(data.body.likes.length);
  //       this.totalLikes = data.body.likes.length;

  //       let p = {
  //         userId: 0,
  //         postId: 0,
  //       }
  //       p.postId = currentPost.postId;
  //       p.userId = this.user.userId;

  //       this.totalLikes = this.userService.userLikesPost(p);
  //     }
  //   )




  // }

  likePost(): void {

  // // Get All Comments
  // // public getAllComments(): void{
  // //   this.CommentService.getAllComments().subscribe(
  // //     (response: any) => {
  // //       this.comments.push(response.data);
  // //     },
  // //     (error: HttpErrorResponse) => {
  // //       console.log(error.message)
  // //     }
  // //   )
  // // }


  //    // get all comments for given post

  //       // console.log(data.body.comments);
  //       // console.log(data.body.comments[0]);
  //       // this.comments = data.body.comments;

  //       // for (var cur of this.comments) {
  //       //   console.log(cur);
  //       // }


  //   // get all users -> get all owned posts

  //   // this.userPostsService.getUsers().subscribe((data) => {

  //   //   this.users = data.body;
  //   //   console.log("all users:");
  //   //   console.log(this.users);

  //   //   // loop through all users
  //   //   for (var user of this.users) {
  //   //     // loop through all owned posts for each user
  //   //     for (var post of user.postsOwned)
  //   //       // add post to post array
  //   //       this.posts.push(post)
  //   //   }
  //   //   console.log("all posts:");
  //   //   console.log(this.posts);


  //   //   //for (var follow of this.currentuser.following)
  //   //       //getuser

  //   // });



  }

  // Front End Work
  public faHeart = faHeart; //icon
  public faEllipsis = faEllipsis; //icon
  public faBookmark = faBookmark; //icon
  public faComment = faComment; //icon
  public faShareFromSquare = faShareFromSquare; //icon
  public faFaceGrinStars = faFaceGrinStars; //icon
  public faFaceGrinTongueSquint = faFaceGrinTongueSquint; //icon

  // hide Comments
  public viewComments = false;
  public toggleHideComments(): void {
    this.viewComments = !this.viewComments;
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
    for (let i = 0; i < fileNames.length; i++) {
      file!.textContent = fileNames[i].name;
    }
  }

  // Add Reply
  public addReply = false;
  public openAddReply() {
    this.addReply = true;
  }
  public closeAddReply() {
    this.addReply = false;
  }

  // post optional
  public postsOptionsClicked = false;
  public togglePostsOptions() {
    this.postsOptionsClicked = !this.postsOptionsClicked;
  }

  //comment options
  // post optional
  public commentOptionsClicked = false;
  public toggleCommentsOptions() {
    this.commentOptionsClicked = !this.commentOptionsClicked;
  }

  public openModal(modalType: string, post: any) {
    // Screen
    const screen = document.getElementById('screen');
    screen?.classList.add('openScreen');
    // Form
    const form = document.getElementById(`${modalType}-${post}`);
    form?.classList.add('openModal');
    if (modalType === "edit") {
      this.postsOptionsClicked = false;
      this.commentOptionsClicked = false;
    }
    if (modalType === "delete") {
      this.postsOptionsClicked = false;
      this.commentOptionsClicked = false;
    }
  }

  public closeModal(modalType: string, post: any) {
    // Screen
    const screen = document.getElementById('screen');
    screen?.classList.remove('openScreen');
    // Form
    const form = document.getElementById(`${modalType}-${post}`);
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
      const search = document.getElementById(`giphy-search-comment`) as HTMLInputElement;
      let query = search?.value;
      let cleanQuery = query.trim();
      let cleanQuery2 = cleanQuery.replace(" ", "+");
      this.getGifs(cleanQuery2);
      this.getStickers(cleanQuery2);
      if(query === ""){
        this.getGifs("happy");
        this.getStickers("happy");
      }
    }

    public searchGiphyForReply(){
      const search = document.getElementById(`giphy-search-reply`) as HTMLInputElement;
      let query = search?.value;
      let cleanQuery = query.trim();
      let cleanQuery2 = cleanQuery.replace(" ", "+");
      this.getGifs(cleanQuery2);
      this.getStickers(cleanQuery2);
      if(query === ""){
        this.getGifs("happy");
        this.getStickers("happy");
      }
    }

    public selectedGiphy = "";
    public selectGiphy(url: any){
      this.selectedGiphy = url;
    }

    // stickers
    public stickers: any[] = [];
    public getStickers(search: string): void {
      this.gifService.getStickers(search).subscribe(
        (response: any) => {
          this.stickers = response.data;
          // console.log(this.stickers);
        },
        (error: HttpErrorResponse) => {
          console.log(error.message)
        }
      )
    }
}
