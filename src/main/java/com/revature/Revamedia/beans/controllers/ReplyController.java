package com.revature.Revamedia.beans.controllers;

import com.revature.Revamedia.beans.services.UserRepliesService;
import com.revature.Revamedia.dtos.HttpResponseDto;
import com.revature.Revamedia.entities.UserReplies;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    @ResponseStatus(HttpStatus.OK)
    public HttpResponseDto getReplyById(HttpServletResponse res, @PathVariable("id") int id){
        UserReplies reply = userRepliesService.getReplyById(id);

        if(reply.getReplyId() != id) {
            res.setStatus(400);
            return new HttpResponseDto(400, "Failed to get reply.", reply);
        } else {
            res.setStatus(200);
            return new HttpResponseDto(200, "Successfully retrieved reply.", reply);
        }
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public HttpResponseDto getAllReplies(HttpServletResponse res) {
        List<UserReplies> replies = userRepliesService.getAllReplies();
        res.setStatus(200);
        return new HttpResponseDto(200, "Successfully retrieved all replies.", replies);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public HttpResponseDto saveReply(@RequestBody UserReplies reply, HttpServletResponse res){
        UserReplies newReply = userRepliesService.save(reply);

        if(reply.getMessage() != reply.getMessage()){
            res.setStatus(400);
            return new HttpResponseDto(400, "Failed to save reply", reply);
        } else {
            res.setStatus(200);
            return new HttpResponseDto(200, "Successfully saved reply" + reply.getMessage(), newReply);
        }
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public HttpResponseDto updateById(@RequestBody UserReplies updatedReply, HttpServletResponse res) {
        UserReplies reply = userRepliesService.update(updatedReply);

        if(reply.getMessage() != reply.getMessage()) {
            res.setStatus(400);
            return new HttpResponseDto(400, "Failed to update reply", reply);
        } else {
            res.setStatus(200);
            return new HttpResponseDto(200, "Successfully updated reply: " + reply.getMessage(), reply);
        }
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public HttpResponseDto delete(@RequestBody UserReplies reply, HttpServletResponse res){
        userRepliesService.delete(reply);
        res.setStatus(200);
        return new HttpResponseDto(200, "Reply successfully deleted.", reply);
    }

}
