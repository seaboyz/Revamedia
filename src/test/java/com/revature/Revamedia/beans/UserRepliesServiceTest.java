package com.revature.Revamedia.beans;

import com.revature.Revamedia.beans.repositories.UserRepliesRepository;
import com.revature.Revamedia.beans.services.UserRepliesService;
import com.revature.Revamedia.entities.User;
import com.revature.Revamedia.entities.UserComments;
import com.revature.Revamedia.entities.UserPosts;
import com.revature.Revamedia.entities.UserReplies;
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
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserRepliesServiceTest {

    @MockBean
    UserRepliesRepository userRepliesRepositoryMock;

    User USER_1;
    UserPosts POST_1;
    UserComments COMMENT_1;
    UserComments COMMENT_2;
    UserReplies REPLY_1;
    UserReplies REPLY_2;
    UserReplies REPLY_3;
    UserReplies REPLY_4;

    @BeforeEach
    public void beforeEach() {

        USER_1 = new User(1, "test", "test@aol.com", "pass", "test", "name", null, null, null, null, null, null, null, null, null, null);
        POST_1 = new UserPosts(1, USER_1, null, "test message", null, null, null, null, null, null);
        COMMENT_1 = new UserComments(1, USER_1, POST_1, null, "test comment", null);
        COMMENT_2 = new UserComments(2, USER_1, POST_1, null, "test comment number 2", null);

    }

    @Test
    @DisplayName("Test the reply is retrieved correctly by its ID")
    public void getReplyByIdSuccesfully(@Autowired UserRepliesService userRepliesService){

        UserReplies reply = new UserReplies();
        reply.setReplyId(44);
        reply.setMessage("The test reply");

        when(userRepliesRepositoryMock.getById(44)).thenReturn(reply);

        UserReplies searchedReply = userRepliesService.getReplyById(44);

        assertEquals(reply, searchedReply);
    }

    // test if reply can be created
    @Test
    @DisplayName("Test if a reply is created")
    public void replyGetsReturnedAfterCreation(@Autowired UserRepliesService userRepliesService){
        
    }




}
