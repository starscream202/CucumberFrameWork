#Author: Mohammed Uddin
  @apiWorkflow
  Feature: Syntax hrms apiWorkflow

    Background:
      Given JWT is generated

      Scenario: API
        When get POST call to create employee
        Then the status code for creating employee is 201
        And the employee is created
        And Store employee ID

        Scenario: retrieving the created employee
          When request is prepared to retrieve created employee
          Then a get call is made
          Then Status code for retrieving created employee is 200
          And the retrieved EmployeeID matches the globally stored EmployeeID
          And the retrieved data matched the data used to create the employee
