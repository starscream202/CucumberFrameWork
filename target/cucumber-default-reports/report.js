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
  "name": "API",
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
});