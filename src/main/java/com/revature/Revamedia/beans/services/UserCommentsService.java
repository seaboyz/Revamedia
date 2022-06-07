package com.revature.Revamedia.beans.services;

import com.revature.Revamedia.beans.repositories.UserCommentsRepository;
import com.revature.Revamedia.entities.User;
import com.revature.Revamedia.entities.UserComments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCommentsService {
    private final UserCommentsRepository userCommentsRepository;

    @Autowired
    public UserCommentsService(UserCommentsRepository userCommentsRepository) {
        this.userCommentsRepository = userCommentsRepository;
    }

    public UserComments getCommentById(Integer id) {
        return userCommentsRepository.getById(id);
    }

    public UserComments save(UserComments comment) {
        return userCommentsRepository.save(comment);
    }

    public UserComments update(UserComments comment) {
        return userCommentsRepository.save(comment);
    }

    public List<UserComments> getAllComment() {
        return userCommentsRepository.findAll();
    }

    public void delete(UserComments comment) { userCommentsRepository.delete(comment);}
}
