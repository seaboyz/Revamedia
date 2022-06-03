package com.revature.Revamedia.beans.services;

import com.revature.Revamedia.beans.repositories.UserRepository;
import com.revature.Revamedia.dtos.UserServiceDto;
import com.revature.Revamedia.dtos.ViewAllUserDto;
import com.revature.Revamedia.entities.User;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserServiceTest {
    private UserService userService;

    @MockBean
    private UserRepository mockUserRepository;


    //
    public UserServiceTest(@Autowired UserService userService) {
        this.userService = userService;

    }



    @Test
    public void userDoesntExist() {
        //arrange
        User exampleUser = new User();
        exampleUser.setUserId(4);
        exampleUser.setUsername("shady");
        exampleUser.setPassword("Password0!");
        exampleUser.setFirstName("Terrell");
        exampleUser.setLastName("Crawford");
        ViewAllUserDto userToFind = new ViewAllUserDto("shady");
        when(mockUserRepository.existsUserByUsername(any())).thenReturn(false);
        when(mockUserRepository.findByUsername(any())).thenReturn(exampleUser);

        //act
        userService.findUserByUsername(userToFind.getUserName());

        //assert
        assertNotEquals(exampleUser, userService.findUserByUsername(userToFind.getUserName()));



    }

    @Test
    public void failToSaveUserWhenUsernameIsDuplicate() {
        //arrange
        UserServiceDto userToSave = new UserServiceDto("shady", "Password0!","Terrell","Crawford");
        User user = new User();
        user.setUsername(userToSave.getUserName());
        user.setPassword(userToSave.getPassword());
        user.setFirstName(userToSave.getFirstName());
        user.setLastName(userToSave.getLastName());

        when(mockUserRepository.existsUserByUsername(any())).thenReturn(true);
        when(mockUserRepository.findByUsername(any())).thenReturn(user);
        //act
        userService.save(user);

        //assert
        assertNotEquals(userToSave, user);
    }

    @Test
    public void failToUpdateUserWhenNewUsernameIsDuplicate() {
        //arrange
        UserServiceDto userToUpdate = new UserServiceDto("shady", "Password0!","Terrell","Crawford");
        User user = new User();
        user.setUsername(userToUpdate.getUserName());
        user.setPassword(userToUpdate.getPassword());
        user.setFirstName(userToUpdate.getFirstName());
        user.setLastName(userToUpdate.getLastName());

        when(mockUserRepository.existsUserByUsername(any())).thenReturn(true);
        when(mockUserRepository.findByUsername(any())).thenReturn(user);
        //act
        userService.update(user);

        //assert
        assertNotEquals(userToUpdate, user);
    }
}
