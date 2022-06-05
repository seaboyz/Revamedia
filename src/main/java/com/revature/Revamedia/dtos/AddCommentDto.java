package com.revature.Revamedia.dtos;

import com.revature.Revamedia.entities.User;
import com.revature.Revamedia.entities.UserPosts;

import java.sql.Timestamp;

public class AddCommentDto {

    private Integer owner_id;
    private Integer post_id;
    private String message;
    private String giphyUrl;
    private Timestamp dateCreated;

    public AddCommentDto() {
    }

    public AddCommentDto(Integer owner_id, Integer post_id, String message, String giphyUrl, Timestamp dateCreated) {
        this.owner_id = owner_id;
        this.post_id = post_id;
        this.message = message;
        this.giphyUrl = giphyUrl;
        this.dateCreated = dateCreated;
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
