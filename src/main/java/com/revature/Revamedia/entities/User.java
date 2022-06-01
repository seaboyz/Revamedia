/**
 *  Author(s): @Brandon Le, @Tony Henderson
 *  Contributor(s):
 *  Purpose:
 */


package com.revature.Revamedia.entities;

import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "users", schema = _SchemaName.schemaName)
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "email", unique = true)
    private String email;

    @NotEmpty
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

    @OneToMany(mappedBy = "followedId", cascade = CascadeType.ALL)
    private Set<UserFollows> followers;
    @OneToMany(mappedBy = "followerId", cascade = CascadeType.ALL)
    private Set<UserFollows> following;
    @OneToMany(mappedBy = "postId", cascade = CascadeType.ALL)
    private List<UserPosts> posts;

    @OneToMany(mappedBy = "groupId", cascade = CascadeType.ALL)
    private Set<UserGroups> groupsJoined;
    @OneToMany(mappedBy = "ownerId", cascade = CascadeType.ALL)
    private Set<UserGroups> groupsOwned;

    @OneToMany(mappedBy = "eventId", cascade = CascadeType.ALL)
    private Set<UserEvents> eventsJoined;
    @OneToMany(mappedBy = "ownerId", cascade = CascadeType.ALL)
    private Set<UserEvents> eventsOwned;

    @OneToMany(mappedBy = "conversationId", cascade = CascadeType.ALL)
    private Set<UserConversations> conversations;


    public User() {
        this.followers = new HashSet<>();
        this.following = new HashSet<>();
        this.posts = new ArrayList<>();

        this.groupsJoined = new HashSet<>();
        this.groupsOwned = new HashSet<>();

        this.eventsJoined = new HashSet<>();
        this.eventsOwned = new HashSet<>();

        this.conversations = new HashSet<>();
    }

    public User(Integer userId, String username, String email, String password, String firstName, String lastName, String profilePicture, String dateCreated, Set<UserFollows> followers, Set<UserFollows> following, List<UserPosts> posts, Set<UserGroups> groupsJoined, Set<UserGroups> groupsOwned, Set<UserEvents> eventsJoined, Set<UserEvents> eventsOwned, Set<UserConversations> conversations) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profilePicture = profilePicture;
        this.dateCreated = dateCreated;
        this.followers = followers;
        this.following = following;
        this.posts = posts;
        this.groupsJoined = groupsJoined;
        this.groupsOwned = groupsOwned;
        this.eventsJoined = eventsJoined;
        this.eventsOwned = eventsOwned;
        this.conversations = conversations;
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

    public void follow(UserFollows followee) {
        this.following.add(followee);
    }

    public void unFollow(UserFollows followee) {
        this.following.remove(followee);
    }

    public void addPost(UserPosts post) {
        this.posts.add(post);
    }

    public void removePost(UserPosts post) {
        this.posts.remove(post);
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

    public void addConversation(UserConversations conversation) {
        this.conversations.add(conversation);
    }

    public void removeConversation(UserConversations conversation) {
        this.conversations.remove(conversation);
    }

    public Set<UserConversations> getConversations() {
        return conversations;
    }

    public void setConversations(Set<UserConversations> conversations) {
        this.conversations = conversations;
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
                ", profilePicture='" + profilePicture + '\'' +
                ", dateCreated='" + dateCreated + '\'' +
                '}';
    }
}
