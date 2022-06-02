/**
 * Author(s): @Brandon Le, @Tony Henderson
 * Contributor(s):
 * Purpose:
 */
package com.revature.Revamedia.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "user_events", schema = _SchemaName.schemaName)
public class UserEvents implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Integer eventId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User ownerId;

    @Column
    private String title;

    @JsonIgnoreProperties("eventsJoined")
    @ManyToMany(mappedBy = "eventsJoined")
    private Set<User> usersJoined;

    @Column
    private String image;

    @Column
    private String body;

    @Column
    private Timestamp date;

    @Column(name = "date_created")
    private Timestamp dateCreated;

    public UserEvents() {
    }

    public UserEvents(User ownerId, String title, Set<User> usersJoined, String image, String body, Timestamp date, Timestamp dateCreated) {
        this.ownerId = ownerId;
        this.title = title;
        this.usersJoined = usersJoined;
        this.image = image;
        this.body = body;
        this.date = date;
        this.dateCreated = dateCreated;
    }

    public Integer getId() {
        return eventId;
    }

    public void setId(Integer id) {
        this.eventId = id;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "UserEvents{" +
                "eventId=" + eventId +
                ", ownerId=" + ownerId +
                ", title='" + title + '\'' +
                ", usersJoined=" + usersJoined +
                ", image='" + image + '\'' +
                ", body='" + body + '\'' +
                ", date='" + date + '\'' +
                ", dateCreated='" + dateCreated + '\'' +
                '}';
    }
}
