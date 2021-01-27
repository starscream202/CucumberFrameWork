package com.hrms.Pages;

import com.hrms.Utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ConfigurationPage extends CommonMethods {
    @FindBy (id = "menu_pim_Configuration")
    public WebElement configDD;

    @FindBy(id = "menu_pim_configurePim")
    public WebElement optionalFields;

    @FindBy(xpath = "//input[@value='Edit']")
    public WebElement editButton;

    @FindBy(xpath = "//li[@class='checkbox']")
    public List<WebElement> checkboxes;

    public void clickOnConfigDD(){
        jsClick(configDD);
    }

    public void clickOnOptionalFields(){
        jsClick(optionalFields);
    }

    public void clickOnEdit(){
        jsClick(editButton);
    }

    public ConfigurationPage(){
        PageFactory.initElements(driver,this);
    }


}
