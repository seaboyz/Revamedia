package com.revature.Revamedia.beans.controllers;

import com.revature.Revamedia.beans.services.UserCommentsService;
import com.revature.Revamedia.entities.UserComments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

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
    public UserComments getById(HttpServletResponse response, @PathVariable("id") int id) {

        return this.userCommentsService.getCommentById(id);;
    }

}
