@deleteButton
Feature:
  Scenario:
    When enter valid credentials
    And click on login button
    Then navigate to employee list page
    When delete all employees and verify
