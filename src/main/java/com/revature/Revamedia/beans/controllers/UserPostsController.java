/**
 * Author(s): @Brandon Le, @Arun Mohan, @Anthony Pilletti
 * Contributor(s): @Stan Savelev, @William Bjerke
 * Purpose: Controller class to define UserPost backend CRUD functions
 */

package com.revature.Revamedia.beans.controllers;

import com.revature.Revamedia.beans.services.UserPostsService;
import com.revature.Revamedia.beans.services.UserService;
import com.revature.Revamedia.dtos.UpdatePostLikesDto;
import com.revature.Revamedia.entities.UserPosts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;


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
    /**
     * Update the like status of a post by a given user
     * @param dto UpdatePostLikes dto from the HTTP Request Body containing User and Post ids
     * @return ResponseEntity containing response status and updated UserPost
     */
    @PutMapping("/likes")
    public ResponseEntity<UserPosts> updatePostLikes(@RequestBody UpdatePostLikesDto dto) {

        try {
            UserPosts result = userPostsService.updatePostLikes(dto);
            return new ResponseEntity<>(result, HttpStatus.OK);

        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


    /**
     * Get all posts from the database
     * @return List of all UserPosts
     */
    @GetMapping("/allPosts")
    @ResponseStatus(HttpStatus.OK)
    public List<UserPosts> getAllPosts() {
        return userPostsService.getAllPosts();
    }

    /**
     * Get all posts made by the given user
     * @param id UserId as a path variable
     * @return List of UserPosts owned by user
     */
    @GetMapping("/postsByUser/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<UserPosts> getPostsByUserId(@PathVariable Integer id) {
        return userPostsService.getPostsByUser(id);
    }
}
