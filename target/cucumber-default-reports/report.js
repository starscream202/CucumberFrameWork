$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/google.feature");
formatter.feature({
  "name": "Search string on Google",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@google"
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "Open chrome browser",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.StepDefinitions.googleStepDefinition.openChromeBrowser()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Search string on Google",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@google"
    }
  ]
});
formatter.step({
  "name": "Enter Search \"Ash Uddin\"",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.StepDefinitions.googleStepDefinition.enterSearch(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
});