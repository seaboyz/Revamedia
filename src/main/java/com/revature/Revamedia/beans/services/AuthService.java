package com.revature.Revamedia.beans.services;

import com.revature.Revamedia.beans.repositories.UserRepository;
import com.revature.Revamedia.dtos.UserRegisterDto;
import com.revature.Revamedia.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;

    @Autowired
    public AuthService(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    public User register(User user){

//        User user = new User();
//        user.setUsername(userRegisterDto.getUsername());
//        //BCrypt
//        user.setPassword(userRegisterDto.getPassword());
//        user.setFirstName(userRegisterDto.getFirstName());
//        user.setLastName(userRegisterDto.getLastName());
//        user.setEmail(userRegisterDto.getEmail());


        return userRepository.save(user);
    }
}
