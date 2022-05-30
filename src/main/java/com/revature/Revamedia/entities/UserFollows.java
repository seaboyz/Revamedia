package com.revature.Revamedia.entities;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "user_follows", schema = "public")
public class UserFollows implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "followed_id", referencedColumnName = "user_id")
    private User followedId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "follower_id", referencedColumnName = "user_id")
    private User followerId;

    @Column(name = "bookmarked")
    private String bookmarked;

    @CreatedDate
    @Column(name = "date_followed")
    private Date dateFollowed;

    public UserFollows() {
    }

    public UserFollows(Integer id, User followedId, User followerId, String bookmarked, Date dateFollowed) {
        this.id = id;
        this.followedId = followedId;
        this.followerId = followerId;
        this.bookmarked = bookmarked;
        this.dateFollowed = dateFollowed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getBookmarked() {
        return bookmarked;
    }

    public void setBookmarked(String bookmarked) {
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
                "id=" + id +
                ", followedId=" + followedId +
                ", followerId=" + followerId +
                ", bookmarked='" + bookmarked + '\'' +
                ", dateFollowed=" + dateFollowed +
                '}';
    }
}
