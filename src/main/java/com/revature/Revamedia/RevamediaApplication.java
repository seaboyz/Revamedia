package com.revature.Revamedia;

import com.revature.Revamedia.beans.services.UserFollowsService;
import com.revature.Revamedia.beans.services.UserService;
import com.revature.Revamedia.entities.User;
import com.revature.Revamedia.entities.UserFollows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = "com.revature.Revamedia.beans")
public class RevamediaApplication {
    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(RevamediaApplication.class, args);

        UserService userService = context.getBean(UserService.class);
        UserFollowsService userFollowsService = context.getBean(UserFollowsService.class);


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

        UserFollows follow1 = new UserFollows();
        follow1.setFollowedId(userService.getUserById(1));
        follow1.setFollowerId(userService.getUserById(2));
        userFollowsService.save(follow1);

        UserFollows follow2 = new UserFollows();
        follow2.setFollowedId(userService.getUserById(2));
        follow2.setFollowerId(userService.getUserById(1));
        userFollowsService.save(follow2);

        UserFollows follow3 = new UserFollows();
        follow3.setFollowedId(userService.getUserById(1));
        follow3.setFollowerId(userService.getUserById(2));
        userFollowsService.save(follow3);

    }
}