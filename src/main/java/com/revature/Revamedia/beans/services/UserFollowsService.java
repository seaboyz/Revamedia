package com.revature.Revamedia.beans.services;

import com.revature.Revamedia.beans.repositories.UserFollowsRepository;
import com.revature.Revamedia.entities.UserFollows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserFollowsService {
    private final UserFollowsRepository userFollowsRepository;

    @Autowired
    public UserFollowsService(UserFollowsRepository userFollowsRepository) {
        this.userFollowsRepository = userFollowsRepository;
    }

    public UserFollows getFollowById(Integer id) {
        return userFollowsRepository.getById(id);
    }

    public UserFollows save(UserFollows follow) {
        return userFollowsRepository.save(follow);
    }

    public UserFollows update(UserFollows follow) {
        return userFollowsRepository.save(follow);
    }

    public List<UserFollows> getAllFollows() {
        return userFollowsRepository.findAll();
    }

}
