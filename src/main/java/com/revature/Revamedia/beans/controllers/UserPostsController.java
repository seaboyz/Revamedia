package com.revature.Revamedia.beans.controllers;

import com.revature.Revamedia.beans.services.UserPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserPostsController {

    private final UserPostsService userPostsService;

    @Autowired
    public UserPostsController(UserPostsService userPostsService){
        this.userPostsService = userPostsService;
    }

}
