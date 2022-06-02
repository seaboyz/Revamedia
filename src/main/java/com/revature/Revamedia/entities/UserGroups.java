/**
 * Author(s): @Brandon Le, @Tony Henderson
 * Contributor(s):
 * Purpose:
 */
package com.revature.Revamedia.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user_groups", schema = _SchemaName.schemaName)
public class UserGroups {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Integer groupId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User ownerId;

    @Column
    private String title;

    @JsonIgnoreProperties("groupsJoined")
    @ManyToMany(mappedBy = "groupsJoined")
    private Set<User> usersJoined;

    @JsonManagedReference
    @OneToMany(mappedBy = "groupId", cascade = CascadeType.ALL)
    private Set<UserPosts> posts;

    @Column(name = "date_created")
    private Timestamp dateCreated;

    public UserGroups() {
        this.usersJoined = new HashSet<>();
        this.posts = new HashSet<>();
    }

    public UserGroups(User ownerId, String title, Set<User> usersJoined, Set<UserPosts> posts, Timestamp dateCreated) {
        this.ownerId = ownerId;
        this.title = title;
        this.usersJoined = usersJoined;
        this.posts = posts;
        this.dateCreated = dateCreated;

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

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
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
