package com.revature.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.user.dao.UserRepository;
import com.revature.user.model.User;
import com.revature.user.service.UserService;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock // create the mock UserRepository
    private UserRepository repo;
    @InjectMocks // Inject the mocked UserRepository into UserService
    private UserService service;
    private User existingUser;
    private User newUser;

    @BeforeEach
    public void setup() {
        existingUser = new User(1L, "Imran R", "imran@email.com");
        newUser = new User(null, "Sunni M", "sunni@email.com");
    }

    @Test
    public void testGetByUser_positive() {
        // Arrange
        Mockito.when(repo.findById(1L)).thenReturn(existingUser);

        // Act
        User foundUser = service.getUserById(1L);

        // Assert
        Assertions.assertEquals("Imran R", foundUser.getFirst());
        Mockito.verify(repo, Mockito.times(1)).findById(1L);
    }

    @Test
    // negative test for UserService.getUserById()
    public void testGetByUser_negative() {
        // Arrange
        Mockito.when(repo.findById(2L)).thenReturn(null);
        // Act
        User foundUser = service.getUserById(2L);
        // Assert
        Assertions.assertEquals(null, foundUser);
        Mockito.verify(repo, Mockito.times(1)).findById(2L);
    }

    @Test
    // positive test for UserService.register()
    public void testRegister_positive() {
        // Arrange
        Mockito.when(repo.findByEmail("sunni@email.com")).thenReturn(null);

        // Act
        boolean userSaved = service.register(newUser);

        // Assert
        Assertions.assertEquals(true, userSaved);
        Mockito.verify(repo, Mockito.times(1)).save(newUser);
    }

    @Test
    // negative test for UserService.regiter()
    public void testRegister_negative() {
        // Arrange
        Mockito.when(repo.findByEmail("sunni@email.com")).thenReturn(newUser);
        // Act
        boolean userSaved = service.register(newUser);

        // Assert
        Assertions.assertEquals(false, userSaved);
        Mockito.verify(repo, Mockito.times(0)).save(newUser);
    }
}
