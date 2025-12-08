package com.revature.junitdemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class CalculatorSubtractTests {
    Calculator calculator = null;

    @BeforeEach
    void setup(){
        System.out.println("This is a setup method... Before Each");
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Positive Test - Subtract")
    void testSubtract(){
        //Arrange
        int n1 = 35;
        int n2 = 5;
        int expectedResult = 30;
        int actualResult;

        //Act
        actualResult = calculator.subtract(n1, n2);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest(name="{0} - {1} = {2}")
    @CsvFileSource(resources = "/subtractionData.csv", numLinesToSkip = 1)
    public void paramTestSubtract(int a, int b, int expectedResult){
        Assertions.assertEquals(expectedResult, calculator.subtract(a, b));
    }

}
