package com.revature.Revamedia.dtos;

import com.revature.Revamedia.entities.User;

import java.sql.Timestamp;

public class UserCommentsDto {
    private Integer owner_id;
    private Integer post_id;
    private Integer comment_id;
    private String message;
    private Timestamp dateCreated;
    private String giphyUrl;

    public UserCommentsDto() {
    }

    public UserCommentsDto(Integer owner_id, Integer post_id, Integer comment_id, String message,
                           Timestamp dateCreated, String giphyUrl) {
        this.owner_id = owner_id;
        this.post_id = post_id;
        this.comment_id = comment_id;
        this.message = message;
        this.dateCreated = dateCreated;
        this.giphyUrl = giphyUrl;
    }

    public UserCommentsDto(Integer comment_id, String message) {
        this.comment_id = comment_id;
        this.message = message;
    }

    public Integer getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Integer owner_id) {
        this.owner_id = owner_id;
    }

    public Integer getPost_id() {
        return post_id;
    }

    public void setPost_id(Integer post_id) {
        this.post_id = post_id;
    }

    public Integer getComment_id() {
        return comment_id;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getGiphyUrl() {
        return giphyUrl;
    }

    public void setGiphyUrl(String giphyUrl) {
        this.giphyUrl = giphyUrl;
    }
}
