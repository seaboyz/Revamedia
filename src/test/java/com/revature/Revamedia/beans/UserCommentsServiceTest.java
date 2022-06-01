package com.revature.Revamedia.beans;

import com.revature.Revamedia.beans.services.UserCommentsService;
import com.revature.Revamedia.beans.repositories.UserCommentsRepository;
import com.revature.Revamedia.entities.User;
import com.revature.Revamedia.entities.UserComments;
import com.revature.Revamedia.entities.UserPosts;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserCommentsServiceTest {


    @MockBean
    UserCommentsRepository userCommentsRepositoryMock;

    User USER_1;
    UserPosts POST_1;
    UserComments COMMENT_1;

    @BeforeEach
    public void beforeEach() {


        USER_1 = new User(1, "test", "test@aol.com", "pass", "test", "name", null, null, null, null, null, null, null, null, null, null);
        POST_1 = new UserPosts(1, USER_1, null, "test message", null, null, 1, null, null, null);
        COMMENT_1 = new UserComments(1, USER_1, POST_1,null, "test comment", null);
    }


    @Test
    @DisplayName("Test the comment is retrieved correctly by its ID")
    public void getCommentByIdSuccessfully(@Autowired UserCommentsService userCommentsService){


        UserComments comment = new UserComments();
        comment.setCommentId(15);
        comment.setMessage("The Test Comment");

         //given(userCommentsRepository.findById(15)).willReturn(Optional.of(comment));

         when(userCommentsRepositoryMock.getById(15)).thenReturn(comment);

         UserComments searchedComment = userCommentsService.getCommentById(15);

         assertEquals(comment, searchedComment);


    }


    //test that comment gets created
    @Test
    public void commentGetsReturnedAfterCreation(@Autowired UserCommentsService userCommentsService) {

        UserComments commentToCreate = COMMENT_1;

        when(userCommentsRepositoryMock.save(any())).thenReturn(commentToCreate);
        UserComments comment = userCommentsService.save(commentToCreate);

        assertEquals(commentToCreate, comment);
    }
}
