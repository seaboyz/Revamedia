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

    @GetMapping("/allPosts")
    @ResponseStatus(HttpStatus.OK)
    public List<UserPosts> getAllPosts() {
        return userPostsService.getAllPosts();
    }

    @GetMapping("/postsByUser/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<UserPosts> getPostsByUserId(@PathVariable Integer id) {
        return userPostsService.getPostsByUser(id);
    }
}
