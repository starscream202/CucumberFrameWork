package com.hrms.Pages;

import com.hrms.TestBase.PageInitializer;
import com.hrms.Utils.CommonMethods;
import com.hrms.Utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommonMethods {

    @FindBy(id = "txtUsername")
    public WebElement usernameTextbox;

    @FindBy(xpath = "//input[@id='txtPassword']")
    public WebElement passwordTextbox;

    @FindBy(css = "input#btnLogin")
    public WebElement loginButton;

    @FindBy(id="spanMessage")
    public WebElement message;

    public static void login(String username, String pass){

        sendText(loginPage.usernameTextbox, username);
        sendText(loginPage.passwordTextbox, pass);

    }

    public static void clickLoginButton(){
        click(loginPage.loginButton);
    }

    public String getErrorText(){
        return message.getText();
    }

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

}
