package com.revature.Revamedia.dtos;

public class DeleteUserPostsDto {
    private Integer postId;

    public DeleteUserPostsDto(Integer postId) {
        this.postId = postId;
    }
    public DeleteUserPostsDto(){}

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }
}
