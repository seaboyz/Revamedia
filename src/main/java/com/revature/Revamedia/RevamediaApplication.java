package com.revature.Revamedia;

import com.revature.Revamedia.beans.services.*;
import com.revature.Revamedia.entities.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = "com.revature.Revamedia.beans")
public class RevamediaApplication {
    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(RevamediaApplication.class, args);

        UserService userService = context.getBean(UserService.class);
        UserFollowsService userFollowsService = context.getBean(UserFollowsService.class);
        UserPostsService userPostsService = context.getBean(UserPostsService.class);
        UserCommentsService userCommentsService = context.getBean(UserCommentsService.class);
        UserRepliesService userRepliesService = context.getBean(UserRepliesService.class);


        User user1 = new User();
        user1.setFirstName("Brandon");
        user1.setUsername("b1");
        user1.setPassword("password");
        userService.save(user1);

        User user2 = new User();
        user2.setFirstName("gio");
        user2.setUsername("g1");
        user2.setPassword("password");
        userService.save(user2);

        User user3 = new User();
        user3.setFirstName("tony");
        user3.setUsername("t1");
        user3.setPassword("password");
        userService.save(user3);

        UserFollows follow1 = new UserFollows();
        follow1.setFollowedId(userService.getUserById(1));
        follow1.setFollowerId(userService.getUserById(2));
        userFollowsService.save(follow1);

        UserFollows follow2 = new UserFollows();
        follow2.setFollowedId(userService.getUserById(2));
        follow2.setFollowerId(userService.getUserById(1));
        userFollowsService.save(follow2);

        UserPosts post1 = new UserPosts();
        post1.setOwnerId(user1);
        post1.setMessage("post1 message by user1");
        post1.setLikes(20);
        userPostsService.save(post1);

        UserComments comment1 = new UserComments();
        comment1.setOwnerId(user1);
        comment1.setPostId(post1);
        comment1.setMessage("comment1 message by user1");
        userCommentsService.save(comment1);

        UserReplies reply1 = new UserReplies();
        reply1.setOwnerId(user1);
        reply1.setCommentId(comment1);
        reply1.setMessage("reply1 message by user1");
        userRepliesService.save(reply1);

        UserReplies reply2 = new UserReplies();
        reply2.setOwnerId(user2);
        reply2.setCommentId(comment1);
        reply2.setMessage("reply2 message by user2");
        userRepliesService.save(reply2);

        UserReplies reply3 = new UserReplies();
        reply3.setOwnerId(user3);
        reply3.setCommentId(comment1);
        reply3.setMessage("reply3 message by user3");
        userRepliesService.save(reply3);




    }
}