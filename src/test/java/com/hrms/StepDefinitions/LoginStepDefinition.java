package com.hrms.StepDefinitions;

import com.hrms.Pages.LoginPage;
import com.hrms.Utils.CommonMethods;
import com.hrms.Utils.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinition extends CommonMethods {

    @Given("navigate to HRMS login page")
    public void navigate_to_hrms_login_page() {
        setUp();
    }

    @When("enter valid credentials")
    public void enter_valid_credentials() {
        LoginPage.login(ConfigReader.getPropertyValue("username"),ConfigReader.getPropertyValue("pass"));
    }

    @When("click on login button")
    public void click_on_login_button() {
        LoginPage.clickLoginButton();
    }

    @Then("verify dashboard is displayed")
    public void verify_dashboard_is_displayed() {
        Assert.assertTrue(dbPage.welcomeMessage.isDisplayed());
    }

    @Then("quit browser")
    public void quit_browser() throws InterruptedException {
        Thread.sleep(2000);
        tearDown();
    }

    @When("Enter invalid credentials")
    public void enter_invalid_credentials() {
        LoginPage.login("Admin","H@nhrm123");
    }

    @Then("verify error message")
    public void verify_error_message() {
        Assert.assertEquals("Verifying Error Message","Invalid credentials",loginPage.getErrorText());
    }

    @When("Leave usename empty and put valid pass")
    public void leave_usename_empty_and_put_valid_pass() {
        LoginPage.login("","Hum@nhrm123");
    }

    @Then("verify error message {string}")
    public void verify_error_message(String string) {
        Assert.assertEquals("Verifying Error Message", "Username cannot be empty", loginPage.getErrorText());
    }

    @When("put valid username but leave pass empty")
    public void put_valid_username_but_leave_pass_empty() {
        LoginPage.login("Admin","");
    }

    @Then("verify Error Message  {string}")
    public void verify_Error_Message(String string) {
        Assert.assertEquals("Verifying Error Message","Password cannot be empty",loginPage.getErrorText());
    }

}


