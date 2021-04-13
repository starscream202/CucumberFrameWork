#Author: Mohammed Uddin
  @apiWorkflow
  Feature: Syntax hrms apiWorkflow

    Background:
      Given JWT is generated

      Scenario: Create Employee
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

          Scenario: Update created employee (patch)
            Given request to update employee
            When a put call is made to update employee
            Then status code is 201
            And The updated employee contains key "Message" and the value "Entry updated"
            And the retrieved EmployeeID matches the globally stored EmployeeID
            And the retrieved data matched the data used to create the employee



      Scenario: Update created employee (put)
        Given request to update employee 2
        When a put call is made to update Employee
        Then status code is 201
        Then assert that response has "Message" and "Entry updated"






      Scenario: Delete the created employee
        Given request is made to delete employee
        When delete call is made
        Then the status code is 201
        And employee is successfully deleted with the "message" in response "Entry deleted"
        And the "employee[0].employee_id" is same as one in gloabl

        Scenario: get all employees
          Given request is made to get all employees
          When a get call is made to get all employees
          Then status code is 200
          And employees are successfully retrieved with "Total Employees" and "Employees"

          Scenario: get all job titles
            Given request is made to get all job titles
            When get call is made to get all job titles
            Then assert that status code is 200
            And response has "Job Title List"

    Scenario: Get all employee status
      Given request is made to get employee statuses
      When get call is made to get statuses
      Then assert that status code is 200
      And assert the response matches



