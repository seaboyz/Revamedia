package com.revature.Revamedia.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_replies", schema = "public")
public class UserReplies implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reply_id")
    private Integer replyId;

    @ManyToOne()
    @JoinColumn(name = "owner_id", referencedColumnName = "user_id")
    private User ownerId;

    @ManyToOne()
    @JoinColumn(name = "comment_id", referencedColumnName = "comment_id")
    private UserComments commentId;

    @Column(name ="message", length=500)
    private String message;

    @Column(name ="date_created")
    private String dateCreated;

    public UserReplies() {
    }

    public UserReplies(Integer replyId, User ownerId, UserComments commentId, String message, String dateCreated) {
        this.replyId = replyId;
        this.ownerId = ownerId;
        this.commentId = commentId;
        this.message = message;
        this.dateCreated = dateCreated;
    }

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public User getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(User ownerId) {
        this.ownerId = ownerId;
    }

    public UserComments getCommentId() {
        return commentId;
    }

    public void setCommentId(UserComments commentId) {
        this.commentId = commentId;
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

    @Override
    public String toString() {
        return "UserReplies{" +
                "replyId=" + replyId +
                ", ownerId=" + ownerId +
                ", commentId=" + commentId +
                ", message='" + message + '\'' +
                ", dateCreated='" + dateCreated + '\'' +
                '}';
    }
}
