$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/apiWorkflow.feature");
formatter.feature({
  "name": "Syntax hrms apiWorkflow",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@apiWorkflow"
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "JWT is generated",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.api.generateTokenSteps.jwt_is_generated()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@apiWorkflow"
    }
  ]
});
formatter.step({
  "name": "get POST call to create employee",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.get_POST_call_to_create_employee()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the status code for creating employee is 201",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.the_status_code_for_creating_employee_is(java.lang.Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the employee is created",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.the_employee_is_created()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Store employee ID",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.store_employee_ID()"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "JWT is generated",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.api.generateTokenSteps.jwt_is_generated()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "retrieving the created employee",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@apiWorkflow"
    }
  ]
});
formatter.step({
  "name": "request is prepared to retrieve created employee",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.request_is_prepared_to_retrieve_created_employee()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a get call is made",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.a_get_call_is_made()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Status code for retrieving created employee is 200",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.status_code_for_retrieving_created_employee_is(java.lang.Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the retrieved EmployeeID matches the globally stored EmployeeID",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.the_retrieved_EmployeeID_matches_the_globally_stored_EmployeeID()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the retrieved data matched the data used to create the employee",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.the_retrieved_data_matched_the_data_used_to_create_the_employee()"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "JWT is generated",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.api.generateTokenSteps.jwt_is_generated()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Update created employee",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@apiWorkflow"
    }
  ]
});
formatter.step({
  "name": "request to update employee",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.request_to_update_employee()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a put call is made to update employee",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.a_put_call_is_made_to_update_employee()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "status code is 201",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.status_code_is(java.lang.Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The updated employee contains key \"Message\" and the value \"Entry updated\"",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.the_updated_employee_contains_key_and_the_value(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the retrieved EmployeeID matches the globally stored EmployeeID",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.the_retrieved_EmployeeID_matches_the_globally_stored_EmployeeID()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the retrieved data matched the data used to create the employee",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.the_retrieved_data_matched_the_data_used_to_create_the_employee()"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "JWT is generated",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.api.generateTokenSteps.jwt_is_generated()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "retrieving the created employee",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@apiWorkflow"
    }
  ]
});
formatter.step({
  "name": "request is prepared to retrieve created employee",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.request_is_prepared_to_retrieve_created_employee()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a get call is made",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.a_get_call_is_made()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Status code for retrieving created employee is 200",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.status_code_for_retrieving_created_employee_is(java.lang.Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the retrieved EmployeeID matches the globally stored EmployeeID",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.the_retrieved_EmployeeID_matches_the_globally_stored_EmployeeID()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the retrieved data matched the data used to create the employee",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.the_retrieved_data_matched_the_data_used_to_create_the_employee()"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "JWT is generated",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.api.generateTokenSteps.jwt_is_generated()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Delete the created employee",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@apiWorkflow"
    }
  ]
});
formatter.step({
  "name": "request is made to delete employee",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.request_is_made_to_delete_employee()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "delete call is made",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.delete_call_is_made()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the status code is 201",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.the_status_code_is(java.lang.Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "employee is successfully deleted with the \"message\" in response \"Entry deleted\"",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.employee_is_successfully_deleted_with_the_in_response(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the \"employee[0].employee_id\" is same as one in gloabl",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.the_is_same_as_one_in_gloabl(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "JWT is generated",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.api.generateTokenSteps.jwt_is_generated()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "get all employees",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@apiWorkflow"
    }
  ]
});
formatter.step({
  "name": "request is made to get all employees",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.request_is_made_to_get_all_employees()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a get call is made to get all employees",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.a_get_call_is_made_to_get_all_employees()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "status code is 200",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.status_code_is(java.lang.Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "employees are successfully retrieved with \"Total Employees\" and \"Employees\"",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.employees_are_successfully_retrieved_with_and(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
});