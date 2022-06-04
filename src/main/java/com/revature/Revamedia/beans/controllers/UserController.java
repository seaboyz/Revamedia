package com.revature.Revamedia.beans.controllers;

import com.revature.Revamedia.beans.services.UserService;
import com.revature.Revamedia.dtos.AuthDto;
import com.revature.Revamedia.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
