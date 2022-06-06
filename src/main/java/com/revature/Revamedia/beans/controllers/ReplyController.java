package com.revature.Revamedia.beans.controllers;

import com.revature.Revamedia.beans.services.UserCommentsService;
import com.revature.Revamedia.beans.services.UserRepliesService;
import com.revature.Revamedia.beans.services.UserService;
import com.revature.Revamedia.dtos.*;
import com.revature.Revamedia.entities.User;
import com.revature.Revamedia.entities.UserComments;
import com.revature.Revamedia.entities.UserPosts;
import com.revature.Revamedia.entities.UserReplies;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/reply")
public class ReplyController {

    // Initialize Service
    private final UserRepliesService userRepliesService;
    private final UserCommentsService userCommentsService;
    private final UserService userService;

    @Autowired
    public ReplyController(UserRepliesService userRepliesService, UserCommentsService userCommentsService, UserService userService) {
        this.userRepliesService = userRepliesService;
        this.userCommentsService = userCommentsService;
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserReplies> getReplyById(@PathVariable int id){
        try{
            UserReplies reply = userRepliesService.getReplyById(id);
            System.out.println(reply);
            return ResponseEntity.ok(reply);
        }catch(EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserReplies>> getAllReplies() {
      return ResponseEntity.ok(userRepliesService.getAllReplies());
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public HttpResponseDto saveReply(@RequestBody AddReplyDto dto, HttpServletResponse res){
        UserReplies newReply = new UserReplies();
        UserComments comment = new UserComments();
        comment = userCommentsService.getCommentById(dto.getComment_id());
        User user = new User();
        user = userService.getUserById(dto.getOwner_id());

        newReply.setMessage(dto.getMessage());
        newReply.setGiphyUrl(dto.getGiphyUrl());
        newReply.setDateCreated(new Timestamp(System.currentTimeMillis()));
        newReply.setOwnerId(user);
        newReply.setCommentId(comment);

        userRepliesService.save(newReply);

        if(newReply.getMessage() != dto.getMessage()) {
            res.setStatus(400);
            return new HttpResponseDto(400, "Failed to save comment", newReply);
        } else {
            res.setStatus(200);
            return new HttpResponseDto(200, "Successfully saved reply", newReply);
        }
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public HttpResponseDto updateById(@PathVariable Integer id, @RequestBody String message, HttpServletResponse res) {
        UserReplies reply = userRepliesService.getReplyById(id);
        reply.setMessage(message);
        userRepliesService.update(reply);

        if(reply.getMessage() != reply.getMessage()) {
            res.setStatus(400);
            return new HttpResponseDto(400, "Failed to update reply", reply);
        } else {
            res.setStatus(200);
            return new HttpResponseDto(200, "Successfully updated reply" + reply.getReplyId(), reply);
        }
    }

    @DeleteMapping("/delete/{id}")
    public HttpResponseDto delete(@PathVariable Integer id, HttpServletResponse res){
        UserReplies reply = userRepliesService.getReplyById(id);
        userRepliesService.delete(reply);
        res.setStatus(200);
        return new HttpResponseDto(200, "Reply successfully deleted.", reply);
    }

}
