package com.revature.Revamedia.beans;

import com.revature.Revamedia.beans.repositories.UserRepliesRepository;
import com.revature.Revamedia.entities.User;
import com.revature.Revamedia.entities.UserComments;
import com.revature.Revamedia.entities.UserPosts;
import com.revature.Revamedia.entities.UserReplies;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

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

}
