/**
 * Author(s): @Everyone
 * Contributor(s):
 * Purpose: Main Driver for Revamedia Application. Starts up spring boot application.
 */
package com.revature.Revamedia;

import com.revature.Revamedia.beans.services.*;
<<<<<<< HEAD
import com.revature.Revamedia.beans.utils.CorsFilter;
=======
>>>>>>> dev
import com.revature.Revamedia.entities.User;
import com.revature.Revamedia.entities.UserPosts;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

import java.sql.Date;
import java.sql.Timestamp;

@SpringBootApplication(scanBasePackages = "com.revature.Revamedia.beans")
public class RevamediaApplication {
        public static void main(String[] args) {

<<<<<<< HEAD
            ConfigurableApplicationContext context = SpringApplication.run(RevamediaApplication.class, args);

            UserPostsService userPostsService = context.getBean(UserPostsService.class);
            UserService userService = context.getBean(UserService.class);

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

=======
                ConfigurableApplicationContext context = SpringApplication.run(RevamediaApplication.class, args);
                context.start();
                UserPostsService userPostsService = context.getBean(UserPostsService.class);
                UserService userService = context.getBean(UserService.class);
                UserCommentsService userCommentsService = context.getBean(UserCommentsService.class);
                UserRepliesService userRepliesService = context.getBean(UserRepliesService.class);
                UserEventsService userEventsService = context.getBean(UserEventsService.class);
                UserGroupsService userGroupsService = context.getBean(UserGroupsService.class);
                UserConversationsService userConversationsService = context.getBean(UserConversationsService.class);
                UserMessagesService userMessagesService = context.getBean(UserMessagesService.class);
                // User user1 = new User();
                // user1.setFirstName("Brandon");
                // user1.setUsername("b1");
                // user1.setPassword("password");
                // userService.save(user1);
                //
                 /*User user2 = userService.getUserById(2);

                Timestamp timestamp = new Timestamp(System.currentTimeMillis());


                 UserPosts post1 = new UserPosts();
                 post1.setOwnerId(user2);
                 post1.setMessage("second post message by user2");
                 post1.setDateCreated(timestamp);
                 user2.addPost(post1);

                 userPostsService.save(post1);
                 userService.update(user2);
*/
                //
                // User user3 = new User();
                // user3.setFirstName("tony");
                // user3.setUsername("t1");
                // user3.setPassword("password");
                // userService.save(user3);
                //
                //
                // //testing follows
                // UserFollows follow1 = new UserFollows();
                // follow1.setFollowedId(userService.getUserById(1));
                // follow1.setFollowerId(userService.getUserById(2));
                //
                // UserFollows follow2 = new UserFollows();
                // follow2.setFollowedId(userService.getUserById(2));
                // follow2.setFollowerId(userService.getUserById(1));
                // userFollowsService.save(follow2);
                //
                // UserFollows follow3 = new UserFollows();
                // follow3.setFollowedId(userService.getUserById(1));
                // follow3.setFollowerId(userService.getUserById(3));
                //
                // user1.addFollower(follow1);
                // user1.addFollower(follow3);
                //
                //
                // //testing posts
                // UserPosts post1 = new UserPosts();
                // post1.setOwnerId(user1);
                // post1.setMessage("post1 message by user1");
                //
                // userPostsService.save(post1);
                //
                // UserPosts post2 = new UserPosts();
                // post2.setOwnerId(user1);
                // post2.setMessage("post2 message by user1");
                //
                //
                // UserPosts post3 = new UserPosts();
                // post3.setOwnerId(user1);
                // post3.setMessage("post3 message by user1");
                //
                //
                // user1.addPost(post1);
                // user1.addPost(post2);
                // user1.addPost(post3);
                // userService.save(user1);
>>>>>>> dev

            UserPosts post1 = new UserPosts();
            post1.setOwnerId(user1);
            userPostsService.save(post1);

            UserPosts post2 = new UserPosts();
            post2.setOwnerId(user1);
            userPostsService.save(post2);

            UserPosts post3 = new UserPosts();
            post3.setOwnerId(user2);
            userPostsService.save(post3);

        }
}




