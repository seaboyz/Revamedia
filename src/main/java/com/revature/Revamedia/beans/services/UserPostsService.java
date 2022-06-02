/**
 *  Author(s): @Brandon Le, @Tony Henderson
 *  Contributor(s):@Stan Savelev, @William Bjerke
 *  Purpose: Added delete
 */

package com.revature.Revamedia.beans.services;

import com.revature.Revamedia.beans.repositories.UserPostsRepository;
<<<<<<< HEAD
=======
import com.revature.Revamedia.beans.repositories.UserRepository;
import com.revature.Revamedia.dtos.UpdatePostLikesDto;
import com.revature.Revamedia.entities.User;
import com.revature.Revamedia.entities.UserComments;
>>>>>>> dev
import com.revature.Revamedia.entities.UserPosts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserPostsService {
    private final UserPostsRepository userPostsRepository;
    private final UserRepository userRepository;

    @Autowired
    public UserPostsService(UserPostsRepository userPostsRepository, UserRepository userRepository) {
        this.userPostsRepository = userPostsRepository;
        this.userRepository = userRepository;
    }

    public UserPosts getPostById(Integer id){return userPostsRepository.getById(id);}

    public UserPosts save(UserPosts post) {
        return userPostsRepository.save(post);
    }

    public UserPosts update(UserPosts post) {
        return userPostsRepository.save(post);
    }

    public UserPosts updatePostLikes(UpdatePostLikesDto dto) {
        UserPosts post = userPostsRepository.getById(dto.getPostId());
        User user = userRepository.getById(dto.getUserId());

        if (user.getLikedPosts().contains(post)) {
            Set<User> usersLiked = post.getLikes();
            usersLiked.remove(user);
            post.setLikes(usersLiked);
            this.update(post);
            List<UserPosts> postsLiked = user.getLikedPosts();
            postsLiked.remove(post);
            user.setLikedPosts(postsLiked);
            userRepository.save(user);
        } else {
            Set<User> usersLiked = post.getLikes();
            usersLiked.add(user);
            post.setLikes(usersLiked);
            this.update(post);
            List<UserPosts> postsLiked = user.getLikedPosts();
            postsLiked.add(post);
            user.setLikedPosts(postsLiked);
            userRepository.save(user);
        }

        return post;
    }

    public List<UserPosts> getPostsByUser(Integer userId) {
        return userPostsRepository.getUserPostsByUser(userId);
    }

    public List<UserPosts> getAllPosts() {
        return userPostsRepository.findAll();
    }

    public void deleteAllPosts(List<UserPosts> post) {
        userPostsRepository.deleteAll();
    }

    public void delete(UserPosts post) {
        userPostsRepository.delete(post);
    }

}
