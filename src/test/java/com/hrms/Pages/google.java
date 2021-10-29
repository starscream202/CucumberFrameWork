package com.hrms.Pages;

import com.hrms.Utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class google extends CommonMethods {
    public @FindBy(xpath = "//input[contains(@class,'gL')]")
    WebElement search;
    public @FindBy(xpath = "//input[contains(@value,'Google Search')]")
    WebElement googleSearch;


    public void clickGoogleSearch(){
        click(googleSearch);
    }

    public void enterSearch(String ID){
        sendText(search,ID);
    }

    public google(){
        PageFactory.initElements(driver,this);
    }
}
