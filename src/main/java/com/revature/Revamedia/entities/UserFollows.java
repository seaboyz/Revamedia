/**
 *  Author(s): @Brandon Le, @Tony Henderson
 *  Contributor(s):
 *  Purpose:
 */

package com.revature.Revamedia.entities;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "user_follows", schema = _SchemaName.schemaName)
public class UserFollows implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "follow_id")
    private Integer followId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "followed_id", referencedColumnName = "user_id")
    private User followedId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "follower_id", referencedColumnName = "user_id")
    private User followerId;

    @Column(name = "bookmarked")
    private boolean bookmarked;

    @CreatedDate
    @Column(name = "date_followed")
    private Date dateFollowed;

    public UserFollows() {
    }

    public UserFollows(Integer id, User followedId, User followerId, boolean bookmarked, Date dateFollowed) {
        this.followId = id;
        this.followedId = followedId;
        this.followerId = followerId;
        this.bookmarked = bookmarked;
        this.dateFollowed = dateFollowed;
    }

    public Integer getId() {
        return followId;
    }

    public void setId(Integer id) {
        this.followId = id;
    }

    public User getFollowedId() {
        return followedId;
    }

    public void setFollowedId(User followedId) {
        this.followedId = followedId;
    }

    public User getFollowerId() {
        return followerId;
    }

    public void setFollowerId(User followerId) {
        this.followerId = followerId;
    }

    public boolean getBookmarked() {
        return bookmarked;
    }

    public void setBookmarked(boolean bookmarked) {
        this.bookmarked = bookmarked;
    }

    public Date getDateFollowed() {
        return dateFollowed;
    }

    public void setDateFollowed(Date dateFollowed) {
        this.dateFollowed = dateFollowed;
    }

    @Override
    public String toString() {
        return "UserFollows{" +
                "id=" + followId +
                ", followedId=" + followedId +
                ", followerId=" + followerId +
                ", bookmarked='" + bookmarked + '\'' +
                ", dateFollowed=" + dateFollowed +
                '}';
    }
}
