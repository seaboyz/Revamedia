package com.revature.Revamedia.dtos;

import com.revature.Revamedia.entities.UserFollows;
import com.revature.Revamedia.entities.UserPosts;

import java.util.Set;

public class ViewAllUserDto {
    private String userName;
    private String firstName;
    private String lastName;
    private String profilePicture;
    private Set<UserFollows> followers;
    private Set<UserFollows> following;
    private Set<UserPosts> postsOwned;

    public ViewAllUserDto() {
    }

    public ViewAllUserDto(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public ViewAllUserDto(String userName) {
        this.userName = userName;
    }

    public ViewAllUserDto(String firstName, String lastName, String profilePicture, Set<UserFollows> followers, Set<UserFollows> following, Set<UserPosts> postsOwned) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.profilePicture = profilePicture;
        this.followers = followers;
        this.following = following;
        this.postsOwned = postsOwned;
    }

    public ViewAllUserDto(String userName, String firstName, String lastName, String profilePicture, Set<UserFollows> followers, Set<UserFollows> following, Set<UserPosts> postsOwned) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profilePicture = profilePicture;
        this.followers = followers;
        this.following = following;
        this.postsOwned = postsOwned;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public Set<UserFollows> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<UserFollows> followers) {
        this.followers = followers;
    }

    public Set<UserFollows> getFollowing() {
        return following;
    }

    public void setFollowing(Set<UserFollows> following) {
        this.following = following;
    }

    public Set<UserPosts> getPostsOwned() {
        return postsOwned;
    }

    public void setPostsOwned(Set<UserPosts> postsOwned) {
        this.postsOwned = postsOwned;
    }

    @Override
    public String toString() {
        return "ViewAllUsersDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", profilePicture='" + profilePicture + '\'' +
                ", followers=" + followers +
                ", following=" + following +
                ", postsOwned=" + postsOwned +
                '}';
    }
}
