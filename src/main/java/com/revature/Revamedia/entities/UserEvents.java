/**
 *  Author(s): @Brandon Le, @Tony Henderson
 *  Contributor(s):
 *  Purpose:
 */
package com.revature.Revamedia.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "user_events", schema = _SchemaName.schemaName)
public class UserEvents implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Integer eventId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User ownerId;

    @Column
    private String title;

    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL)
    private Set<User> usersJoined;

    @Column
    private String image;

    @Column
    private String body;

    @Column
    private String date;

    @Column(name = "date_created")
    private String dateCreated;

    public UserEvents() {
    }

    public UserEvents(User ownerId, String title, Set<User> usersJoined, String image, String body, String date, String dateCreated) {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
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
