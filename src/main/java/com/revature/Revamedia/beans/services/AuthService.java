package com.revature.Revamedia.beans.services;

import com.revature.Revamedia.beans.repositories.UserRepository;
import com.revature.Revamedia.dtos.UserLoginDto;
import com.revature.Revamedia.dtos.UserRegisterDto;
import com.revature.Revamedia.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.sql.Timestamp;
import java.time.LocalDateTime;


/**
 * @Author(s): Giorgi Amirajibi, Mohammad Foroutanyazdian, Fatemeh Goudarzi, Tony Henderson
 * @Contributor(s):  Kenneth Strohm, Randall Hale
 * Purpose: This is a service class for registering and authenticating a user.
 *          It uses a UserRepository object, that is injected in a constructor, to invoke CRUD functionality of Spring Data JPA.
 */

@Service
public class AuthService {

    private final UserRepository userRepository;

    @Autowired
    public AuthService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    /**
     * Method register: It returns a ResponseEntity object because we want to customize our response for frontend;
     *
     *                  Check we perform: if a user who is trying to register is already in the database.
     *                  Response we generate: http status 409 (conflict) and a response body stating that username is not unique.
     *
     *                  User passwords are encoded using BCryptPasswordEncoder which is part of Spring security.
     *
     *                  If email field is mapped as unique in database, during method invocation with a non-unique email
     *                  DataIntegrityViolationException is thrown. In this case we generate a response with http status 409 (conflict)
     *                  and a response body stating that email is not unique.
     *
     *                  If everything is successful we generate http status 200 (ok) and return a user.
     *
     */
    public ResponseEntity<Object> register(UserRegisterDto userRegisterDto){

        if (!userRepository.existsUserByUsername(userRegisterDto.getUsername()) ){
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
            User user = new User();
            user.setUsername(userRegisterDto.getUsername());
            user.setPassword(encoder.encode(userRegisterDto.getPassword()));
            user.setFirstName(userRegisterDto.getFirstName());
            user.setLastName(userRegisterDto.getLastName());
            user.setEmail(userRegisterDto.getEmail());
            user.setDateCreated(Timestamp.valueOf(LocalDateTime.now()));
            try {
                return ResponseEntity.ok(userRepository.save(user));
            }
            catch(DataIntegrityViolationException dive){
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Email is not unique");
            }
        }
        else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Username is not unique");
        }
    }

    public ResponseEntity<Object> login (UserLoginDto userLoginDto){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
        if (userRepository.existsUserByUsername(userLoginDto.getUsername())){
            if (encoder.matches(userLoginDto.getPassword(),userRepository.findByUsername(userLoginDto.getUsername()).getPassword())){
                return ResponseEntity.status(HttpStatus.OK).body("User Logged In");
            }
            else {
                return ResponseEntity.ok("Password didn't match");
            }
        }
        else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No such user");
        }
    }

}
