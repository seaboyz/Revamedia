package com.revature.Revamedia.beans.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.revature.Revamedia.beans.services.AuthService;
import com.revature.Revamedia.beans.services.JsonWebToken;
import com.revature.Revamedia.dtos.AuthDto;
import com.revature.Revamedia.dtos.UserRegisterDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AuthController.class)
public class AuthControllerTest {

    private MockMvc mockMvc;


    @MockBean
    private AuthService authServiceMock;


    public AuthControllerTest(@Autowired MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }
    @Test
    public void loginTest(){
        AuthDto authDto= new AuthDto("shady", "Password1!");
        HttpHeaders headers= new HttpHeaders();
        headers.add("Set-Cookie", "user_session=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJKc29uIjoie1widXNlcklkXCI6NCxcInVzZXJuYW1lXCI6XCJzaGFkeVwifSJ9.LSzPbhNAALEFrBWZPpf8KGvREormRNt3tXFkGMTvnU3-MPHw76JD5cmreZJMYaSwNt7H6YJlALCFAWobPAKWbw; Max-Age=86400; Path=/;");
        when(authServiceMock.login(authDto)).thenReturn(ResponseEntity.ok().headers(headers).build());
        ObjectMapper mapper = new ObjectMapper();
        try {
            String content = mapper.writeValueAsString(authDto);
            this.mockMvc.perform(post("/auth/login").contentType(MediaType.APPLICATION_JSON).content(content)).andExpect(status().isOk());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    public void registerTest(){
        UserRegisterDto userRegisterDto = new UserRegisterDto("kenn", "Password1!", "kenn", "str", "email@email.com");
        when(authServiceMock.register(userRegisterDto)).thenReturn(ResponseEntity.ok().build());
        ObjectMapper mapper = new ObjectMapper();
        try {
            String content = mapper.writeValueAsString(userRegisterDto);
            this.mockMvc.perform(post("/auth/register").contentType(MediaType.APPLICATION_JSON).content(content)).andExpect(status().isOk());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void registerFailTest(){
        UserRegisterDto userRegisterDto = new UserRegisterDto("kenn", "password", "kenn", "str", "email@email.com");
        when(authServiceMock.register(userRegisterDto)).thenReturn(ResponseEntity.ok().build());
        ObjectMapper mapper = new ObjectMapper();
        try {
            String content = mapper.writeValueAsString(userRegisterDto);
            this.mockMvc.perform(post("/auth/register").contentType(MediaType.APPLICATION_JSON).content(content)).andExpect(status().isBadRequest());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
