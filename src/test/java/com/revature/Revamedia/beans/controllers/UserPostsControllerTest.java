/**
 * Author(s): @Brandon Le, @Arun Mohan, @Anthony Pilletti
 * Contributor(s): @Stan Savelev, @William Bjerke
 * Purpose: Test class to test the functions in the UserPostsController.
 */
package com.revature.Revamedia.beans.controllers;

import com.revature.Revamedia.beans.services.UserPostsService;
import com.revature.Revamedia.beans.services.UserService;
import com.revature.Revamedia.dtos.UpdatePostLikesDto;
import com.revature.Revamedia.entities.User;
import com.revature.Revamedia.entities.UserPosts;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.persistence.EntityNotFoundException;

import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserPostsControllerTest {

    User user;
    UserPosts userPosts;


    @MockBean
    UserPostsService userPostsService;

    @MockBean
    UserService userService;

    @BeforeEach
    public void beforeEach(){
        user = new User();
        user.setUserId(1);

        userPosts = new UserPosts();
        userPosts.setPostId(1);

    }

    @Test
    public void updatePostLikesSuccess(@Autowired UserPostsController userPostsController){
        UpdatePostLikesDto dto = new UpdatePostLikesDto(user.getUserId(), userPosts.getPostId());
        ResponseEntity<UserPosts> responseEntity = new ResponseEntity<>(userPosts, HttpStatus.OK);

        when(userPostsService.updatePostLikes(dto)).thenReturn(userPosts);

        ResponseEntity returnedResponse = userPostsController.updatePostLikes(dto);

        Assertions.assertEquals(responseEntity, returnedResponse);
        verify(userPostsService, times(1)).updatePostLikes(dto);
    }

    @Test
    public void updatePostLikesFailed(@Autowired UserPostsController userPostsController){
        UpdatePostLikesDto dto = new UpdatePostLikesDto(user.getUserId(), 2);
        ResponseEntity<UserPosts> responseEntity = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        when(userPostsService.updatePostLikes(dto)).thenThrow(new EntityNotFoundException("No post exists"));

        ResponseEntity returnedResponse = userPostsController.updatePostLikes(dto);

        Assertions.assertEquals(responseEntity, returnedResponse);
        verify(userPostsService, times(1)).updatePostLikes(dto);
    }

    @Test
    public void getPostsByUserIdSuccess(@Autowired UserPostsController userPostsController){
        //to do later
    }
}
