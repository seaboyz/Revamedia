package com.revature.Revamedia.beans.services;

import com.revature.Revamedia.beans.repositories.UserGroupsRepository;
import com.revature.Revamedia.entities.User;
import com.revature.Revamedia.entities.UserGroups;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserGroupsService {
    private final UserGroupsRepository userGroupsRepository;

    @Autowired
    public UserGroupsService(UserGroupsRepository userGroupsRepository) {
        this.userGroupsRepository = userGroupsRepository;
    }

    public UserGroups getGroupById(Integer id) {
        return userGroupsRepository.getById(id);
    }

    public UserGroups save(UserGroups group) {
        return userGroupsRepository.save(group);
    }

    public UserGroups update(UserGroups group) {
        return userGroupsRepository.save(group);
    }

    public List<UserGroups> getAllGroups() {
        return userGroupsRepository.findAll();
    }
}
