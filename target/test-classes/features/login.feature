@feature @Smoke
Feature: Login Functionality

  Scenario: Login with valid credentials
    #Given navigate to HRMS login page
    When enter valid credentials
    And click on login button
    Then verify dashboard is displayed
    #And quit browser

    Scenario: Login with invalid credentials
      #Given navigate to HRMS login page
      When Enter invalid credentials
      And click on login button
      Then verify error message
      #And quit browser

  Scenario: Leave Username empty
    #Given navigate to HRMS login page
    When Leave usename empty and put valid pass
    And click on login button
    Then verify error message "Username cannot be empty"
    #And quit browser

  Scenario: Leave Pass empty
    #Given navigate to HRMS login page
    When put valid username but leave pass empty
    And click on login button
    Then verify Error Message  "Password cannot be empty"
    #And quit browser







