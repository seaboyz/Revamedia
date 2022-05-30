package com.revature.Revamedia.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="user_comments", schema = "public")
public class UserComments implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Integer commentId;

    @ManyToOne()
    @JoinColumn(name = "owner_id", referencedColumnName = "user_id")
    private User ownerId;

    @ManyToOne()
    @JoinColumn(name = "post_id", referencedColumnName = "post_id")
    private UserPosts postId;

    @OneToMany(mappedBy = "commentId", cascade = CascadeType.ALL)
    @Column(name = "comment_replies")
    private List<UserReplies> replies;

    @Column(name ="message", length=500)
    private String message;

    @Column(name ="date_created")
    private String dateCreated;

    public UserComments() {
    }

    public UserComments(Integer commentId, User ownerId, UserPosts postId, List<UserReplies> replies, String message, String dateCreated) {
        this.commentId = commentId;
        this.ownerId = ownerId;
        this.postId = postId;
        this.replies = replies;
        this.message = message;
        this.dateCreated = dateCreated;
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

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public List<UserReplies> getReplies() {
        return replies;
    }

    public void setReplies(List<UserReplies> replies) {
        this.replies = replies;
    }

    private void addReply (UserReplies reply){
        this.replies.add(reply);
    }

    private void removeReply (UserReplies reply) {
        this.replies.remove(reply);
    }

    @Override
    public String toString() {
        return "UserComments{" +
                "commentId=" + commentId +
                ", ownerId=" + ownerId +
                ", postId=" + postId +
                ", replies=" + replies +
                ", message='" + message + '\'' +
                ", dateCreated='" + dateCreated + '\'' +
                '}';
    }
}
