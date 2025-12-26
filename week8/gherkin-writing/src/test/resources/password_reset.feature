@password @security
Feature: Password Reset
  As a registered user
  I want to reset my password
  So that I can regain access to my account if I forget my password

  @smoke
  Scenario: Request password reset with valid email
    # TODO: Write the scenario
    Given the user is on the password reset page
    When the user enters email "example@email.com"
    And the user clicks the reset button
    Then the user should recieve and email with a reset link
    And the user should see a message containing "Check email for reset link"

  Scenario: Request password reset with invalid email format
    # TODO: Write the scenario
    Given the user is on the password reset page
    When the user enters email "invalid_email_format"
    And the user clicks the reset button
    Then the user remains on the reset page
    And the user should see a message containing "Invalid email"

  Scenario: Request password reset with unregistered email
    # TODO: Write the scenario
    # Note: For security, message should not reveal if email exists
    Given the user is on the password reset page
    When the user enters email "unregistered@email.com"
    And the user clicks the reset button
    Then the user should see a message containing "Check email for reset link"

  Scenario: Reset link expires after 24 hours
    # TODO: Write the scenario
    # Use time-based Given clause
    Given the user recieved an email with reset link more than 24 hours ago:
    When the user click the reset link
    Then the user is directed to a link expired page
    And the user should see a message containing "Reset link has expired"

  Scenario: Successfully reset password
    # TODO: Write the scenario
    # Include setting new password and verification
    Given the user recieve an email with the reset link less than 24 hours ago:
    And the user clicks the reset link
    And the user is redirected to a password reset page
    When the user enters new password "NewPassword"
    And the user reenters new password "NewPassword"
    And the user clicks the submit button
    Then the user should see a message containing "Password Updated Successfully"

  Scenario: Old password fails after reset
    Given the user "john@example.com" has reset their password to "NewPass123!"
    When the user attempts to login with email "john@example.com" and password "OldPass456!"
    Then the login should fail
    And an error message should indicate "Invalid credentials"

  Scenario: Password must meet complexity requirements
    # TODO: Write the scenario
    # Include scenarios for passwords that don't meet requirements
    Given the user has entered a password "invalid password"
    And the password "invalid password" does not meet requirements
    Then and error message should indicate "Invalid Password"
