/**
 * Author(s): @Brandon Le, @Arun Mohan, @Anthony Pilletti
 * Contributor(s): @Stan Savelev, @William Bjerke
 * Purpose: Test class to test the functions in the UserPostsService.
 */
package com.revature.Revamedia.beans.services;

import com.revature.Revamedia.beans.repositories.UserPostsRepository;
import com.revature.Revamedia.beans.repositories.UserRepository;
import com.revature.Revamedia.dtos.UpdatePostLikesDto;
import com.revature.Revamedia.entities.User;
import com.revature.Revamedia.entities.UserPosts;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserPostsServiceTest {

    User user;
    UserPosts userPosts;

    @MockBean
    UserPostsRepository userPostsRepository;

    @MockBean
    UserRepository userRepository;

    @BeforeEach
    public void beforeEach(){
        user = new User();
        user.setUserId(1);
        user.setUsername("username");
        user.setPassword("password");

        userPosts = new UserPosts();
        userPosts.setPostId(1);


    }

    @Test
    public void unlikeAPostSuccess(@Autowired UserPostsService userPostsService){
        UpdatePostLikesDto dto = new UpdatePostLikesDto(user.getUserId(), userPosts.getPostId());

        Set<User> usersLiked = userPosts.getLikes();
        usersLiked.add(user);
        userPosts.setLikes(usersLiked);
        when(userPostsRepository.save(userPosts)).thenReturn(userPosts);
        userPostsRepository.save(userPosts);
        verify(userPostsRepository, times(1)).save(userPosts);


        List<UserPosts> postsLiked = user.getLikedPosts();
        postsLiked.add(userPosts);
        user.setLikedPosts(postsLiked);
        when(userRepository.save(user)).thenReturn(user);
        userRepository.save(user);
        verify(userRepository, times(1)).save(user);

        when(userRepository.getById(1)).thenReturn(user);
        when(userPostsRepository.getById(1)).thenReturn(userPosts);

        UserPosts returnedPost = userPostsService.updatePostLikes(dto);

        Assertions.assertEquals(userPosts, returnedPost);

    }

    @Test
    public void likeAPostSuccess(@Autowired UserPostsService userPostsService){
        UpdatePostLikesDto dto = new UpdatePostLikesDto(user.getUserId(), userPosts.getPostId());


        when(userPostsRepository.save(userPosts)).thenReturn(userPosts);
        userPostsRepository.save(userPosts);
        verify(userPostsRepository, times(1)).save(userPosts);


        when(userRepository.save(user)).thenReturn(user);
        userRepository.save(user);
        verify(userRepository, times(1)).save(user);

        when(userRepository.getById(1)).thenReturn(user);
        when(userPostsRepository.getById(1)).thenReturn(userPosts);

        UserPosts returnedPost = userPostsService.updatePostLikes(dto);

        Assertions.assertEquals(userPosts, returnedPost);

    }

    @Test
    public void saveSuccess(@Autowired UserPostsService userPostsService){
        when(userPostsRepository.save(userPosts)).thenReturn(userPosts);

        UserPosts returnedPosts = userPostsService.save(userPosts);

        Assertions.assertEquals(userPosts, returnedPosts);
        verify(userPostsRepository, times(1)).save(userPosts);
    }

    @Test
    public void getPostByIdSuccess(@Autowired UserPostsService userPostsService){
        when(userPostsRepository.getById(1)).thenReturn(userPosts);

        UserPosts returnedPosts = userPostsService.getPostById(1);

        Assertions.assertEquals(userPosts, returnedPosts);
        verify(userPostsRepository, times(1)).getById(1);
    }

    @Test
    public void getAllPostsSuccessfully(@Autowired UserPostsService userPostsService) {
        List<UserPosts>postList = new ArrayList<>();
        User user1 = new User();
        user1.setFirstName("Brandon");
        user1.setUsername("b1");
        user1.setPassword("password");

        User user2 = new User();
        user2.setFirstName("gio");
        user2.setUsername("g1");
        user2.setPassword("password");

        UserPosts post1 = new UserPosts();
        post1.setOwnerId(user1);

        UserPosts post2 = new UserPosts();
        post2.setOwnerId(user1);

        UserPosts post3 = new UserPosts();
        post3.setOwnerId(user2);
        postList.add(post1);

        postList.add(post2);

        when(userPostsRepository.findAll()).thenReturn(postList);

        List<UserPosts> returnedList = userPostsService.getAllPosts();

        assertEquals(postList, returnedList);
        verify(userPostsRepository, times(1)).findAll();
    }


    @Test
    void delete(@Autowired UserPostsService userPostsService) {
        User user1 = new User();
        user1.setFirstName("Brandon");
        user1.setUsername("b1");
        user1.setPassword("password");

        UserPosts post1 = new UserPosts();
        post1.setOwnerId(user1);

        userPostsService.delete(post1);
        verify(userPostsRepository, times(1)).delete(post1);
    }
}

