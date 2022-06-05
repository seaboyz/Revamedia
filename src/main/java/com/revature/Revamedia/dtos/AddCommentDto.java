package com.revature.Revamedia.dtos;

import com.revature.Revamedia.entities.User;
import com.revature.Revamedia.entities.UserPosts;

import java.sql.Timestamp;

public class AddCommentDto {

    private User user;
    private UserPosts post;
    private String message;
    private String giphyUrl;
    private Timestamp dateCreated;

    public AddCommentDto() {
    }

    public AddCommentDto(User user, UserPosts post, String message, String giphyUrl, Timestamp dateCreated) {
        this.user = user;
        this.post = post;
        this.message = message;
        this.giphyUrl = giphyUrl;
        this.dateCreated = dateCreated;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserPosts getPost() {
        return post;
    }

    public void setPost(UserPosts post) {
        this.post = post;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getGiphyUrl() {
        return giphyUrl;
    }

    public void setGiphyUrl(String giphyUrl) {
        this.giphyUrl = giphyUrl;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }
}
