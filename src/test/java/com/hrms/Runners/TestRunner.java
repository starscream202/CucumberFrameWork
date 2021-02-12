package com.hrms.Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(   features = "src/test/resources/features", //give path for feature
                    glue= "com/hrms/StepDefinitions", //link step definitions
                    dryRun = true, //dry run will not run but check if u have unimplemented steps
                    tags= "@searchEmployee", //can run tags need {} for multiple tags
                    strict = false, //strict if there is an unimplemented step it will fail
                    plugin = {"pretty", //this will print out steps in console
                            "html:target/cucumber-default-reports", //genereates report in target folder
                            "rerun:target/FailedTests.txt", //if tests fail it will go into text file in target folder
                            "json:target/cucumber.json" //generates json reportsa+
                    }
)
public class TestRunner {



}
