package com.revature.Revamedia.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user_groups", schema = "public")
public class UserGroups {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Integer groupId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User ownerId;

    @Column
    private String title;

    @OneToMany(mappedBy = "userId")
    private Set<User> usersJoined;

    @OneToMany(mappedBy = "postId")
    private Set<UserPosts> posts;

    @Column(name = "date_created")
    private String dateCreated;

    public UserGroups() {
    }

    public UserGroups(User ownerId, String title, Set<User> usersJoined, Set<UserPosts> posts, String dateCreated) {
        this.ownerId = ownerId;
        this.title = title;
        this.usersJoined = usersJoined;
        this.posts = posts;
        this.dateCreated = dateCreated;

        this.usersJoined = new HashSet<>();
        this.posts = new HashSet<>();
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public User getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(User ownerId) {
        this.ownerId = ownerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<User> getUsersJoined() {
        return usersJoined;
    }

    public void setUsersJoined(Set<User> usersJoined) {
        this.usersJoined = usersJoined;
    }

    public void addJoinedUser(User user) {
        this.usersJoined.add(user);
    }

    public void removeJoinedUser(User user) {
        this.usersJoined.remove(user);
    }

    public Set<UserPosts> getPosts() {
        return posts;
    }

    public void setPosts(Set<UserPosts> posts) {
        this.posts = posts;
    }

    public void addPost(UserPosts post) {
        this.posts.add(post);
    }

    public void removePost(UserPosts post) {
        this.posts.remove(post);
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "UserGroups{" +
                "groupId=" + groupId +
                ", ownerId=" + ownerId +
                ", title='" + title + '\'' +
                ", usersJoined=" + usersJoined +
                ", posts=" + posts +
                ", dateCreated='" + dateCreated + '\'' +
                '}';
    }
}
