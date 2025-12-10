package com.revature;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestValidateAge {

    UserValidation userValidation;

    @BeforeEach
    public void setup() {
        userValidation = new UserValidation();
    }

    @Test
    public void validateAge_validAge_returns() {
        Assertions.assertDoesNotThrow(() -> userValidation.validateAge(45));
    }

    @Test
    public void validateAge_negativeAge_throwsException() {
        IllegalArgumentException ex = Assertions.assertThrows(IllegalArgumentException.class, () -> userValidation.validateAge(-1));
        Assertions.assertTrue(ex.toString().contains("cannot be negative"));
    }

    @Test
    public void validateAge_overAge_throwsException() {
        IllegalArgumentException ex = Assertions.assertThrows(IllegalArgumentException.class, () -> userValidation.validateAge(151));
        Assertions.assertTrue(ex.toString().contains("cannot exceed 150"));
    }
}
