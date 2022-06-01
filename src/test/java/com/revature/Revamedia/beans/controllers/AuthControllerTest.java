package com.revature.Revamedia.beans.controllers;

import com.revature.Revamedia.beans.services.AuthService;
import com.revature.Revamedia.beans.services.JsonWebToken;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class AuthControllerTest {
    private AuthController authController;

    @MockBean
    private AuthService authService;

    @MockBean
    private JsonWebToken mockJwt;

    public AuthControllerTest(@Autowired AuthController authController){
        this.authController=authController;
    }
    @Test
    public void loginTest(){}


}
