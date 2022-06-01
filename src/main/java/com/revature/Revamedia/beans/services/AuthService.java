package com.revature.Revamedia.beans.services;

import com.revature.Revamedia.beans.repositories.UserRepository;
import com.revature.Revamedia.dtos.UserRegisterDto;
import com.revature.Revamedia.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @Author: Giorgi Amirajibi, Mohammad Foroutanyazdian, Fatemeh Goudarzi, Tony Henderson
 * @Contributor: Kenneth Strohm, Randall Hale
 */
@Service
public class AuthService {

    private final UserRepository userRepository;

    @Autowired
    public AuthService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User register(UserRegisterDto userRegisterDto){

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
        User user = new User();
        user.setUsername(userRegisterDto.getUsername());
        user.setPassword(encoder.encode(userRegisterDto.getPassword()));
        user.setFirstName(userRegisterDto.getFirstName());
        user.setLastName(userRegisterDto.getLastName());
        user.setEmail(userRegisterDto.getEmail());

        return userRepository.save(user);
    }
}
