package com.hrms.Pages;

import com.hrms.Utils.CommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalDetailsPage {

    public @FindBy(id="personal_txtEmployeeId")
    WebElement personalID;

    public @FindBy(xpath = "//div[@id='profile-pic']/h1")
    WebElement EmployeeName;




    public PersonalDetailsPage(){
        PageFactory.initElements(CommonMethods.driver,this);
    }

}
