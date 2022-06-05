/**
 *  Author(s): @Brandon Le, @Tony Henderson
 *  Contributor(s):
 *  Purpose:
 */
package com.revature.Revamedia.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "user_replies", schema = _SchemaName.schemaName)
public class UserReplies implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reply_id")
    private Integer replyId;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "owner_id", referencedColumnName = "user_id")
    private User ownerId;

    @JsonBackReference
    @ManyToOne()
    @JoinColumn(name = "comment_id", referencedColumnName = "comment_id")
    private UserComments commentId;

    @Column(name = "message", length = 500)
    private String message;


    @Column(name = "giphyUrl")
    private String giphyUrl;

    @Column(name = "date_created")
    private Timestamp dateCreated;

    public UserReplies() {
    }

    public UserReplies(Integer replyId, User ownerId, UserComments commentId, String message, Timestamp dateCreated,
            String giphyUrl) {
        this.replyId = replyId;
        this.ownerId = ownerId;
        this.commentId = commentId;
        this.message = message;
        this.dateCreated = dateCreated;
        this.giphyUrl = giphyUrl;
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

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getGiphyUrl() {
        return giphyUrl;
    }

    public void setGiphyUrl(String giphyUrl) {
        this.giphyUrl = giphyUrl;
    }

    @Override
    public String toString() {
        return "UserReplies{" +
                "replyId=" + replyId +
                ", ownerId=" + ownerId +
                ", message='" + message + '\'' +
                ", giphyUrl=" + giphyUrl +
                ", dateCreated='" + dateCreated + '\'' +
                '}';
    }

}
