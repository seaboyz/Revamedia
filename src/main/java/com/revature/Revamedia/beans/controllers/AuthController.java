package com.revature.Revamedia.beans.controllers;

import com.revature.Revamedia.beans.services.AuthService;
import com.revature.Revamedia.dtos.UserRegisterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

/**
 * @Author(s): Giorgi Amirajibi, Mohammad Foroutanyazdian, Fatemeh Goudarzi, Tony Henderson
 * @Contributor(s): Kenneth Strohm, Randall Hale
 * Purpose: It is used to receive/produce http requests/responses.
 *          This controller specifically deals with User registration and login.
 *          Uses AuthService object, that is injected in a constructor, to invoke CRUD functionality.
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


}
