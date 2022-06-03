package com.revature.Revamedia.beans.controllers;

import com.revature.Revamedia.beans.services.UserCommentsService;
import com.revature.Revamedia.dtos.HttpResponseDto;
import com.revature.Revamedia.entities.UserComments;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
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
        System.out.println(comment.getCommentId());
        if(comment.getCommentId() != id) {
            res.setStatus(400);
            return new HttpResponseDto(400, "Failed to get comment.", comment);
        } else {
            res.setStatus(200);
            return new HttpResponseDto(200, "Successfully retrieved comment.", comment);
        }
    }


    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public HttpResponseDto getById(HttpServletResponse res) {
        List<UserComments> comments = userCommentsService.getAllComment();
        res.setStatus(200);
        return new HttpResponseDto(200, "Successfully retrieved all comments.", comments);
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
    public HttpResponseDto updateById(@RequestBody UserComments updatedComment, HttpServletResponse res) {
        UserComments comment = userCommentsService.update(updatedComment);

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

