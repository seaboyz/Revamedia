package com.revature.Revamedia.beans.controllers;


import com.revature.Revamedia.beans.services.JsonWebToken;
import com.revature.Revamedia.beans.services.SendEmailService;
import com.revature.Revamedia.beans.services.UserService;
import com.revature.Revamedia.dtos.CookieDto;
import com.revature.Revamedia.dtos.EmailDto;
import com.revature.Revamedia.dtos.ResetPasswordDto;
import com.revature.Revamedia.entities.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/forgot")
public class ForgotPasswordController {

    private final SendEmailService sendEmailService;
    private final UserService userService;
    private final JsonWebToken jsonWebToken;

    public ForgotPasswordController(SendEmailService sendEmailService, UserService userService,JsonWebToken jsonWebToken){
        this.sendEmailService = sendEmailService;
        this.userService = userService;
        this.jsonWebToken = jsonWebToken;
    }

    @PostMapping
    public ResponseEntity<Object> generateEmail(@RequestBody EmailDto emailDto){
        sendEmailService.sendEmail(emailDto.getEmail());
        return ResponseEntity.ok("Email was sent to " + emailDto.getEmail());

    }

    @PostMapping("/{jwt}")
    public ResponseEntity<Object> resetPassword(@PathVariable String jwt, @RequestBody ResetPasswordDto resetPasswordDto){
        System.out.println("this is jwt " + jwt);
        System.out.println("this is password to reset to " + resetPasswordDto.getPassword());
        CookieDto cookieDto = jsonWebToken.verify(jwt);
        User currentUser = userService.findByEmail(cookieDto.getEmail());
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
        currentUser.setPassword(encoder.encode(resetPasswordDto.getPassword()));
        userService.update(currentUser);
        return ResponseEntity.status(HttpStatus.OK).body("Password reset was successful");
    }

}
