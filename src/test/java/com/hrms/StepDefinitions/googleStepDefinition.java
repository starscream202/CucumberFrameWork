package com.hrms.StepDefinitions;

import com.hrms.Pages.LoginPage;
import com.hrms.Utils.CommonMethods;
import com.hrms.Utils.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class googleStepDefinition extends CommonMethods {

    @Given("Open chrome browser")
    public void openChromeBrowser() {
        setUp();
    }

    @When("Enter Search {string}")
    public void enterSearch(String string) {
        googlePage.enterSearch(string);
        googlePage.clickGoogleSearch();
    }
}
