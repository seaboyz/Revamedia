/**
 * Author(s): @Brandon Le, @Arun Mohan, @Anthony Pilletti
 * Contributor(s):
 * Purpose: Data Transfer Object class to store http request body data when updating likes from the frontend
 */

package com.revature.Revamedia.dtos;

import com.revature.Revamedia.entities.UserPosts;

public class UpdatePostLikesDto {
    private Integer userId;
    private Integer postId;

    public UpdatePostLikesDto() {
    }

    public UpdatePostLikesDto(Integer userId, Integer postId) {
        this.userId = userId;
        this.postId = postId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

}