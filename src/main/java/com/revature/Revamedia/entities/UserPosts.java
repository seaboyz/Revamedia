/**
 * Author(s): @Brandon Le, @Tony Henderson
 * Contributor(s): @Arun Mohan, @Anthony Pilletti
 * Purpose: Entity class to represent UserPosts in database
 */
package com.revature.Revamedia.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@JsonIgnoreProperties
@Table(name = "user_posts", schema = _SchemaName.schemaName)
public class UserPosts implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Integer postId;

    @JsonBackReference
    @ManyToOne()
    @JoinColumn(name = "owner_id", referencedColumnName = "user_id")
    private User ownerId;

    @JsonManagedReference
    @OneToMany(mappedBy = "postId", cascade = CascadeType.ALL)
    private List<UserComments> comments;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "group_id")
    private UserGroups groupId;

    @Column(name = "message", length = 500)
    private String message;

    @Column(name = "youtube_link")
    private String youtubeLink;

    @Column(name = "image")
    private String image;

    @JsonIgnoreProperties({"followers", "following", "likedPosts", "groupsJoined", "groupsOwned", "eventsJoined", "eventsOwned", "postsOwned"})
    @ManyToMany(mappedBy = "likedPosts", cascade = CascadeType.ALL)
    private Set<User> likes;

    @Column(name = "post_lifetime", nullable = true)
    private String postLifetime;

    @Column(name = "date_created")
    private Timestamp dateCreated;

    public UserPosts() {
        this.comments = new ArrayList<>();
        this.likes = new HashSet<>();
    }

    public UserPosts(Integer postId, User ownerId, List<UserComments> comments, String message, String youtubeLink,
            String image, Set<User> likes, String postLifetime, Timestamp dateCreated, UserGroups groupId) {
        this.postId = postId;
        this.ownerId = ownerId;
        this.comments = comments;
        this.groupId = groupId;
        this.message = message;
        this.youtubeLink = youtubeLink;
        this.image = image;
        this.likes = likes;
        this.postLifetime = postLifetime;
        this.dateCreated = dateCreated;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public User getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(User ownerId) {
        this.ownerId = ownerId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getYoutubeLink() {
        return youtubeLink;
    }

    public void setYoutubeLink(String youtubeLink) {
        this.youtubeLink = youtubeLink;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<User> getLikes() {
        return likes;
    }

    public void setLikes(Set<User> likes) {
        this.likes = likes;
    }

    public String getPostLifetime() {
        return postLifetime;
    }

    public void setPostLifetime(String postLifetime) {
        this.postLifetime = postLifetime;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    public List<UserComments> getComments() {
        return comments;
    }

    public void setComments(List<UserComments> comments) {
        this.comments = comments;
    }

    public void addComment(UserComments comment) {
        this.comments.add(comment);
    }

    public void removeComment(UserComments comment) {
        this.comments.remove(comment);
    }

    public UserGroups getGroupId() {
        return groupId;
    }

    public void setGroupId(UserGroups groupId) {
        this.groupId = groupId;
    }

    public void addLikes(User user) {
        likes.add(user);
    }

    public void removeLikes(User user) {
        likes.remove(user);
    }

    @Override
    public String toString() {
        return "UserPosts{" +
                "postId=" + postId +
                ", ownerId=" + ownerId +
                ", comments=" + comments +
                ", groupId=" + groupId +
                ", message='" + message + '\'' +
                ", youtubeLink='" + youtubeLink + '\'' +
                ", image='" + image + '\'' +
                ", likes=" + likes +
                ", postLifetime='" + postLifetime + '\'' +
                ", dateCreated='" + dateCreated + '\'' +
                '}';
    }
}
