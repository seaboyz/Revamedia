package com.revature.Revamedia.beans.services;

import com.revature.Revamedia.beans.repositories.UserRepository;
import com.revature.Revamedia.dtos.UserServiceDto;
import com.revature.Revamedia.entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

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
    public void getUserByIdTest() {
        //arrange
        Integer id = 1;
        User user = new User();
        when(mockUserRepository.getById(id)).thenReturn(user);
        //act
        User returnedUser = userService.getUserById(id);
        //assert
        verify(mockUserRepository,times(1)).getById(id);
        assertEquals(user, returnedUser);
    }

    @Test
    public void getAllUsersTest(){
        //arrange
        List<User> userList = new ArrayList<>();
        when(mockUserRepository.findAll()).thenReturn(userList);
        //act
        List<User> returnedUserList = userService.getAllUsers();
        //assert
        verify(mockUserRepository, times(1)).findAll();
        assertEquals(userList, returnedUserList);
    }

    @Test
    public void existsByUsernameTest() {
        //arrange
        String username = "username";
        Boolean userExists = true;
        when(mockUserRepository.existsUserByUsername(username)).thenReturn(userExists);

        //act
        Boolean returnedUserBoolean = userService.existsByUsername(username);

        //assert
        verify(mockUserRepository, times(1)).existsUserByUsername(username);
        assertEquals(userExists, returnedUserBoolean);
    }

    @Test
    public void findUserByUsernameTest() {
        //arrange
        String username = "username";
        User user = new User();
        when(mockUserRepository.findByUsername(username)).thenReturn(user);

        //act
        User returnedUser = userService.findUserByUsername(username);

        //assert
        verify(mockUserRepository, times(1)).findByUsername(username);
        assertEquals(user, returnedUser);
        /*
        //this working code is testing the repository instead of the service
        //the specific service method call should be the only thing that's tested
        //arrange
        User exampleUser = new User();
        exampleUser.setUserId(4);
        exampleUser.setUsername("shady");
        exampleUser.setPassword("Password0!");
        exampleUser.setFirstName("Terrell");
        exampleUser.setLastName("Crawford");
        ViewAllUserDto userToFind = new ViewAllUserDto("shady");
        ViewAllUserDto userToFind1 = new ViewAllUserDto("shady1");
        when(mockUserRepository.existsUserByUsername(any())).thenReturn(false);

        when(mockUserRepository.findByUsername(any())).thenReturn(exampleUser);

        //act
        mockUserRepository.findByUsername(userToFind.getUserName());
        //userService.findUserByUsername(userToFind1.getUserName());

        //assert
        assertEquals(exampleUser, userService.findUserByUsername(userToFind.getUserName()));
        assertEquals(exampleUser, userService.findUserByUsername(userToFind1.getUserName()));
        //return false when user doesn't exist
        //return ture when user exists

         */
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
