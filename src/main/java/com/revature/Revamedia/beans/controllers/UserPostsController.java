/**
 *  Author(s): @Brandon Le, @Tony Henderson
 *  Contributor(s):@Stan Savelev, @William Bjerke
 *  Purpose: CRUD functionality for user posts
 */

package com.revature.Revamedia.beans.controllers;

import com.revature.Revamedia.beans.services.UserPostsService;
import com.revature.Revamedia.entities.UserPosts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<UserPosts>> getAllPosts(){
        return ResponseEntity.ok(userPostsService.getAllPosts()) ;
    }

    //TODO: Include exception handling if post does not exist.

    @GetMapping("/{id}")
    public ResponseEntity<UserPosts> getPostByPostId(@PathVariable Integer id){
        return ResponseEntity.ok(userPostsService.getPostById(id));
    }

    @PostMapping("/addPost")
    public ResponseEntity<UserPosts> createPost(@RequestBody UserPosts post){
        return  new ResponseEntity<>(userPostsService.save(post),HttpStatus.CREATED);
    }


    @PutMapping("/updatePost")
    public ResponseEntity<UserPosts> updatePost(@RequestBody UserPosts post){
        return ResponseEntity.ok(userPostsService.update(post)) ;
    }

    @DeleteMapping("/deletePost")
    @ResponseStatus(HttpStatus.OK)
    public void deletePost(@RequestBody UserPosts post){
         userPostsService.delete(post);
    }
}
