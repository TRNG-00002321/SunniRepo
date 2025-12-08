package com.revature.junitdemo;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class CalculatorDivideTests {
    Calculator calculator = null;

    @BeforeEach
    void setup(){
        System.out.println("This is a setup method... Before Each");
        calculator = new Calculator();
    }
    @Test
    @DisplayName("Positive Test - Divide")
    void testDivide(){
        //Arrange
        int n1 = 35;
        int n2 = 5;
        int expectedResult = 7;
        int actualResult;

        //Act
        actualResult = calculator.divide(n1, n2);
        Assertions.assertEquals(expectedResult, actualResult);

    }
    @Test
    @DisplayName("Negative Test - Divide By Zero")
    @Disabled
    void testDivideByZero(){
        //Arrange
        int n1 = 35;
        int n2 = 0;

        //Act
        Assertions.assertThrows(IllegalArgumentException.class, () -> {calculator.divide(n1, n2);});

    }

    @ParameterizedTest(name="{0} / {1} = {2}")
    @CsvFileSource(resources = "/divisionData.csv", numLinesToSkip = 1)
    public void paramTestDivide(int a, int b, int expectedResult){
        Assertions.assertEquals(expectedResult, calculator.divide(a, b));
    }
}
