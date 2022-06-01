package com.revature.Revamedia.beans.controllers;

import com.revature.Revamedia.beans.services.UserPostsService;
import com.revature.Revamedia.beans.services.UserService;
import com.revature.Revamedia.dtos.UpdatePostLikesDto;
import com.revature.Revamedia.entities.User;
import com.revature.Revamedia.entities.UserPosts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public UserPostsController(UserPostsService userPostsService, UserService userService){
        this.userPostsService = userPostsService;
        this.userService = userService;
    }

    @PutMapping("/likes")
    @ResponseStatus(HttpStatus.OK)
    public UserPosts updatePostLikes(@RequestBody UpdatePostLikesDto dto, HttpServletResponse res) {
        UserPosts post = userPostsService.getPostById(dto.getPostId());
        User user = userService.getUserById(dto.getUserId());
        if(user.getLikedPosts().contains(post)){
            Set<User> usersLiked = post.getLikes();
            usersLiked.remove(user);
            post.setLikes(usersLiked);
            userPostsService.update(post);
            List<UserPosts> postsLiked = user.getLikedPosts();
            postsLiked.remove(post);
            user.setLikedPosts(postsLiked);
            userService.update(user);
        } else {
            Set<User> usersLiked = post.getLikes();
            usersLiked.add(user);
            post.setLikes(usersLiked);
            userPostsService.update(post);
            List<UserPosts> postsLiked = user.getLikedPosts();
            postsLiked.add(post);
            user.setLikedPosts(postsLiked);
            userService.update(user);
        }


        //finish testing for entity -> finishing controller -> finish up service in front end

        res.setStatus(200);
        return post;
    }

    @GetMapping("/allPosts")
    @ResponseStatus(HttpStatus.OK)
    public List<UserPosts> getAllPosts(){
        return userPostsService.getAllPosts();
    }

    @GetMapping("/postsByUser/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<UserPosts> getPostsByUserId(@PathVariable Integer id){
        return userPostsService.getPostsByUser(id);
    }
}