#Author: Starscream202@gmail.com
  @searchEmployee
  Feature: Search an Employee

    Background:
      When enter valid credentials
      And click on login button
      Then go to Add Employee page

      Scenario: search employee job titles
        When search for job_titles
        Then all job title from db is displayed
        And  verify data is matched
