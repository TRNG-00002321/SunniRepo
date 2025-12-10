package com.revature;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestValidateEmail {

    UserValidation userValidation;

    @BeforeEach
    public void setup() {
        userValidation = new UserValidation();
    }

    @Test
    public void validateEmail_validEmail_doesNotThrow() {
        Assertions.assertDoesNotThrow(() -> userValidation.validateEmail("email@email.com"));
    }

    @Test
    public void validateEamil_nullEmail_throwsException() {
        IllegalArgumentException ex = Assertions.assertThrows(IllegalArgumentException.class, () -> userValidation.validateEmail(null));
        Assertions.assertTrue(ex.toString().contains("cannot be null"));
    }

    @Test
    public void validateEamil_emptyEmail_throwsException() {
        IllegalArgumentException ex = Assertions.assertThrows(IllegalArgumentException.class, () -> userValidation.validateEmail(""));
        Assertions.assertTrue(ex.toString().contains("cannot be empty"));
    }

    @Test
    public void validateEamil_noAtEmail_throwsException() {
        IllegalArgumentException ex = Assertions.assertThrows(IllegalArgumentException.class, () -> userValidation.validateEmail("email.com"));
        Assertions.assertTrue(ex.toString().contains("must contain @"));
    }

    @Test
    public void validateEamil_startAtEmail_throwsException() {
        IllegalArgumentException ex = Assertions.assertThrows(IllegalArgumentException.class, () -> userValidation.validateEmail("@email.com"));
        Assertions.assertTrue(ex.toString().contains("invalid format"));
    }

    @Test
    public void validateEamil_endAtEmail_throwsException() {
        IllegalArgumentException ex = Assertions.assertThrows(IllegalArgumentException.class, () -> userValidation.validateEmail("email.com@"));
        Assertions.assertTrue(ex.toString().contains("invalid format"));
    }
}
