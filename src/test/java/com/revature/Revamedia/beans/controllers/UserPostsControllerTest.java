package com.revature.Revamedia.beans.controllers;

import com.revature.Revamedia.beans.services.UserPostsService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

public class UserPostsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserPostsService userPostsService;

    @Test
    void getAllPosts() {
    }

    @Test
    void getPostByPostId() {
    }

    @Test
    void createPostTest() {
    }

    @Test
    void updatePost() {
    }

    @Test
    void deletePost() {
    }
}