package com.revature.Revamedia.beans.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.Revamedia.beans.services.UserService;
import com.revature.Revamedia.entities.User;

@RestController
@RequestMapping(value = "/user", produces = "application/json")
public class UserController {
    //Initialize Services
    private final UserService userService;

    //Autowire Services
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Controller Methods

    @GetMapping("/allUsers")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAll(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> user (@PathVariable Integer id){
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.ACCEPTED);
    }
}
