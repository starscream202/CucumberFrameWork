package com.hrms.Pages;

import com.hrms.Utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEmployeePage extends CommonMethods{
    public @FindBy(id="firstName")
    WebElement firstNameTextBox;

    public @FindBy(id="middleName")
    WebElement middleNameTextbox;

    public @FindBy(id="lastName")
    WebElement lastNameTextbox;

    public @FindBy(id="employeeId")
    WebElement empIDTextbox;

    public @FindBy(id="btnSave")
    WebElement saveButton;

    public @FindBy(id="chkLogin")
    WebElement createLoginCheckbox;

    public @FindBy(id="user_name")
    WebElement username;

    public @FindBy(id="user_password")
    WebElement password;

    public @FindBy(id="re_password")
    WebElement rePassword;

    public @FindBy(id = "photofile")
    WebElement browseBtn;

    public void enterFirst_Middle_Last_Name(String first,String middle, String last){
        sendText(firstNameTextBox,first);
        sendText(middleNameTextbox, middle);
        sendText(lastNameTextbox,last);

    }
    public void enterId(String ID){
        sendText(empIDTextbox,ID);
    }
    public String getId(){
        String id= addEmpPage.empIDTextbox.getText();
        return id;
    }


    public AddEmployeePage(){
        PageFactory.initElements(CommonMethods.driver,this);
    }

}
