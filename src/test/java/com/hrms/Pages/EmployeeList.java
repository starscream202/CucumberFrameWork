package com.hrms.Pages;

import com.hrms.Utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmployeeList extends CommonMethods{
    @FindBy(id="empsearch_id")
    public WebElement searchId;

    @FindBy(id="searchBtn")
    public WebElement searchButton;

    @FindBy(id="ohrmList_chkSelectAll")
    public WebElement empCheckbox;

    @FindBy(id="btnDelete")
    public WebElement deleteButton;

    @FindBy(xpath = "//table[@class='table hover']/tbody/tr/td")
    public WebElement noRecords;

    @FindBy(id = "dialogDeleteBtn")
    public WebElement dialogDeleteBtn;

    public void waitForDelete(){
        waitForClickability(deleteButton);
    }

    public EmployeeList(){
        PageFactory.initElements(CommonMethods.driver,this);
    }
}
