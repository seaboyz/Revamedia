package com.revature.Revamedia.entities;

/**
 * Author(s): @Brandon Le, @Tony Henderson
 * Contributor(s):
 * Purpose:
 */

import com.fasterxml.jackson.annotation.JsonIgnore;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_comments", schema = _SchemaName.schemaName)
public class UserComments implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Integer commentId;


    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "owner_id", referencedColumnName = "user_id")
    private User ownerId;


    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "post_id", referencedColumnName = "post_id")
    private UserPosts postId;

//    @JsonIgnore
    @OneToMany(mappedBy = "commentId", cascade = CascadeType.ALL)
    private List<UserReplies> replies;

    @Column(name = "message", length = 500)
    private String message;

    @Column(name = "date_created")
    private Timestamp dateCreated;

    @Column(name = "giphyUrl")
    private String giphyUrl;

    public UserComments() {
        this.replies = new ArrayList<>();
    }

    public UserComments(Integer commentId, User ownerId, UserPosts postId, List<UserReplies> replies, String message, Timestamp dateCreated, String giphyUrl) {
        this.commentId = commentId;
        this.ownerId = ownerId;
        this.postId = postId;
        this.replies = replies;
        this.message = message;
        this.dateCreated = dateCreated;
        this.giphyUrl = giphyUrl;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public User getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(User ownerId) {
        this.ownerId = ownerId;
    }

    public UserPosts getPostId() {
        return postId;
    }

    public void setPostId(UserPosts postId) {
        this.postId = postId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    public List<UserReplies> getReplies() {
        return replies;
    }

    public void setReplies(List<UserReplies> replies) {
        this.replies = replies;
    }

    public void addReply(UserReplies reply) {
        this.replies.add(reply);
    }

    public void removeReply(UserReplies reply) {
        this.replies.remove(reply);
    }

    public String getGiphyUrl() {
        return giphyUrl;
    }

    public void setGiphyUrl(String giphyUrl) {
        this.giphyUrl = giphyUrl;
    }

    @Override
    public String toString() {
        return "UserComments{" +
                "commentId=" + commentId +
                ", ownerId=" + ownerId +
                ", replies=" + replies +
                ", message='" + message + '\'' +
                ", giphyUrl=" + giphyUrl +
                ", dateCreated='" + dateCreated + '\'' +
                '}';
    }
}
