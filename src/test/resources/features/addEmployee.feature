@feature
Feature: Add Employee
  @Regression
  Scenario: Add Employee without login details
    When login to HRMS
    Then navigate to Add Employee page
    When Add employee without login details
    Then validate that you added employee
    @Regression
    Scenario: Add Employee with login details
      When login to HRMS
      Then navigate to Add Employee page
      When add employee with login details
      Then validate that you added employee with login details
