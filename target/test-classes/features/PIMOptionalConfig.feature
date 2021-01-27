@pimConfig
Feature:

  Background:
    When enter valid credentials
    And click on login button

  Scenario: Unchecking unnecessary checkboxes
    Then click on PIM
    Then click on Config DropDown
    When click on optional fields
    Then click on edit button
    And uncheck unnecessary checkboxes
    |Show SSN field in Personal Details|
    |Show SIN field in Personal Details|
    Then click save