package com.revature.Revamedia.beans.controllers;


import com.revature.Revamedia.beans.services.UserService;
import com.revature.Revamedia.dtos.AuthDto;
import com.revature.Revamedia.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

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
