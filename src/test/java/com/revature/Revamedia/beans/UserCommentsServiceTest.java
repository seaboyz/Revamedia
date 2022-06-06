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

import java.util.ArrayList;
import java.util.List;
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
    UserComments COMMENT_2;


    @BeforeEach
    public void beforeEach() {


        USER_1 = new User(1, "test", "test@aol.com", "pass", "test", "name", null, null, null, null, null, null, null, null, null, null, null);
        POST_1 = new UserPosts(1, USER_1, null, "test message", null, null, null, null, null, null);
        COMMENT_1 = new UserComments(1, USER_1, POST_1, null, "test comment", null, null);
        COMMENT_2 = new UserComments(2, USER_1, POST_1, null, "test comment number 2", null, null);

    }


    @Test
    @DisplayName("Test the comment is retrieved correctly by its ID")
    public void getCommentByIdSuccessfully(@Autowired UserCommentsService userCommentsService) {


        UserComments comment = new UserComments();
        comment.setCommentId(15);
        comment.setMessage("The Test Comment");

        //given(userCommentsRepository.findById(15)).willReturn(Optional.of(comment));

        when(userCommentsRepositoryMock.getById(15)).thenReturn(comment);

        UserComments searchedComment = userCommentsService.getCommentById(15);

        assertEquals(comment, searchedComment);
    }

    @Test
    @DisplayName("Test that all comments are retrieved")
    public void getAllCommentsSuccessfully(@Autowired UserCommentsService userCommentsService) {
        List<UserComments> commentList = new ArrayList<>();
        commentList.add(COMMENT_1);
        commentList.add(COMMENT_2);


        when(userCommentsRepositoryMock.findAll()).thenReturn(commentList);

        List<UserComments> returnedList = userCommentsService.getAllComment();

        assertEquals(commentList, returnedList);
        verify(userCommentsRepositoryMock, times(1)).findAll();

    }


    //test that comment gets created
    @Test
    public void commentGetsReturnedAfterCreation(@Autowired UserCommentsService userCommentsService) {

        UserComments commentToCreate = COMMENT_1;

        when(userCommentsRepositoryMock.save(any())).thenReturn(commentToCreate);
        UserComments comment = userCommentsService.save(commentToCreate);

        assertEquals(commentToCreate, comment);
    }

    @Test
    public void updateCallsRepoAndReturnsComment(@Autowired UserCommentsService userCommentsService) {
        UserComments commentToUpdate = COMMENT_1;
        when(userCommentsRepositoryMock.save(commentToUpdate)).thenReturn(commentToUpdate);

        UserComments updatedComment = userCommentsService.save(commentToUpdate);
        assertEquals(commentToUpdate, updatedComment);
        verify(userCommentsRepositoryMock, times(1)).save(commentToUpdate);
    }

    @Test
    @DisplayName("Test that a comment is deleted")
    void delete(@Autowired UserCommentsService userCommentsService) {
        UserComments userComments = new UserComments(2, USER_1, POST_1, null,
                "test comment number 2", null, null);

        userCommentsService.delete(userComments);
        verify(userCommentsRepositoryMock, times(1)).delete(userComments);
    }
}
