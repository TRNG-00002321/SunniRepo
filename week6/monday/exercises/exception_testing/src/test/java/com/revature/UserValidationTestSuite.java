package com.revature;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SelectClasses({TestValidateEmail.class, TestValidatePassword.class, TestValidateAge.class})
@SuiteDisplayName("JUnit Platform Suite Demo")
public class UserValidationTestSuite {
}
