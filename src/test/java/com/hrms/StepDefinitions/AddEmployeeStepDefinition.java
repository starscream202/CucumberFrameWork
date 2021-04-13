package com.hrms.StepDefinitions;

import com.google.common.collect.Maps;
import com.hrms.Pages.LoginPage;
import com.hrms.Utils.*;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class AddEmployeeStepDefinition extends CommonMethods {

    @When("login to HRMS")
    public void login_to_HRMS() {
        LoginPage.login(ConfigReader.getPropertyValue("username"),ConfigReader.getPropertyValue("pass"));
        LoginPage.clickLoginButton();

    }

    @Then("navigate to Add Employee page")
    public void navigate_to_Add_Employee_page() {
        click(dbPage.PIM);
        click(dbPage.addEmp);
    }

    @When("Add employee without login details")
    public void add_employee_without_login_details() {
        addEmpPage.firstNameTextBox.clear();
        sendText(addEmpPage.firstNameTextBox, "Madara");
        addEmpPage.middleNameTextbox.clear();
        sendText(addEmpPage.middleNameTextbox, "9Tails");
        addEmpPage.lastNameTextbox.clear();
        sendText(addEmpPage.lastNameTextbox, "Uchiha");
        click(addEmpPage.saveButton);
    }

    @Then("validate that you added employee")
    public void validate_that_you_added_employee() {
        Assert.assertEquals("Validating Employee Was Added","Ronald Jefferson McDonald",getTextFromElement(pdPage.EmployeeName));
    }

    @When("add employee with login details")
    public void add_employee_with_login_details() {
        sendText(addEmpPage.firstNameTextBox, "Samual");
        sendText(addEmpPage.middleNameTextbox, "Dean");
        sendText(addEmpPage.lastNameTextbox, "Winchester");
        if(addEmpPage.createLoginCheckbox.isEnabled()){
            click(addEmpPage.createLoginCheckbox);
        }
        sendText(addEmpPage.username, "SamualWinchester1");
        sendText(addEmpPage.password, "SyntaxVampire123!");
        sendText(addEmpPage.rePassword, "SyntaxVampire123!");
        click(addEmpPage.saveButton);
    }

    @Then("validate that you added employee with login details")
    public void validate_that_you_added_employee_with_login_details() {
        Assert.assertEquals("Verify that you have added employee","Samual Dean Winchester",getTextFromElement(pdPage.EmployeeName));
    }
    @When("Add multiple employees and verify that they are stored")
    public void add_multiple_employees_and_verify_that_they_are_stored(DataTable employees) {
        List<Map<String,String>> employeenames= employees.asMaps();

        for(Map<String,String> employeeName: employeenames){
            String firstName=employeeName.get("FirstName");
            String middleName=employeeName.get("MiddleName");
            String lastName=employeeName.get("LastName");
            addEmpPage.enterFirst_Middle_Last_Name(firstName,middleName,lastName);
            click(addEmpPage.saveButton);
            String actualName=pdPage.EmployeeName.getText();
            String expected=firstName+" "+middleName+" "+lastName;
            Assert.assertEquals("Verifying Profile Name",expected,actualName);
            click(dbPage.addEmp);

        }

    }
    @When("add multiple employees {string} from excel and verify they are added")
    public void add_multiple_employees_from_excel_and_verify_they_are_added(String sheetname) {
        List<Map<String,String>>listdata= ExcelReading.excelIntoListMap(Constants.TESTDATA_FILEPATH,"Sheet1");

        for(Map<String, String> excelEmpName:listdata){
            String firstname=excelEmpName.get("First Name");
            String middlename=excelEmpName.get("Middle Name");
            String lastname=excelEmpName.get("Last Name");
            String employeeID=excelEmpName.get("ID");
            addEmpPage.enterFirst_Middle_Last_Name(firstname,middlename,lastname);
            addEmpPage.enterId(employeeID);
            click(addEmpPage.saveButton);
            String actualName=pdPage.EmployeeName.getText();
            String expected=firstname+" "+middlename+" "+lastname;
            Assert.assertEquals("Verifying Profile Name",expected,actualName);
            click(dbPage.addEmp);

        }
    }
    @When("add employee {string}, {string},{string} and verify")
    public void add_employee_and_verify(String firstname, String middlename, String lastname) {
        sendText(addEmpPage.firstNameTextBox, firstname);
        sendText(addEmpPage.middleNameTextbox, middlename);
        sendText(addEmpPage.lastNameTextbox, lastname);
        click(addEmpPage.saveButton);
    }
    @When("capture id")
    public void capture_id() {
        GlobalVariables.emp_Id = pdPage.personalID.getAttribute("value");
    }
    @Then("verify data from db is")
    public void verify_data_from_db_is() {//verify data is matched
        String empDataEntered="Madara 9Tails Uchiha";
        System.out.println(empDataEntered);
        System.out.println(GlobalVariables.dblist.toString());

    }






}
