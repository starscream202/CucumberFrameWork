$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/SearchAndEmployee.feature");
formatter.feature({
  "name": "Search an Employee",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@searchEmployee"
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "skipped"
});
formatter.step({
  "name": "enter valid credentials",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.StepDefinitions.LoginStepDefinition.enter_valid_credentials()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "click on login button",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.StepDefinitions.LoginStepDefinition.click_on_login_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "go to Add Employee page",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.StepDefinitions.SearchEMployeeStepDefinition.go_to_Add_Employee_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "search employee job titles",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@searchEmployee"
    }
  ]
});
formatter.step({
  "name": "search for job_titles",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.StepDefinitions.SearchEMployeeStepDefinition.search_for_job_titles()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "all job title from db is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.StepDefinitions.DatabaseSteps.all_job_title_from_db_is_displayed()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "verify data is matched",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.after({
  "status": "skipped"
});
});