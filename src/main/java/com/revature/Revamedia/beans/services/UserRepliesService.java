package com.revature.Revamedia.beans.services;

import com.revature.Revamedia.beans.repositories.UserRepliesRepository;
import com.revature.Revamedia.entities.User;
import com.revature.Revamedia.entities.UserReplies;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRepliesService {
    private final UserRepliesRepository userRepliesRepository;

    public UserRepliesService(UserRepliesRepository userRepliesRepository) {
        this.userRepliesRepository = userRepliesRepository;
    }

    public UserReplies getReplyById(Integer id) {
        return userRepliesRepository.getById(id);
    }

    public UserReplies save(UserReplies reply) {
        return userRepliesRepository.save(reply);
    }

    public UserReplies update(UserReplies reply) {
        return userRepliesRepository.save(reply);
    }

    public List<UserReplies> getAllReplies() {
        return userRepliesRepository.findAll();
    }
    public void delete(UserReplies reply){ userRepliesRepository.delete(reply);}
}
