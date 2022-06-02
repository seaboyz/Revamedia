package com.revature.Revmedia.beans.services;

import com.revature.Revamedia.beans.repositories.UserPostsRepository;
import com.revature.Revamedia.beans.services.UserPostsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserPostsServiceTest {

    @MockBean
    UserPostsRepository userPostsRepository;

    @Test
    public void updateLikesSuccess(@Autowired UserPostsService userPostsService){

    }
}
