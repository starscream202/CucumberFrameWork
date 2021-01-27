package com.hrms.Pages;

import com.hrms.Utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage extends CommonMethods {

    @FindBy(id= "welcome")
    public WebElement welcomeMessage;

    @FindBy(id="menu_pim_viewPimModule")
    public WebElement PIM;

    @FindBy(id="menu_pim_addEmployee")
    public WebElement addEmp;

    @FindBy(id="menu_pim_viewEmployeeList")
    public WebElement empList;

    @FindBy(id="menu_leave_viewLeaveModule")
    public WebElement leaveButton;


    public DashBoardPage(){
        PageFactory.initElements(driver,this);
    }

}
