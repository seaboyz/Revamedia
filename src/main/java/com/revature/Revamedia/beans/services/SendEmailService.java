package com.revature.Revamedia.beans.services;

import com.revature.Revamedia.dtos.CookieDto;
import com.revature.Revamedia.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class SendEmailService {

    private final JavaMailSender emailSender;
    private final UserService userService;

    private final JsonWebToken jsonWebToken;

    @Autowired
    public SendEmailService(JavaMailSender emailSender,UserService userService, JsonWebToken jsonWebToken){
        this.emailSender = emailSender;
        this.userService = userService;
        this.jsonWebToken = jsonWebToken;
    }

    public ResponseEntity<Object> sendEmail(String email){
        SimpleMailMessage message = new SimpleMailMessage();
        if (userService.existsByEmail(email)){
            User currentUser = userService.findByEmail(email);
            CookieDto cookieDto = new CookieDto();
            cookieDto.setUserId(currentUser.getUserId());
            cookieDto.setUsername(currentUser.getUsername());
            cookieDto.setEmail(currentUser.getEmail());
            String jwt = jsonWebToken.sign(cookieDto);
            message.setFrom("Nolovexx@gmail.com");
            message.setTo(email);
            message.setSubject("Password Reset");
            message.setText("Please click on this link to reset your password http://localhost:8080/forgot/"+jwt);
            emailSender.send(message);
        }

        return ResponseEntity.status(HttpStatus.OK).body("Email was sent");
    }
}
