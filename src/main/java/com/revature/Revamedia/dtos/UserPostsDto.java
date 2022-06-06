package com.revature.Revamedia.dtos;

import com.revature.Revamedia.entities.User;
import com.revature.Revamedia.entities.UserPosts;

public class UserPostsDto {
    User user;
    UserPosts userPosts;

    public UserPostsDto() {
    }

    public UserPostsDto(User user, UserPosts userPosts) {
        this.user = user;
        this.userPosts = userPosts;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserPosts getUserPosts() {
        return userPosts;
    }

    public void setUserPosts(UserPosts userPosts) {
        this.userPosts = userPosts;
    }
}
