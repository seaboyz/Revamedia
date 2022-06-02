/**
 *  Author(s): @Brandon Le, @Tony Henderson
 *  Contributor(s):@Stan Savelev, @William Bjerke
 *  Purpose: Added delete
 */

package com.revature.Revamedia.beans.services;

import com.revature.Revamedia.beans.repositories.UserPostsRepository;
import com.revature.Revamedia.entities.UserPosts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserPostsService {
    private final UserPostsRepository userPostsRepository;

    @Autowired
    public UserPostsService(UserPostsRepository userPostsRepository) {
        this.userPostsRepository = userPostsRepository;
    }

    public UserPosts getPostById(Integer id){return userPostsRepository.getById(id);}

    public UserPosts save(UserPosts post) {
        return userPostsRepository.save(post);
    }

    public UserPosts update(UserPosts post) {
        return userPostsRepository.save(post);
    }

    public List<UserPosts> getAllPosts() {
        return userPostsRepository.findAll();
    }

    public void deleteAllPosts(List<UserPosts> post){ userPostsRepository.deleteAll();}

    public void delete(UserPosts post){ userPostsRepository.delete(post);}

}
