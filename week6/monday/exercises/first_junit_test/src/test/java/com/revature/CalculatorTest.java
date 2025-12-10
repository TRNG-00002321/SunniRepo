package com.revature;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    Calculator calc;

    @BeforeEach
    public void setup() {
        calc = new Calculator();
    }

    @Test
    @DisplayName("Adding Two Positive Numbers")
    public void add_postiveInt_returnsSum() {
        int expected = 8;
        int actual = calc.add(5, 3);
        Assertions.assertEquals(expected, actual, "5 + 3 = %d".formatted(actual));
    }

    @Test
    @DisplayName("Adding Positive And Negative Numbers")
    public void add_posNegInt_returnsSum() {
        int expected = 7;
        int actual = calc.add(10, -3);
        Assertions.assertEquals(expected, actual, "10 + -3 = %d".formatted(actual));
    }

    @Test
    @DisplayName("Adding Two Negative Numbers")
    public void add_twoNegInt_returnsSum() {
        int expected = -8;
        int actual = calc.add(-5, -3);
        Assertions.assertEquals(expected, actual, "-5 + -3 = %d".formatted(actual));
    }

    @Test
    @DisplayName("Adding Positive Number And Zero")
    public void add_zero_returnsSum() {
        int expected = 42;
        int actual = calc.add(42, 0);
        Assertions.assertEquals(expected, actual, "42 + 0 = %d".formatted(actual));
    }

    @Test
    @DisplayName("Subtract Two Positive Numbers")
    public void subtract_twoPosNums_returnsDiff() {
        int actual = calc.subtract(5, 3);
        Assertions.assertEquals(2, actual, "5 - 3 = %d".formatted(actual));
    }

    @Test
    @DisplayName("Subtract Larger Number")
    public void subtract_largeNumber_returnsDiff() {
        int actual = calc.subtract(5, 10);
        Assertions.assertEquals(-5, actual, "5 - 10 = %d".formatted(actual));
    }

    @Test
    @DisplayName("Subtract Zero Numbers")
    public void subtract_zero_returnsDiff() {
        int actual = calc.subtract(5, 0);
        Assertions.assertEquals(5, actual, "5 - 3 = %d".formatted(actual));
    }

    @Test
    @DisplayName("Checking parity of positive even numbers")
    public void isEven_postiveEvenValues_returnsTrue() {
        Assertions.assertAll(
                () -> Assertions.assertTrue(calc.isEven(2)),
                () -> Assertions.assertTrue(calc.isEven(4)),
                () -> Assertions.assertTrue(calc.isEven(100)));
    }

    @Test
    @DisplayName("Checking parity of positive odd numbers")
    public void isEven_postiveOddValues_returnsFalse() {
        Assertions.assertAll(
                () -> Assertions.assertFalse(calc.isEven(1)),
                () -> Assertions.assertFalse(calc.isEven(5)),
                () -> Assertions.assertFalse(calc.isEven(99)));
    }

    @Test
    @DisplayName("Checking parity of negative")
    public void isEven_negativeValues_returnsBool() {
        Assertions.assertAll(
                () -> Assertions.assertTrue(calc.isEven(-2)),
                () -> Assertions.assertFalse(calc.isEven(-5)),
                () -> Assertions.assertTrue(calc.isEven(-100)));
    }

    @Test
    @DisplayName("Checking parity of zero")
    public void isEven_postiveValues_returnsTrue() {
        Assertions.assertTrue(calc.isEven(0));
    }

    @Test
    @DisplayName("Checking if postive numbers are postive")
    public void isPositive_posVal_returnsTrue() {
        Assertions.assertAll(
                () -> Assertions.assertTrue(calc.isPositive(1)),
                () -> Assertions.assertTrue(calc.isPositive(5)),
                () -> Assertions.assertTrue(calc.isPositive(100)));
    }

    @Test
    @DisplayName("Checking if negative numbers are positive")
    public void isPositive_negVal_returnsFalse() {
        Assertions.assertAll(
                () -> Assertions.assertFalse(calc.isPositive(-1)),
                () -> Assertions.assertFalse(calc.isPositive(-5)),
                () -> Assertions.assertFalse(calc.isPositive(-100)));
    }

    @Test
    @DisplayName("Checking if zero is positive")
    public void isPositive_zero_returnsFalse() {
        Assertions.assertFalse(calc.isPositive(0));
    }
}
