package com.hrms.Pages;

import com.hrms.Utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeaveListPage extends CommonMethods {

    @FindBy(id = "leaveList_cmbSubunit")
    public WebElement subUnitDD;

    public LeaveListPage(){
        PageFactory.initElements(driver,this);
    }

}
