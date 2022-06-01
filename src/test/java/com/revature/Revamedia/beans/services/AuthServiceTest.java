package com.revature.Revamedia.beans.services;

import com.revature.Revamedia.dtos.AuthDto;
import com.revature.Revamedia.entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AuthServiceTest {
    private AuthService authService;

    @MockBean
    private UserService mockUserService;

    @MockBean
    private JsonWebToken mockJwt;

    public AuthServiceTest(@Autowired AuthService authService){
         this.authService=authService;
    }

    @Test
    public void loginPassesWhenUsernameAndPasswordMatchInDB(){
        User exampleUser = new User();
        exampleUser.setUserId(4);
        exampleUser.setUsername("shady");
        exampleUser.setPassword("Password1!");
        exampleUser.setFirstName("Terrell");
        exampleUser.setLastName("Crawford");
        AuthDto userToLogin = new AuthDto("shady", "Password1!");
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
        exampleUser.setPassword(encoder.encode("Password1!"));
        when(mockUserService.existsByUsername(any())).thenReturn(true);
        when(mockUserService.findUserByUsername(any())).thenReturn(exampleUser);
        when(mockJwt.sign(any())).thenReturn("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJKc29uIjoie1widXNlcklkXCI6NCxcInVzZXJuYW1lXCI6XCJzaGFkeVwifSJ9.LSzPbhNAALEFrBWZPpf8KGvREormRNt3tXFkGMTvnU3-MPHw76JD5cmreZJMYaSwNt7H6YJlALCFAWobPAKWbw");
        authService.login(userToLogin);
        assertNotEquals(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(), authService.login(userToLogin));
        assertNotEquals(ResponseEntity.status(HttpStatus.NOT_FOUND).build(), authService.login(userToLogin));

    }

    @Test
    public void loginFailsWhenUserDoesntExist(){
        User exampleUser = new User();
        exampleUser.setUserId(4);
        exampleUser.setUsername("shady");
        exampleUser.setPassword("Password1!");
        exampleUser.setFirstName("Terrell");
        exampleUser.setLastName("Crawford");
        AuthDto userToLogin = new AuthDto("shady", "Password1!");
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
        exampleUser.setPassword(encoder.encode("Password1!"));
        when(mockUserService.existsByUsername(any())).thenReturn(false);
        when(mockUserService.findUserByUsername(any())).thenReturn(exampleUser);
        when(mockJwt.sign(any())).thenReturn("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJKc29uIjoie1widXNlcklkXCI6NCxcInVzZXJuYW1lXCI6XCJzaGFkeVwifSJ9.LSzPbhNAALEFrBWZPpf8KGvREormRNt3tXFkGMTvnU3-MPHw76JD5cmreZJMYaSwNt7H6YJlALCFAWobPAKWbw");
        authService.login(userToLogin);
        assertNotEquals(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(), authService.login(userToLogin));
        assertEquals(ResponseEntity.status(HttpStatus.NOT_FOUND).build(), authService.login(userToLogin));
    }

    @Test
    public void loginFailsWhenGivenWrongPassword(){
        User exampleUser = new User();
        exampleUser.setUserId(4);
        exampleUser.setUsername("shady");
        exampleUser.setPassword("Password0!");
        exampleUser.setFirstName("Terrell");
        exampleUser.setLastName("Crawford");
        AuthDto userToLogin = new AuthDto("shady", "Password1!");
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
        exampleUser.setPassword(encoder.encode("Password0!"));
        when(mockUserService.existsByUsername(any())).thenReturn(true);
        when(mockUserService.findUserByUsername(any())).thenReturn(exampleUser);
        when(mockJwt.sign(any())).thenReturn("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJKc29uIjoie1widXNlcklkXCI6NCxcInVzZXJuYW1lXCI6XCJzaGFkeVwifSJ9.LSzPbhNAALEFrBWZPpf8KGvREormRNt3tXFkGMTvnU3-MPHw76JD5cmreZJMYaSwNt7H6YJlALCFAWobPAKWbw");
        authService.login(userToLogin);
        assertEquals(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(), authService.login(userToLogin));
        assertNotEquals(ResponseEntity.status(HttpStatus.NOT_FOUND).build(), authService.login(userToLogin));
    }

 }






