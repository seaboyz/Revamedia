package com.revature.Revamedia.beans.services;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class UserServiceTest {
    private UserService userService;

    @MockBean
    private JsonWebToken mockJwt;
}
