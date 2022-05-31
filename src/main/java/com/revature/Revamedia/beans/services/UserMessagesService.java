package com.revature.Revamedia.beans.services;

import com.revature.Revamedia.beans.repositories.UserMessagesRepository;
import com.revature.Revamedia.entities.User;
import com.revature.Revamedia.entities.UserMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserMessagesService {
    private final UserMessagesRepository userMessagesRepository;

    @Autowired
    public UserMessagesService(UserMessagesRepository userMessagesRepository) {
        this.userMessagesRepository = userMessagesRepository;
    }

    public UserMessages getMessageById(Integer id) {
        return userMessagesRepository.getById(id);
    }

    public UserMessages save(UserMessages message) {
        return userMessagesRepository.save(message);
    }

    public UserMessages update(UserMessages message) {
        return userMessagesRepository.save(message);
    }

    public List<UserMessages> getAllMessages() {
        return userMessagesRepository.findAll();
    }
}
