/**
 * Author(s): @Everyone
 * Contributor(s):
 * Purpose: Main Driver for Revamedia Application. Starts up spring boot application.
 */
package com.revature.Revamedia;

import com.revature.Revamedia.beans.services.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = "com.revature.Revamedia.beans")
public class RevamediaApplication {
        public static void main(String[] args) {

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
                // User user2 = userService.getUserById(2);
                // user2.setFirstName("gio");
                // user2.setUsername("unique");
                // user2.setPassword("password");

                // UserPosts post1 = new UserPosts();
                // post1.setOwnerId(user2);
                // post1.setMessage("post1 message by user2");
                //
                // user2.addPost(post1);
                //
                // userPostsService.save(post1);
                // userService.update(user2);

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

                // testing comments
                // UserComments comment1 = new UserComments();
                // comment1.setOwnerId(user1);
                // comment1.setPostId(post1);
                // comment1.setMessage("comment1 in post1 message by user1");
                // userCommentsService.save(comment1);
                //
                // UserComments comment2 = new UserComments();
                // comment2.setOwnerId(user1);
                // comment2.setPostId(post1);
                // comment2.setMessage("comment2 in post1 message by user1");
                // userCommentsService.save(comment2);
                //
                // UserComments comment3 = new UserComments();
                // comment3.setOwnerId(user2);
                // comment3.setPostId(post1);
                // comment3.setMessage("comment3 in post1 message by user2");
                // userCommentsService.save(comment3);
                //
                // post1.addComment(comment1);
                // post1.addComment(comment2);
                // post1.addComment(comment3);
                // userPostsService.save(post1);
                //
                // //testing replies
                // UserReplies reply1 = new UserReplies();
                // reply1.setOwnerId(user1);
                // reply1.setCommentId(comment1);
                // reply1.setMessage("reply1 message by user1");
                // comment1.addReply(reply1);
                //
                // UserReplies reply2 = new UserReplies();
                // reply2.setOwnerId(user2);
                // reply2.setCommentId(comment1);
                // reply2.setMessage("reply2 message by user2");
                // comment1.addReply(reply2);
                //
                // UserReplies reply3 = new UserReplies();
                // reply3.setOwnerId(user3);
                // reply3.setCommentId(comment1);
                // reply3.setMessage("reply3 message by user3");
                // comment1.addReply(reply3);
                //
                // userCommentsService.save(comment1);
                //
                // for (UserReplies reply : userRepliesService.getAllReplies()) {
                // System.out.println(reply);
                // }
                //
                // for (UserComments comment : userCommentsService.getAllComment()) {
                // System.out.println(comment);
                // }
                //
                // for (UserPosts post : userPostsService.getAllPosts()) {
                // System.out.println(post);
                // }
                //
                // for (UserFollows follows : user1.getFollowers()) {
                // System.out.println(follows);
                // }

                /*
                 * List<UserReplies> repliesList = new ArrayList<>();
                 * for (UserReplies reply : userRepliesService.getAllReplies()) {
                 * repliesList.add(reply);
                 * }
                 * 
                 * comment1.setReplies(repliesList);
                 * userCommentsService.save(comment1);
                 */

                // testing groups
                // UserGroups group1 = new UserGroups();
                // group1.setOwnerId(user1);

                // User user1 = new User();
                // user1.setFirstName("Brandon");
                // user1.setUsername("b1");
                // user1.setPassword("password");
                // userService.save(user1);
                //
                // User user2 = new User();
                // user2.setFirstName("gio");
                // user2.setUsername("g1");
                // user2.setPassword("password");
                // userService.save(user2);
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
                //
                //
                // //testing comments
                // UserComments comment1 = new UserComments();
                // comment1.setOwnerId(user1);
                // comment1.setPostId(post1);
                // comment1.setMessage("comment1 in post1 message by user1");
                // userCommentsService.save(comment1);
                //
                // UserComments comment2 = new UserComments();
                // comment2.setOwnerId(user1);
                // comment2.setPostId(post1);
                // comment2.setMessage("comment2 in post1 message by user1");
                // userCommentsService.save(comment2);
                //
                // UserComments comment3 = new UserComments();
                // comment3.setOwnerId(user2);
                // comment3.setPostId(post1);
                // comment3.setMessage("comment3 in post1 message by user2");
                // userCommentsService.save(comment3);
                //
                // post1.addComment(comment1);
                // post1.addComment(comment2);
                // post1.addComment(comment3);
                // userPostsService.save(post1);
                //
                // //testing replies
                // UserReplies reply1 = new UserReplies();
                // reply1.setOwnerId(user1);
                // reply1.setCommentId(comment1);
                // reply1.setMessage("reply1 message by user1");
                // comment1.addReply(reply1);
                //
                // UserReplies reply2 = new UserReplies();
                // reply2.setOwnerId(user2);
                // reply2.setCommentId(comment1);
                // reply2.setMessage("reply2 message by user2");
                // comment1.addReply(reply2);
                //
                // UserReplies reply3 = new UserReplies();
                // reply3.setOwnerId(user3);
                // reply3.setCommentId(comment1);
                // reply3.setMessage("reply3 message by user3");
                // comment1.addReply(reply3);
                //
                // userCommentsService.save(comment1);
                //
                // for (UserReplies reply : userRepliesService.getAllReplies()) {
                // System.out.println(reply);
                // }
                //
                // for (UserComments comment : userCommentsService.getAllComment()) {
                // System.out.println(comment);
                // }
                //
                // for (UserPosts post : userPostsService.getAllPosts()) {
                // System.out.println(post);
                // }
                //
                // for (UserFollows follows : user1.getFollowers()) {
                // System.out.println(follows);
                // }
                //
                /// * List<UserReplies> repliesList = new ArrayList<>();
                // for (UserReplies reply : userRepliesService.getAllReplies()) {
                // repliesList.add(reply);
                // }
                //
                // comment1.setReplies(repliesList);
                // userCommentsService.save(comment1);*/
                //
                // //testing groups
                // UserGroups group1 = new UserGroups();
                // group1.setOwnerId(user1);

                /*
                 * User user1 = new User();
                 * user1.setFirstName("Brandon");
                 * user1.setUsername("b1");
                 * user1.setPassword("password");
                 * userService.save(user1);
                 * 
                 * User user2 = new User();
                 * user2.setFirstName("gio");
                 * user2.setUsername("g1");
                 * user2.setPassword("password");
                 * userService.save(user2);
                 * 
                 * 
                 * UserPosts post1 = new UserPosts();
                 * post1.setOwnerId(user1);
                 * post1.setLikes(2);
                 * post1.setMessage("post1 message by user1");
                 * userPostsService.save(post1);
                 * 
                 * UserPosts post2 = new UserPosts();
                 * post2.setOwnerId(user1);
                 * post2.setMessage("post2 message by user1");
                 * 
                 * 
                 * UserPosts post3 = new UserPosts();
                 * post3.setOwnerId(user1);
                 * post3.setMessage("post3 message by user1");
                 * 
                 * user1.addPost(post1);
                 * user1.addPost(post2);
                 * user1.addPost(post3);
                 * userService.save(user1);
                 * 
                 * 
                 * //testing comments
                 * UserComments comment1 = new UserComments();
                 * comment1.setOwnerId(user1);
                 * comment1.setPostId(post1);
                 * comment1.setMessage("comment1 in post1 message by user1");
                 * userCommentsService.save(comment1);
                 * 
                 * UserComments comment2 = new UserComments();
                 * comment2.setOwnerId(user1);
                 * comment2.setPostId(post1);
                 * comment2.setMessage("comment2 in post1 message by user1");
                 * userCommentsService.save(comment2);
                 * 
                 * UserComments comment3 = new UserComments();
                 * comment3.setOwnerId(user2);
                 * comment3.setPostId(post1);
                 * comment3.setMessage("comment3 in post1 message by user2");
                 * userCommentsService.save(comment3);
                 * 
                 * post1.addComment(comment1);
                 * post1.addComment(comment2);
                 * post1.addComment(comment3);
                 * userPostsService.save(post1);
                 * 
                 * //testing replies
                 * UserReplies reply1 = new UserReplies();
                 * reply1.setOwnerId(user1);
                 * reply1.setCommentId(comment1);
                 * reply1.setMessage("reply1 message by user1");
                 * comment1.addReply(reply1);
                 * 
                 * UserReplies reply2 = new UserReplies();
                 * reply2.setOwnerId(user2);
                 * reply2.setCommentId(comment1);
                 * reply2.setMessage("reply2 message by user2");
                 * comment1.addReply(reply2);
                 * 
                 * UserReplies reply3 = new UserReplies();
                 * reply3.setOwnerId(user3);
                 * reply3.setCommentId(comment1);
                 * reply3.setMessage("reply3 message by user3");
                 * comment1.addReply(reply3);
                 * 
                 * userCommentsService.save(comment1);
                 * 
                 * for (UserReplies reply : userRepliesService.getAllReplies()) {
                 * System.out.println(reply);
                 * }
                 * 
                 * for (UserComments comment : userCommentsService.getAllComment()) {
                 * System.out.println(comment);
                 * }
                 * 
                 * for (UserPosts post : userPostsService.getAllPosts()) {
                 * System.out.println(post);
                 * }
                 * 
                 * for (UserFollows follows : user1.getFollowers()) {
                 * System.out.println(follows);
                 * }
                 * 
                 */
                /*
                 * List<UserReplies> repliesList = new ArrayList<>();
                 * for (UserReplies reply : userRepliesService.getAllReplies()) {
                 * repliesList.add(reply);
                 * }
                 * 
                 * comment1.setReplies(repliesList);
                 * userCommentsService.save(comment1);
                 *//*
                    * 
                    * //testing groups
                    * UserGroups group1 = new UserGroups();
                    * group1.setOwnerId(user1);
                    */

                // testing conversations and messages
//                UserConversations conversations1 = new UserConversations();
//
//                UserMessages message1 = new UserMessages();
//                message1.setOwnerId(user1);
//                message1.setMessage("user1 sending message to user2");
//
//                conversations1.setRecipientId(user2);
//                conversations1.addMessage(message1);
//
//                user1.addConversation(conversations1);

                // UserClass: class names are pascal case
                // userClass: variable names camel case
                // user_id : database
                // all caps and underscore for constant variables

        }

}
