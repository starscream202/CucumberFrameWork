package com.hrms.StepDefinitions;

import com.hrms.Utils.CommonMethods;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchEMployeeStepDefinition extends CommonMethods {

    @Then("go to Add Employee page")
    public void go_to_Add_Employee_page() {
        click(dbPage.PIM);
    }

    @When("search for job_titles")
    public void search_for_job_titles() {
       List<String> DDelements=getDDValuesAndStoreInList(empList.jobTitleDD,"LOL");


    }

}
