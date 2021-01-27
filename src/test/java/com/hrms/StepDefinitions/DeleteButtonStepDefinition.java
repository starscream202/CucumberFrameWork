package com.hrms.StepDefinitions;

import com.hrms.Pages.EmployeeList;
import com.hrms.Utils.CommonMethods;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;

public class DeleteButtonStepDefinition extends CommonMethods {
    @Then("navigate to employee list page")
    public void navigate_to_employee_list_page() {
        click(dbPage.PIM);
        click(dbPage.empList);
    }

    @When("delete all employees and verify")
    public void delete_all_employees()  {
        while(empList.empCheckbox.isEnabled()){
            if(empList.empCheckbox.isEnabled()){
                click(empList.empCheckbox);
            }
            click(empList.deleteButton);
            /*String expected="Delete records?";
            String actual=empList.dialogDeleteBtn.getText();
            Assert.assertEquals("Verifying we deleted employees",expected,actual);*/
            empList.dialogDeleteBtn.click();
            break;
        }
    }


}
