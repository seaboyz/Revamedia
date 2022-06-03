package com.revature.Revamedia.beans.services;

import com.revature.Revamedia.dtos.AuthDto;
import com.revature.Revamedia.dtos.UserRegisterDto;
import com.revature.Revamedia.entities.User;
import org.apache.coyote.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AuthServiceTest {
    private AuthService authService;

    @MockBean
    private UserService mockUserService;

    @MockBean
    private JsonWebToken mockJwt;

    @Mock
    private BCryptPasswordEncoder mockBCryptPasswordEncoder;

    public AuthServiceTest(@Autowired AuthService authService){
         this.authService=authService;
    }

    @BeforeEach
    public void beforeEach() {
        authService.setEncoder(mockBCryptPasswordEncoder);
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

        when(mockUserService.existsByUsername(any())).thenReturn(true);
        when(mockUserService.findUserByUsername(any())).thenReturn(exampleUser);
        when(mockBCryptPasswordEncoder.matches(any(), any())).thenReturn(true);
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
        when(mockBCryptPasswordEncoder.matches(any(), any())).thenReturn(false);
        when(mockUserService.existsByUsername(any())).thenReturn(true);
        when(mockUserService.findUserByUsername(any())).thenReturn(exampleUser);
        when(mockJwt.sign(any())).thenReturn("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJKc29uIjoie1widXNlcklkXCI6NCxcInVzZXJuYW1lXCI6XCJzaGFkeVwifSJ9.LSzPbhNAALEFrBWZPpf8KGvREormRNt3tXFkGMTvnU3-MPHw76JD5cmreZJMYaSwNt7H6YJlALCFAWobPAKWbw");
        authService.login(userToLogin);
        assertEquals(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(), authService.login(userToLogin));
        assertNotEquals(ResponseEntity.status(HttpStatus.NOT_FOUND).build(), authService.login(userToLogin));
    }

    @Test
    public void registerSucceedsAndReturnsUserWhenUsernameIsNotTaken(@Autowired AuthService authService) {
        UserRegisterDto userRegisterDtoToPassIn = new UserRegisterDto("username", "password", "John", "Doe", "email@email.com");
        when(mockBCryptPasswordEncoder.encode(userRegisterDtoToPassIn.getPassword())).thenReturn(userRegisterDtoToPassIn.getPassword());
        User user = new User();
        user.setUsername(userRegisterDtoToPassIn.getUsername());
        user.setPassword(userRegisterDtoToPassIn.getPassword());
        user.setFirstName(userRegisterDtoToPassIn.getFirstName());
        user.setLastName(userRegisterDtoToPassIn.getLastName());
        user.setEmail(userRegisterDtoToPassIn.getEmail());
        when(mockUserService.existsByUsername(any())).thenReturn(false);
        when(mockUserService.save(any())).thenReturn(user); // User passed in to mock will not be the same as actual method. New User is created in actual method.
        ResponseEntity responseToCheck = ResponseEntity.ok(user);

        ResponseEntity response = authService.register(userRegisterDtoToPassIn);

        assertEquals(response, responseToCheck);
    }

    @Test
    public void registerReturnsResponseEntityStatusConflictWhenUsernameIsTaken(@Autowired AuthService authService) {
        UserRegisterDto userRegisterDtoToPassIn = new UserRegisterDto("username", "password", "John", "Doe", "email@email.com");
        when(mockBCryptPasswordEncoder.encode(userRegisterDtoToPassIn.getPassword())).thenReturn(userRegisterDtoToPassIn.getPassword());
        User user = new User();
        user.setUsername(userRegisterDtoToPassIn.getUsername());
        user.setPassword(userRegisterDtoToPassIn.getPassword());
        user.setFirstName(userRegisterDtoToPassIn.getFirstName());
        user.setLastName(userRegisterDtoToPassIn.getLastName());
        user.setEmail(userRegisterDtoToPassIn.getEmail());
        when(mockUserService.existsByUsername(any())).thenReturn(true);
        when(mockUserService.save(any())).thenReturn(user);
        ResponseEntity responseToCheck = ResponseEntity.status(HttpStatus.CONFLICT).build();

        ResponseEntity response = authService.register(userRegisterDtoToPassIn);

        assertEquals(response, responseToCheck);
    }
 }






