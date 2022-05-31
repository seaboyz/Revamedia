/**
 *  Author(s): @Brandon Le, @Tony Henderson
 *  Contributor(s):
 *  Purpose:
 */
package com.revature.Revamedia.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "user_messages", schema = _SchemaName.schemaName)
public class UserMessages implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private Integer messageId;

    @ManyToOne()
    @JoinColumn(name = "owner_id", referencedColumnName = "user_id")
    private User ownerId;

    @ManyToOne()
    @JoinColumn(name = "conversation_id", referencedColumnName = "conversation_id")
    private UserConversations conversation;

    @Column(name ="message", length=500)
    private String message;

    @Column(name ="date_created")
    private String dateCreated;

    public UserMessages() {
    }

    public UserMessages(Integer messageId, User ownerId, UserConversations conversation, String message, String dateCreated) {
        this.messageId = messageId;
        this.ownerId = ownerId;
        this.conversation = conversation;
        this.message = message;
        this.dateCreated = dateCreated;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public User getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(User ownerId) {
        this.ownerId = ownerId;
    }

    public UserConversations getConversation() {
        return conversation;
    }

    public void setConversation(UserConversations conversation) {
        this.conversation = conversation;
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
        return "UserMessages{" +
                "messageId=" + messageId +
                ", ownerId=" + ownerId +
                ", message='" + message + '\'' +
                ", dateCreated='" + dateCreated + '\'' +
                '}';
    }
}
