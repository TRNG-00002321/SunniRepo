package com.revature.service;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.EmailClient;
import com.revature.UserRepository;
import com.revature.model.User;

@ExtendWith(MockitoExtension.class)  // Enables Mockito annotations
class UserServiceTest {

    @Mock
    private UserRepository repository;  // Mock the dependency

    @Mock
    private EmailClient emailClient;  // Mock the dependency

    @InjectMocks
    private UserService userService;  // Inject mocks automatically

    User existingUser = null;
    User newUser = null;

    @BeforeEach
    public void setup() {
        existingUser = new User(1L, "FirstName", "firstname@email.com");
        newUser = new User(null, "NewUser", "newuser@email.com");
    }

    @Test
    public void getUser_existingUser_returnsUser() {
        // Arrange
        Mockito.when(repository.findById(1l)).thenReturn(existingUser);
        // Act
        User actualUser = userService.getUser(1L);
        // Assert
        Assertions.assertEquals(existingUser, actualUser);
    }

    @Test
    public void getUser_nonExistingUser_returnsNull() {
        // Arrange
        Mockito.when(repository.findById(2L)).thenReturn(null);
        // Act
        User actualUser = userService.getUser(2L);
        // Assert
        Assertions.assertNull(actualUser);
    }

    @Test
    public void register_newUser_returnsTrue() {
        // Arrange
        Mockito.when(repository.findByEmail("newuser@email.com")).thenReturn(null);
        // Act
        boolean result = userService.register(newUser);
        // Assert
        Mockito.verify(repository, Mockito.times(1)).save(newUser);
        Assertions.assertTrue(result);

    }

    @Test
    public void register_existingUser_returnsFalse() {
        // Arrange
        Mockito.when(repository.findByEmail("firstname@email.com")).thenReturn(existingUser);
        // Act
        boolean result = userService.register(existingUser);
        // Assert
        Mockito.verify(repository, Mockito.times(0)).save(existingUser);
        Assertions.assertFalse(result);
    }

    @Test
    public void getActiveUsers_callsRepo_returnsUsers() {
        // Arrange
        List<User> activeUsers = new LinkedList<>();
        activeUsers.add(existingUser);
        Mockito.when(repository.findAllActive()).thenReturn(activeUsers);

        // Act
        List<User> result = userService.getActiveUsers();

        //Assert
        Assertions.assertEquals(activeUsers, result);
        Mockito.verify(repository, Mockito.times(1)).findAllActive();

    }
}
