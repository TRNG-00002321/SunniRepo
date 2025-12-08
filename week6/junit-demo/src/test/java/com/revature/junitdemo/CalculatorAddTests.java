package com.revature.junitdemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class CalculatorAddTests {
    Calculator calculator = null;

    @BeforeEach
    void setup(){
        System.out.println("This is a setup method... Before Each");
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Positive Test - Add")
    void testAdd(){
        //Arrange
        int n1 = 10;
        int n2 = 12;
        int expectedResult = 22;
        int actualResult;

        //Act
        actualResult = calculator.add(n1, n2);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Negative Test - Add")
    void testNegative(){

        //Arrange
        int n1 = 10;
        int n2 = 12;
        int expectedResult = 22;
        int actualResult;

        //Act
        actualResult = calculator.add(n1, n2);
        System.out.println("Test Add Negative");
        Assertions.assertEquals(expectedResult, actualResult, "");
    }

    @ParameterizedTest(name="{0} + {1} = {2}")
    @CsvFileSource(resources = "/additionData.csv", numLinesToSkip = 1)
    public void testAddParam(int a, int b, int expectedResult){
        Assertions.assertEquals(expectedResult, calculator.add(a, b));
    }
}
