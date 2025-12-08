package com.revature.junitdemo;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;


@Suite
@SelectClasses({CalculatorAddTests.class, CalculatorSubtractTests.class, CalculatorMultiplyTests.class, CalculatorDivideTests.class})
public class CalculatorTestSuite {

    @AfterEach
    public void tearDown(){
        System.out.println("This is a Tear Down method ... AfterEach");
    }

    @BeforeAll
    public static void setupClass(){

        System.out.println("Before All methods are called");
    }

    @AfterAll
    public static  void teardownClass(){
        System.out.println("After all methods are called");
    }
}
