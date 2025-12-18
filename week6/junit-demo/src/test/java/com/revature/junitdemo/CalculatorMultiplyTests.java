package com.revature.junitdemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@DisplayName("Calculator.multiply() Tests")
public class CalculatorMultiplyTests {

    Calculator calculator = null;

    @BeforeEach
    void setup() {
        // System.out.println("This is a setup method... Before Each");
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Positive Test - Multiply")
    void testMultiply() {
        //Arrange
        int n1 = 10;
        int n2 = 12;
        int expectedResult = 120;
        int actualResult;

        //Act
        actualResult = calculator.multiply(n1, n2);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest(name = "{0} * {1} = {2}")
    @CsvFileSource(resources = "/multiplicationData.csv", numLinesToSkip = 1)
    public void paramTestMultiply(int a, int b, int expectedResult) {
        Assertions.assertEquals(expectedResult, calculator.multiply(a, b));
    }
}
