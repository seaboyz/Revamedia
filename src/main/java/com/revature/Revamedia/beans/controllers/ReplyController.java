package com.revature.Revamedia.beans.controllers;

import com.revature.Revamedia.beans.services.UserRepliesService;
import com.revature.Revamedia.dtos.HttpResponseDto;
import com.revature.Revamedia.entities.UserPosts;
import com.revature.Revamedia.entities.UserReplies;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/reply")
public class ReplyController {

    // Initialize Service
    private final UserRepliesService userRepliesService;

    @Autowired
    public ReplyController(UserRepliesService userRepliesService) {
        this.userRepliesService = userRepliesService;
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
    public ResponseEntity<UserReplies> saveReply(@RequestBody UserReplies reply){
        return new ResponseEntity<>(userRepliesService.save(reply),HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<UserReplies> update(@RequestBody UserReplies updateReply) {
        return ResponseEntity.ok(userRepliesService.update(updateReply));
    }

    @DeleteMapping("/delete")
    public HttpResponseDto delete(@RequestBody UserReplies reply, HttpServletResponse res){
        userRepliesService.delete(reply);
        res.setStatus(200);
        return new HttpResponseDto(200, "Reply successfully deleted.", reply);
    }

}
