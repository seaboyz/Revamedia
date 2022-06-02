/**
 *  Author(s): @Brandon Le, @Tony Henderson
 *  Contributor(s):@Stan Savelev, @William Bjerke
 *  Purpose: CRUD functionality for user posts
 */
package com.revature.Revamedia.beans.controllers;

import com.revature.Revamedia.beans.services.UserPostsService;
import com.revature.Revamedia.beans.services.UserService;
import com.revature.Revamedia.dtos.UpdatePostLikesDto;
import com.revature.Revamedia.entities.User;
import com.revature.Revamedia.entities.UserPosts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping(value = "/posts", produces = "application/json")
public class UserPostsController {

    private final UserPostsService userPostsService;
    private final UserService userService;

    @Autowired
    public UserPostsController(UserPostsService userPostsService, UserService userService) {
        this.userPostsService = userPostsService;
        this.userService = userService;
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

    @PostMapping(value="/addPost")
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
    @PutMapping("/likes")
    public ResponseEntity<UserPosts> updatePostLikes(@RequestBody UpdatePostLikesDto dto) {

        try {
            UserPosts result = userPostsService.updatePostLikes(dto);
            return new ResponseEntity<>(result, HttpStatus.OK);

        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        //
        // UserPosts result = userPostsService.updatePostLikes(dto);
        // if (result == null)
        // return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        // else
        // return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @GetMapping("/postsByUser/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<UserPosts> getPostsByUserId(@PathVariable Integer id) {
        return userPostsService.getPostsByUser(id);
    }
}
