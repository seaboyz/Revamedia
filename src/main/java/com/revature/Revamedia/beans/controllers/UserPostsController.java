/**
 *  Author(s): @Brandon Le, @Tony Henderson
 *  Contributor(s):@Stan Savelev, @William Bjerke
 *  Purpose: CRUD functionality for user posts
 */

package com.revature.Revamedia.beans.controllers;

import com.revature.Revamedia.beans.services.UserPostsService;
import com.revature.Revamedia.entities.User;
import com.revature.Revamedia.entities.UserPosts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;
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
    //Postman works!
    @GetMapping("/getAllPosts")
    @ResponseStatus(HttpStatus.OK)
    public List<UserPosts> getAllPosts(){
//        System.out.println("Hello world");
        return userPostsService.getAllPosts();
    }

    //TODO: Include exception handling if post does not exist.
    //TODO: Make more efficent(Make one call to database instead of two.
    //Postman works!
    @GetMapping("/getPostByPostId/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserPosts getPostByPostId(@PathVariable Integer id){
        if(userPostsService.getPostById(id) == null){
            throw new RuntimeException("Something went wrong");
        }
        return userPostsService.getPostById(id);
    }

    @PostMapping("/addPost")
    @ResponseStatus(HttpStatus.OK)
    public UserPosts createPost(@RequestBody UserPosts post){
        return userPostsService.save(post);
    }

    //Postman works
    @PutMapping("/updatePost")
    @ResponseStatus(HttpStatus.OK)
    public UserPosts updatePost(@RequestBody UserPosts post){
        return userPostsService.update(post);
    }

    @DeleteMapping("/deletePost")
    @ResponseStatus(HttpStatus.OK)
    public void deletePost(@RequestBody UserPosts post){
         userPostsService.delete(post);
    }
}
