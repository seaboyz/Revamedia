package com.revature.Revamedia.beans.services;

import com.revature.Revamedia.beans.repositories.UserConversationsRepository;
import com.revature.Revamedia.entities.UserConversations;
import com.revature.Revamedia.entities.UserMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserConversationsService {
    private final UserConversationsRepository userConversationsRepository;

    @Autowired
    public UserConversationsService(UserConversationsRepository userConversationsRepository) {
        this.userConversationsRepository = userConversationsRepository;
    }

    public UserConversations getConversationById(Integer id) {
        return userConversationsRepository.getById(id);
    }

    public UserConversations save(UserConversations conversation) {
        return userConversationsRepository.save(conversation);
    }

    public UserConversations update(UserConversations conversation) {
        return userConversationsRepository.save(conversation);
    }

    public List<UserConversations> getAllConversations() {
        return userConversationsRepository.findAll();
    }
}
