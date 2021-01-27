package com.hrms.StepDefinitions;

import com.hrms.Utils.CommonMethods;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PIMConfigStepDefinition extends CommonMethods {
    @Then("click on PIM")
    public void click_on_PIM() {
        jsClick(dbPage.PIM);
    }

    @Then("click on Config DropDown")
    public void click_on_Config_DropDown() {
        click(configPage.configDD);
    }

    @When("click on optional fields")
    public void click_on_optional_fields() {
        click(configPage.optionalFields);
    }


    @Then("click on edit button")
    public void click_on_edit_button() {
        configPage.clickOnEdit();
    }

    @Then("uncheck unnecessary checkboxes")
    public void uncheck_unnecessary_checkboxes(DataTable checkboxOptions) {
        List<String> expectedCheckboxes=checkboxOptions.asList();
        for (int i = 0; i <expectedCheckboxes.size() ; i++) {
            clickRadioorCheckboxbyText(configPage.checkboxes,expectedCheckboxes.get(i));
        }

    }

    @Then("click save")
    public void click_save() {
        jsClick(addEmpPage.saveButton);
    }


}
