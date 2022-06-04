package com.revature.Revamedia.dtos;

import java.sql.Timestamp;

public class UpdateUserPostsDto {
    private Integer postId;
    private String message;
    private String image;

    public UpdateUserPostsDto(Integer postId, String message, String image) {
        this.postId = postId;
        this.message = message;
        this.image = image;
    }

    public UpdateUserPostsDto(){
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
