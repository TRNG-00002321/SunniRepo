package com.revature.junitdemo;
import org.junit.jupiter.api.*;

public class CalculatorTest {

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



}
