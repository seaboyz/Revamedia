package com.revature.Revamedia.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_posts", schema = "public")
public class UserPosts implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;

    @ManyToOne()
    @JoinColumn(name = "owner_id", referencedColumnName = "user_id")
    private User ownerId;

    @Column(name ="message", length=500)
    private String message;

    @Column(name ="youtube_link")
    private String youtubeLink;

    @Column(name ="image")
    private String image;



}
