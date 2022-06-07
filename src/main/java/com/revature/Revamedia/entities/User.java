/**
 * Author(s): @Brandon Le, @Tony Henderson
 * Contributor(s): @Arun Mohan, @Anthony Pilletti
 * Purpose: Entity class to represent User in database
 */


package com.revature.Revamedia.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.*;

@Entity
@JsonIgnoreProperties
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
    private Timestamp dateCreated;

    @JsonManagedReference
    @OneToMany(mappedBy = "followedId", cascade = CascadeType.ALL)
    private Set<UserFollows> followers;

    @JsonManagedReference
    @OneToMany(mappedBy = "followerId", cascade = CascadeType.ALL)
    private Set<UserFollows> following;


    // @Transient
    //@JsonManagedReference
    @JsonIgnoreProperties({""})
    @OneToMany(mappedBy = "ownerId")
    private Set<UserPosts> postsOwned;

    @JsonIgnoreProperties("likes")
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "liked_posts",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "post_id")
    )
    private List<UserPosts> likedPosts;

    @JsonIgnoreProperties("usersJoined")
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_in_groups",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "group_id")}
    )
    private Set<UserGroups> groupsJoined;

    @JsonManagedReference
    @OneToMany(mappedBy = "ownerId", cascade = CascadeType.ALL)
    private Set<UserGroups> groupsOwned;

    @JsonIgnoreProperties
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_in_events",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "event_id")}
    )
    private Set<UserEvents> eventsJoined;

    @JsonManagedReference
    @OneToMany(mappedBy = "ownerId", cascade = CascadeType.ALL)
    private Set<UserEvents> eventsOwned;

    public User() {
        this.followers = new HashSet<>();
        this.following = new HashSet<>();
        this.postsOwned = new HashSet<>();

        this.groupsJoined = new HashSet<>();
        this.groupsOwned = new HashSet<>();

        this.eventsJoined = new HashSet<>();
        this.eventsOwned = new HashSet<>();

//        this.conversations = new HashSet<>();

        this.likedPosts = new ArrayList<>();
    }

    public User(Integer userId, String username, String email, String password, String firstName, String lastName,
            String profilePicture, Timestamp dateCreated, Set<UserFollows> followers, Set<UserFollows> following,
            Set<UserPosts> posts, Set<UserGroups> groupsJoined, Set<UserGroups> groupsOwned, List<UserPosts> likedPosts,
            Set<UserEvents> eventsJoined, Set<UserEvents> eventsOwned, Set<UserConversations> conversations) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profilePicture = profilePicture;
        this.dateCreated = dateCreated;
        this.likedPosts = likedPosts;
        this.followers = followers;
        this.following = following;
        this.postsOwned = posts;
        this.groupsJoined = groupsJoined;
        this.groupsOwned = groupsOwned;
        this.eventsJoined = eventsJoined;
        this.eventsOwned = eventsOwned;
        // this.conversations = conversations;
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

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
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

    public List<UserPosts> getLikedPosts() {
        return likedPosts;
    }

    public Set<UserPosts> getPostsOwned() {
        return postsOwned;
    }

    public void setPostsOwned(Set<UserPosts> postsOwned) {
        this.postsOwned = postsOwned;
    }

    public void setLikedPosts(List<UserPosts> likedPosts) {
        this.likedPosts = likedPosts;
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
        this.postsOwned.add(post);
    }

    public void removePost(UserPosts post) {
        this.postsOwned.remove(post);
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

    public void addLikedPost(UserPosts post) {
        this.likedPosts.add(post);
    }

    public void removeLikedPost(UserPosts post) {
        this.likedPosts.remove(post);
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
