$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/login.feature");
formatter.feature({
  "name": "Login Functionality",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@feature"
    },
    {
      "name": "@Smoke"
    }
  ]
});
formatter.scenario({
  "name": "Login with valid credentials",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@feature"
    },
    {
      "name": "@Smoke"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "enter valid credentials",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.StepDefinitions.LoginStepDefinition.enter_valid_credentials()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on login button",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.StepDefinitions.LoginStepDefinition.click_on_login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify dashboard is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.StepDefinitions.LoginStepDefinition.verify_dashboard_is_displayed()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded0.png", "Login with valid credentials");
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Login with invalid credentials",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@feature"
    },
    {
      "name": "@Smoke"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Enter invalid credentials",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.StepDefinitions.LoginStepDefinition.enter_invalid_credentials()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on login button",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.StepDefinitions.LoginStepDefinition.click_on_login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify error message",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.StepDefinitions.LoginStepDefinition.verify_error_message()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded1.png", "Login with invalid credentials");
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Leave Username empty",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@feature"
    },
    {
      "name": "@Smoke"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Leave usename empty and put valid pass",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.StepDefinitions.LoginStepDefinition.leave_usename_empty_and_put_valid_pass()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on login button",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.StepDefinitions.LoginStepDefinition.click_on_login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify error message \"Username cannot be empty\"",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.StepDefinitions.LoginStepDefinition.verify_error_message(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded2.png", "Leave Username empty");
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Leave Pass empty",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@feature"
    },
    {
      "name": "@Smoke"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "put valid username but leave pass empty",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.StepDefinitions.LoginStepDefinition.put_valid_username_but_leave_pass_empty()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on login button",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.StepDefinitions.LoginStepDefinition.click_on_login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify Error Message  \"Password cannot be empty\"",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.StepDefinitions.LoginStepDefinition.verify_Error_Message(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded3.png", "Leave Pass empty");
formatter.after({
  "status": "passed"
});
});