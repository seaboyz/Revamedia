package com.revature.Revamedia.beans.controllers;

import com.revature.Revamedia.beans.services.UserCommentsService;
import com.revature.Revamedia.dtos.HttpResponseDto;
import com.revature.Revamedia.entities.UserComments;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/comment")
public class CommentController {

    // Initialize Service
    private final UserCommentsService userCommentsService;

    public CommentController(UserCommentsService userCommentsService) {
        this.userCommentsService = userCommentsService;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public HttpResponseDto saveComment(@RequestBody UserComments comment, HttpServletResponse res){
        UserComments newComment = userCommentsService.save(comment);
        return new HttpResponseDto(200, "Successfully saved comment " + comment.getMessage(), comment);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public HttpResponseDto updateById(@RequestBody UserComments updatedComment, HttpServletResponse res) {
        UserComments comment = userCommentsService.update(updatedComment);

        if(comment.getMessage() != comment.getMessage()) {
            res.setStatus(400);
            return new HttpResponseDto(400, "Failed to update category", comment);
        } else {
            res.setStatus(200);
            return new HttpResponseDto(200, "Successfully updated category" + comment.getMessage(), comment);
        }
    }


}

