@multiple_employee
  Feature:
    Background:
      When enter valid credentials
      And click on login button
      Then navigate to Add Employee page

Scenario: Add multiple employees in one execution
  When Add multiple employees and verify that they are stored
  |FirstName|MiddleName|LastName|
  |Naruto | Minito| Uzamaki|
  |Sasuke | Itachi| Uchicha|

  Scenario: Adding multiple employee from excel
    When add multiple employees "Add_Employee" from excel and verify they are added

    Scenario Outline: Add employees with Scenario Outline
      When add employee "<firstname>", "<middlename>","<lastname>" and verify
      Examples:
      |firstname|middlename|lastname|
      |Kakashi  |The Copy Ninja  |Hatake|
      |Might    |The Blue Beast  |Guy   |
