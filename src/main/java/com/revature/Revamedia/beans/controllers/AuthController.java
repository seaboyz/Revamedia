package com.revature.Revamedia.beans.controllers;

import com.revature.Revamedia.beans.services.AuthService;
import com.revature.Revamedia.beans.services.JsonWebToken;
import com.revature.Revamedia.dtos.AuthDto;
import com.revature.Revamedia.dtos.CookieDto;
import com.revature.Revamedia.dtos.UserRegisterDto;
import com.revature.Revamedia.entities.User;
import com.revature.Revamedia.exceptions.UnauthorizedUserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

/**
 * @Author: Giorgi Amirajibi, Mohammad Foroutanyazdian, Fatemeh Goudarzi, Tony Henderson
 * @Contributor: Kenneth Strohm, Randall Hale
 */

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    private final JsonWebToken jwt;

    @Autowired
    public AuthController(AuthService authService, JsonWebToken jwt){
        this.jwt=jwt;
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<Object> register(@Valid @RequestBody UserRegisterDto userRegisterDto) {
        return authService.register(userRegisterDto);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@Valid @RequestBody AuthDto authDto, @CookieValue (name = "user_session", required = false) String userSession
    ){
        if(userSession==null){
            return authService.login(authDto);
        }else {
            CookieDto userCookie = new CookieDto();
            try {
                userCookie = jwt.verify(userSession);
                System.out.println(userCookie.getUserId() + " " + userCookie.getUsername());
                //return authService.login(authDto);
                return ResponseEntity.status(HttpStatus.OK).build();
            } catch (UnauthorizedUserException u) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        }


    }


}
