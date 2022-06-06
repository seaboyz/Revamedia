package com.revature.Revamedia.beans.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.Revamedia.beans.services.AuthService;
import com.revature.Revamedia.dtos.AuthDto;
import com.revature.Revamedia.dtos.UserRegisterDto;

/**
 * @Author: Giorgi Amirajibi, Mohammad Foroutanyazdian, Fatemeh Goudarzi, Tony Henderson
 * @Contributor: Kenneth Strohm, Randall Hale
 */

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<Object> register(@Valid @RequestBody UserRegisterDto userRegisterDto) {
        return authService.register(userRegisterDto);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@Valid @RequestBody AuthDto authDto) {
        return authService.login(authDto);
    }
}
