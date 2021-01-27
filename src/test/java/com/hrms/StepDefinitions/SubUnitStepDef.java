package com.hrms.StepDefinitions;

import com.hrms.Utils.CommonMethods;
import io.cucumber.java.en.Then;

public class SubUnitStepDef extends CommonMethods {

    @Then("click on leave button")
    public void click_on_leave_button() {
        jsClick(dbPage.leaveButton);
    }

    @Then("select drop down")
    public void select_drop_down() throws InterruptedException {
        selectDropDownValue(LLPage.subUnitDD, 4);
        Thread.sleep(2000);
    }

}
