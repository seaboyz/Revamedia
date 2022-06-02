/**
 *  Author(s): @Brandon Le, @Tony Henderson
 *  Contributor(s):
 *  Purpose:
 */
package com.revature.Revamedia.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_conversations", schema = _SchemaName.schemaName)
public class UserConversations implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "conversation_id")
    private Integer conversationId;

    @JsonBackReference
    @ManyToOne()
    @JoinColumn(name = "recipient_id", referencedColumnName = "user_id")
    private User recipientId;

    @JsonManagedReference
    @OneToMany(mappedBy = "messageId", cascade = CascadeType.ALL)
    private List<UserMessages> messages;

    public UserConversations() {
        this.messages = new ArrayList<>();
    }

    public UserConversations(Integer conversationId, User recipientId, List<UserMessages> messages) {
        this.conversationId = conversationId;
        this.recipientId = recipientId;
        this.messages = messages;
    }

    public Integer getConversationId() {
        return conversationId;
    }

    public void setConversationId(Integer conversationId) {
        this.conversationId = conversationId;
    }

    public User getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(User recipientId) {
        this.recipientId = recipientId;
    }

    public List<UserMessages> getMessages() {
        return messages;
    }

    public void setMessages(List<UserMessages> messages) {
        this.messages = messages;
    }

    public void addMessage (UserMessages message) {
        messages.add(message);
    }

    public void removeMessage (UserMessages message) {
        messages.remove(message);
    }
}
