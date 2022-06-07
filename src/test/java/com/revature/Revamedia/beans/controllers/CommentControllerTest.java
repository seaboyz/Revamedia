package com.revature.Revamedia.beans.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.revature.Revamedia.beans.services.UserCommentsService;
import com.revature.Revamedia.entities.UserComments;

/**
* @Author: Qiang Gao
*/
@WebMvcTest(CommentController.class)
public class CommentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserCommentsService userCommentsService;

    @Test
    public void testGetById() throws Exception {
        UserComments comment = new UserComments();
        comment.setCommentId(1);

        when(userCommentsService.getCommentById(1)).thenReturn(comment);

        when(userCommentsService.getCommentById(2)).thenThrow(EntityNotFoundException.class);

        this.mockMvc.perform(get("/comment/1")).andExpect(status().isOk());

        // ? should thorw exception or return null
        this.mockMvc.perform(get("/comment/2")).andExpect(status().isNotFound());

    }

    @Test
    public void testGetAll() throws Exception {
        List<UserComments> comments = new ArrayList<>();

        when(userCommentsService.getAllComment()).thenReturn(comments);

        this.mockMvc.perform(get("/comment/all")).andExpect(status().isOk());
    }

    @Test
    public void testAdd() throws Exception {
        UserComments comment = new UserComments();
        comment.setMessage("Test");

        UserComments newComment = new UserComments();
        newComment.setMessage("Test");
        newComment.setCommentId(1);

        when(userCommentsService.save(comment)).thenReturn(newComment);

        this.mockMvc.perform(post("/comment/add")).andExpect(status().isOk());
    }

    @Test
    public void testUpdate() throws Exception {
        UserComments comment = new UserComments();
        comment.setMessage("Test");
        comment.setCommentId(1);

        UserComments updatedComment = new UserComments();
        updatedComment.setMessage("Test");
        updatedComment.setCommentId(1);

        when(userCommentsService.save(comment)).thenReturn(updatedComment);

        this.mockMvc.perform(put("/comment/update")).andExpect(status().isOk());
    }

}
