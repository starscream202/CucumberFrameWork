#author Mohammed Uddin
  @Sarada
  Feature: Creating Sarada Lazy way

    Background:
      Given JWT is generated

    Scenario: Create Employee
      When get POST call to create employee
      Then the status code for creating employee is 201
      And the employee is created
      And Store employee ID
    Scenario: Update created employee
      Given request to update employee 2
      When a put call is made to update Employee
      Then status code is 201
      Then assert that response has "Message" and "Entry updated"