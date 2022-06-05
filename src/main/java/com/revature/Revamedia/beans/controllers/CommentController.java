package com.revature.Revamedia.beans.controllers;

import com.revature.Revamedia.beans.services.UserCommentsService;
import com.revature.Revamedia.dtos.HttpResponseDto;
import com.revature.Revamedia.dtos.UserCommentsDto;
import com.revature.Revamedia.entities.UserComments;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    // Initialize Service
    private final UserCommentsService userCommentsService;

    @Autowired
    public CommentController(UserCommentsService userCommentsService) {
        this.userCommentsService = userCommentsService;
    }


    @GetMapping("/{id}")
    public HttpResponseDto getById(HttpServletResponse res, @PathVariable("id") int id) {
       UserComments comment = userCommentsService.getCommentById(id);
       UserCommentsDto commentsDto = new UserCommentsDto(comment.getOwnerId().getUserId(), comment.getPostId().getPostId(),
               comment.getCommentId(), comment.getMessage(), comment.getDateCreated(), comment.getGiphyUrl());
        System.out.println(comment.getCommentId());

        if(comment.getCommentId() != id) {
            res.setStatus(400);
            return new HttpResponseDto(400, "Failed to get comment.", commentsDto);
        } else {
            res.setStatus(200);
            return new HttpResponseDto(200, "Successfully retrieved comment.", commentsDto);
        }
    }


    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public HttpResponseDto getById(HttpServletResponse res) {
        List<UserComments> comments = userCommentsService.getAllComment();
        List<UserCommentsDto> dtoComments = new LinkedList<>();
        for (UserComments comment: comments) {
            UserCommentsDto commentsDto = new UserCommentsDto(comment.getOwnerId().getUserId(), comment.getPostId().getPostId(),
                    comment.getCommentId(), comment.getMessage(), comment.getDateCreated(), comment.getGiphyUrl());
            dtoComments.add(commentsDto);
        }
        System.out.println(comments);
        res.setStatus(200);
        return new HttpResponseDto(200, "Successfully retrieved all comments.", dtoComments);
    }



    @PostMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public HttpResponseDto saveComment(@RequestBody UserComments comment, HttpServletResponse res){
        UserComments newComment = userCommentsService.save(comment);
        if(comment.getMessage() != comment.getMessage()) {
            res.setStatus(400);
            return new HttpResponseDto(400, "Failed to save comment", comment);
        } else {
            res.setStatus(200);
            return new HttpResponseDto(200, "Successfully saved comment" + comment.getMessage(), newComment);
        }
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public HttpResponseDto updateById(@RequestBody UserCommentsDto updatedComment, HttpServletResponse res) {
        UserComments comment = userCommentsService.getCommentById(updatedComment.getComment_id());
        comment.setMessage(updatedComment.getMessage());
        userCommentsService.update(comment);

        if(comment.getMessage() != comment.getMessage()) {
            res.setStatus(400);
            return new HttpResponseDto(400, "Failed to update comment", comment);
        } else {
            res.setStatus(200);
            return new HttpResponseDto(200, "Successfully updated comment" + comment.getMessage(), comment);
        }
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public HttpResponseDto delete(@RequestBody UserComments comment, HttpServletResponse res){
        userCommentsService.delete(comment);
        res.setStatus(200);
        return new HttpResponseDto(200, "Comment successfully deleted.", comment);
    }
}

