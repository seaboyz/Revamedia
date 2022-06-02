package com.revature.Revmedia.beans.services;

import com.revature.Revamedia.beans.repositories.UserPostsRepository;
import com.revature.Revamedia.beans.repositories.UserRepository;
import com.revature.Revamedia.beans.services.UserPostsService;
import com.revature.Revamedia.dtos.UpdatePostLikesDto;
import com.revature.Revamedia.entities.User;
import com.revature.Revamedia.entities.UserPosts;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserPostsServiceTest {

    @MockBean
    UserPostsRepository userPostsRepository;

    @MockBean
    UserRepository userRepository;

    @Test
    public void likeAPostSuccess(@Autowired UserPostsService userPostsService){
        User user  = new User();
        user.setUserId(1);
        UserPosts post = new UserPosts();
        post.setPostId(1);
        UpdatePostLikesDto dto = new UpdatePostLikesDto(user.getUserId(), post.getPostId());
        user.getLikedPosts().add(post);
        post.getLikes().add(user);
        when(userPostsRepository.save(post)).thenReturn(post);
        when(userRepository.save(user)).thenReturn(user);


        UserPosts returnedPost = userPostsService.updatePostLikes(dto);

        Assertions.assertEquals(post, returnedPost);
    }
}