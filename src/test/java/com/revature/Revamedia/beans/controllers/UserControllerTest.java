package com.revature.Revamedia.beans.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.Revamedia.beans.services.UserService;
import com.revature.Revamedia.dtos.ViewAllUserDto;
import com.revature.Revamedia.entities.User;

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
        ViewAllUserDto viewAllUserDto = new ViewAllUserDto();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Set-Cookie",
                "user_session=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJKc29uIjoie1widXNlcklkXCI6NCxcInVzZXJuYW1lXCI6XCJzaGFkeVwifSJ9.LSzPbhNAALEFrBWZPpf8KGvREormRNt3tXFkGMTvnU3-MPHw76JD5cmreZJMYaSwNt7H6YJlALCFAWobPAKWbw; Max-Age=86400; Path=/;");

        // this part solves following casting problem
        //org.springframework.http.ResponseEntity cannot be cast to class java.util.List
        ResponseEntity<List<User>> responseEntity = ResponseEntity.ok().headers(httpHeaders).build();
        List<User> users = responseEntity.getBody();
        //----------------
        when(userServiceMock.getAllUsers()).thenReturn((users));
        ObjectMapper mapper = new ObjectMapper();
        try {
            String content = mapper.writeValueAsString(viewAllUserDto);

            this.mockMvc.perform(get("/user/allUsers").contentType(MediaType.APPLICATION_JSON).content(content))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void getUserByIdTest() {
        //arrange

        //act

        //assert
    }

    /**
    * @Author: Qiang Gao
    */
    // Unit test for getAll()
    @Test
    public void testGetAll() throws Exception {
        List<User> users = new ArrayList<>();
        when(userServiceMock.getAllUsers()).thenReturn(users);

        this.mockMvc.perform(get("/user/allUsers")).andExpect(status().isOk());
    }

    /**
    * @Author: Qiang Gao
    */
    // Unit test for getUserById
    @Test
    public void testGetUserById() throws Exception {
        User user = new User();
        user.setUserId(1);

        when(userServiceMock.getUserById(1)).thenReturn(user);

        // ? should response with status 200 or 202
        this.mockMvc.perform(get("/user/1")).andExpect(status().isAccepted());
    }

}
