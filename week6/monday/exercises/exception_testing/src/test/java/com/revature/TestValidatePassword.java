package com.revature;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("UserValidation::validatePassword Tests")
public class TestValidatePassword {

    UserValidation userValidation;

    @BeforeEach
    public void setup() {
        userValidation = new UserValidation();
    }

    @Test
    public void validatePassword_validPassword_Returns() {
        Assertions.assertDoesNotThrow(() -> userValidation.validatePassword("Password123"));
    }

    @Test
    public void validatePassword_nullPassword_throwsException() {
        ValidationException ex = Assertions.assertThrows(ValidationException.class, () -> userValidation.validatePassword(null));
        Assertions.assertTrue(ex.toString().contains("cannot be null"));
    }

    @Test
    public void validatePassword_shortPassword_throwsException() {
        ValidationException ex = Assertions.assertThrows(ValidationException.class, () -> userValidation.validatePassword("short"));
        Assertions.assertTrue(ex.toString().contains("at least 8 characters"));
    }

    @Test
    public void validatePassword_noCapPassword_throwsException() {
        ValidationException ex = Assertions.assertThrows(ValidationException.class, () -> userValidation.validatePassword("nouppercase"));
        Assertions.assertTrue(ex.toString().contains("contain an uppercase letter"));
    }

    @Test
    public void validatePassword_noLowerPassword_throwsException() {
        ValidationException ex = Assertions.assertThrows(ValidationException.class, () -> userValidation.validatePassword("NOLOWERCASE"));
        Assertions.assertTrue(ex.toString().contains("contain a lowercase letter"));
    }

    @Test
    public void validatePassword_multipleInvalidPasswords_allThrowExceptions() {
        Assertions.assertAll(
                () -> Assertions.assertThrows(ValidationException.class, () -> userValidation.validatePassword("short")),
                () -> Assertions.assertThrows(ValidationException.class, () -> userValidation.validatePassword("nouppercase")),
                () -> Assertions.assertThrows(ValidationException.class, () -> userValidation.validatePassword("NOLOWERCASE"))
        );
    }
}
