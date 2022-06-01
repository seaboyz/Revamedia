package com.revature.Revamedia.beans.controllers;

import com.revature.Revamedia.beans.services.UserPostsService;
import com.revature.Revamedia.entities.User;
import com.revature.Revamedia.entities.UserPosts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/post" , produces = "application/json")
public class UserPostsController {
    //Initialize Services
    private final UserPostsService userPostsService;

    //Autowire Services
    @Autowired
    public UserPostsController(UserPostsService userPostsService) {
        this.userPostsService = userPostsService;
    }

    //Controller Methods
    @GetMapping("/getAllPosts")
    @ResponseStatus(HttpStatus.OK)
    public List<UserPosts> getAllPosts(){
//        System.out.println("Hello world");
        return userPostsService.getAllPosts();
    }

    //TODO: Include exception handling if post does not exist.
    @GetMapping("/getPostByPostId/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserPosts getPostByPostId(@PathVariable Integer id){
        return userPostsService.getPostById(id);
    }

    @PostMapping("/addPost")
    @ResponseStatus(HttpStatus.OK)
    public UserPosts createPost(@RequestBody UserPosts post){
        return userPostsService.save(post);
    }

//    @PutMapping
//    @ResponseStatus(HttpStatus.OK)
//    public UserPosts updatePost(@RequestBody UserPosts post){
//        return UserPostsService.update(post);
//    }

//    @DeleteMapping("/deleteById/")
}
