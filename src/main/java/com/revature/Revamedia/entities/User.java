package com.revature.Revamedia.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "users", schema = "public")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "username", unique = true)
    private String username;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "profile_picture")
    private String profilePicture;
    @Column(name = "date_created")
    private String dateCreated;

    @OneToMany(mappedBy = "followedId")
    private Set<UserFollows> followers;
    @OneToMany(mappedBy = "followerId")
    private Set<UserFollows> following;
    @OneToMany(mappedBy = "postId")
    private List<UserPosts> posts;

    @OneToMany(mappedBy = "groupId")
    private Set<UserGroups> groupsJoined;
    @OneToMany(mappedBy = "ownerId")
    private Set<UserGroups> groupsOwned;

    @OneToMany(mappedBy = "eventId")
    private Set<UserEvents> eventsJoined;
    @OneToMany(mappedBy = "ownerId")
    private Set<UserEvents> eventsOwned;


    public User() {
        this.followers = new HashSet<>();
        this.following = new HashSet<>();
        this.posts = new ArrayList<>();

        this.groupsJoined = new HashSet<>();
        this.groupsOwned = new HashSet<>();

        this.eventsJoined = new HashSet<>();
        this.eventsOwned = new HashSet<>();
    }

    public User(Integer userId, String username, String email, String password, String firstName, String lastName, String dateCreated, String profilePicture) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateCreated = dateCreated;
        this.profilePicture = profilePicture;

        this.followers = new HashSet<>();
        this.following = new HashSet<>();
        this.posts = new ArrayList<>();

        this.groupsJoined = new HashSet<>();
        this.groupsOwned = new HashSet<>();

        this.eventsJoined = new HashSet<>();
        this.eventsOwned = new HashSet<>();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
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

    public List<UserPosts> getPosts() {
        return posts;
    }

    public void setPosts(List<UserPosts> posts) {
        this.posts = posts;
    }

    public Set<UserGroups> getGroupsJoined() {
        return groupsJoined;
    }

    public void setGroupsJoined(Set<UserGroups> groupsJoined) {
        this.groupsJoined = groupsJoined;
    }

    public Set<UserGroups> getGroupsOwned() {
        return groupsOwned;
    }

    public void setGroupsOwned(Set<UserGroups> groupsOwned) {
        this.groupsOwned = groupsOwned;
    }

    public Set<UserEvents> getEventsJoined() {
        return eventsJoined;
    }

    public void setEventsJoined(Set<UserEvents> eventsJoined) {
        this.eventsJoined = eventsJoined;
    }

    public Set<UserEvents> getEventsOwned() {
        return eventsOwned;
    }

    public void setEventsOwned(Set<UserEvents> eventsOwned) {
        this.eventsOwned = eventsOwned;
    }

    public void addFollower(UserFollows follower) {
        this.followers.add(follower);
    }

    public void removeFollower(UserFollows follower) {
        this.followers.remove(follower);
    }

    public void addPost(UserPosts post) {
        this.posts.add(post);
    }

    public void removePost(UserPosts post) {
        this.posts.add(post);
    }

    public void joinGroup(UserGroups group) {
        this.groupsJoined.add(group);
    }

    public void leaveGroup(UserGroups group) {
        this.groupsJoined.remove(group);
    }

    public void createGroup(UserGroups group) {
        this.groupsOwned.add(group);
    }

    public void leaveOwnedGroup(UserGroups group) {
        this.groupsOwned.remove(group);
    }

    public void joinEvent(UserEvents event) {
        this.eventsJoined.add(event);
    }

    public void leaveEvent(UserEvents event) {
        this.eventsJoined.remove(event);
    }

    public void createEvent(UserEvents event) {
        this.eventsOwned.add(event);
    }

    public void leaveOwnedEvent(UserEvents event) {
        this.eventsOwned.remove(event);
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) && Objects.equals(username, user.username) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(dateCreated, user.dateCreated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username, email, password, firstName, lastName, dateCreated);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateCreated='" + dateCreated + '\'' +
                '}';
    }
}
