package com.revature.Revamedia.beans.services;

import com.revature.Revamedia.beans.repositories.UserRepository;
import com.revature.Revamedia.dtos.AuthDto;
import com.revature.Revamedia.dtos.CookieDto;
import com.revature.Revamedia.dtos.UserRegisterDto;
import com.revature.Revamedia.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @Author: Giorgi Amirajibi, Mohammad Foroutanyazdian, Fatemeh Goudarzi, Tony Henderson
 * @Contributor: Kenneth Strohm, Randall Hale
 */
@Service
public class AuthService {

    private final UserService userService;
    private final JsonWebToken jwt;

    @Autowired
    public AuthService(UserService userService, JsonWebToken jwt){
        this.jwt=jwt;
        this.userService = userService;
    }

    public ResponseEntity<Object> register(UserRegisterDto userRegisterDto){

        if (!userService.existsByUsername(userRegisterDto.getUsername())){
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
            User user = new User();
            user.setUsername(userRegisterDto.getUsername());
            user.setPassword(encoder.encode(userRegisterDto.getPassword()));
            user.setFirstName(userRegisterDto.getFirstName());
            user.setLastName(userRegisterDto.getLastName());
            user.setEmail(userRegisterDto.getEmail());
            return ResponseEntity.ok(userService.save(user));
        }
        else {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

    }

    /**
     * @Author: Terrell Crawford
     */
    public ResponseEntity<Object> login(AuthDto authDto) {
        //If user exists check stored password hash against given password else respond with code 404
        if (userService.existsByUsername((authDto.getUsername()))) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
            //loads user with matching username into user object
            User user = userService.findUserByUsername(authDto.getUsername());
            if (encoder.matches(authDto.getPassword(), user.getPassword())) {
                String headerValue = jwt.sign(new CookieDto(user));
                HttpHeaders headers= new HttpHeaders();
                headers.add("Set-Cookie", "user_session="+ headerValue +"; Max-Age=86400; Path=/;");
                //If the give password matches hashed password in DB t
                return ResponseEntity.ok().headers(headers).build();
            } else {
                //throw new UnauthorizedUserException("Unauthorized!");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
