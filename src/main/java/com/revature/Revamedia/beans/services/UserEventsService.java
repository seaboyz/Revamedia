package com.revature.Revamedia.beans.services;

import com.revature.Revamedia.beans.repositories.UserEventsRepository;
import com.revature.Revamedia.entities.User;
import com.revature.Revamedia.entities.UserEvents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserEventsService {
    private final UserEventsRepository userEventsRepository;

    @Autowired
    public UserEventsService(UserEventsRepository userEventsRepository) {
        this.userEventsRepository = userEventsRepository;
    }

    public UserEvents getEventById(Integer id) {
        return userEventsRepository.getById(id);
    }

    public UserEvents save(UserEvents event) {
        return userEventsRepository.save(event);
    }

    public UserEvents update(UserEvents event) {
        return userEventsRepository.save(event);
    }

    public List<UserEvents> getAllEvents() {
        return userEventsRepository.findAll();
    }
}
