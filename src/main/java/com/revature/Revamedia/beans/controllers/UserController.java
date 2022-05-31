package com.revature.Revamedia.beans.controllers;


import com.revature.Revamedia.beans.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    //Initialize Services
    private final UserService userService;

    //Autowire Services
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Controller Methods

}
