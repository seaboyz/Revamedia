package com.revature.Revamedia.beans.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.Revamedia.beans.services.UserService;
import com.revature.Revamedia.dtos.ViewAllUserDto;
import com.revature.Revamedia.entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @Author: Chenxi Zhu
 */

@WebMvcTest(UserController.class)
public class UserControllerTest {
    private final MockMvc mockMvc;

    @MockBean
    private UserService userServiceMock;

    public UserControllerTest(@Autowired MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    public void getAllUsersTest() {
        //arrange
        //ViewAllUserDto viewAllUserDto = new ViewAllUserDto();
        List<User> users = new ArrayList<>();
        HttpHeaders httpHeaders = new HttpHeaders();
        //httpHeaders.add("Set-Cookie", "user_session=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJKc29uIjoie1widXNlcklkXCI6NCxcInVzZXJuYW1lXCI6XCJzaGFkeVwifSJ9.LSzPbhNAALEFrBWZPpf8KGvREormRNt3tXFkGMTvnU3-MPHw76JD5cmreZJMYaSwNt7H6YJlALCFAWobPAKWbw; Max-Age=86400; Path=/;");

        // this part solves following casting problem
        //org.springframework.http.ResponseEntity cannot be cast to class java.util.List
        ResponseEntity<List<User>> responseEntity = ResponseEntity.ok().headers(httpHeaders).build();
        List<User> returnedUsers = responseEntity.getBody();
        //-----------------------------------------------------------
        when(userServiceMock.getAllUsers()).thenReturn((returnedUsers));
        ObjectMapper mapper = new ObjectMapper();
        try {
            //act
            String content = mapper.writeValueAsString(users);
            this.mockMvc.perform(get("/user/allUsers").contentType(MediaType.APPLICATION_JSON).content(content)).andExpect(status().isOk());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void getUserByIdTest() throws Exception {
        //arrange
        /*
        Integer id = 1;
        HttpHeaders httpHeaders = new HttpHeaders();
        ResponseEntity<User> responseEntity = ResponseEntity.ok().headers(httpHeaders).build();
        User user = responseEntity.getBody();
        when(userServiceMock.getUserById(id)).thenReturn(user);
        ObjectMapper mapper = new ObjectMapper();
        //act
        String content = mapper.writeValueAsString(id);
        this.mockMvc.perform(post("/user/{id}").contentType(MediaType.APPLICATION_JSON).content(content)).andExpect(status().isOk());
        //assert


         */

    }
}
