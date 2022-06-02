package com.revature.Revamedia.beans.controllers;

import com.revature.Revamedia.beans.controllers.AuthController;
import com.revature.Revamedia.beans.services.AuthService;
import com.revature.Revamedia.dtos.UserRegisterDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@WebMvcTest(AuthController.class)
public class AuthControllerTest {

    MockMvc mockMvc;

    @MockBean
    AuthService authServiceMock;

    public AuthControllerTest(@Autowired MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @BeforeEach
    public void beforeEach() {

    }

    @Test
    public void registerCallsAuthServicePassingBody() throws Exception {

        MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();

        UserRegisterDto registerDtoToPassIn = new UserRegisterDto("us3rn4me44", "p4ssw0rd", "John", "Doe", "jDoe@email.com");
        when(authServiceMock.register(registerDtoToPassIn)).thenReturn(ResponseEntity.ok().build());

        MvcResult result = mockMvc.perform(post("/auth/register")).andDo(print()).andExpect(status().isOk()).andReturn();
    }

}
