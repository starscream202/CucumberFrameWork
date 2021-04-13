package com.hrms.Utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.hrms.TestBase.BaseClass;
import com.hrms.TestBase.PageInitializer;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CommonMethods extends PageInitializer {

    /**
     * clears text field and sends keys
     * @param element
     * @param text
     */
    public static void sendText(WebElement element, String text){
        element.clear();
        element.sendKeys(text);
    }
    /**
     * set up firefox browser
     * @param url
     */

    /**
     * this method will return an object of Explicit wait with time set to 20 sec
     * @return WebDriverWait
     */
    public static WebDriverWait getWait(){
        WebDriverWait wait = new WebDriverWait(BaseClass.driver,Constants.EXPLICIT_WAIT_TIME);
        return wait;
    }

    /**
     * this method will wait for until given element is clickable
     * @param element
     */
    public static void waitForClickability(WebElement element){
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    /**(
     * this method will wait till and then click
     * @param element
     */
    public static void click(WebElement element){
        waitForClickability(element);
        element.click();
    }

    public static JavascriptExecutor getJSExecutor(){
        JavascriptExecutor js=(JavascriptExecutor)driver;
        return js;
    }

    public static void jsClick(WebElement element){
        getJSExecutor().executeScript("arguments[0].click",element);
        element.click();
    }
    public static String getTimeStamp(String pattern){
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    public static byte[] takeScreenshot(String filename){
        TakesScreenshot ts=(TakesScreenshot)driver;
        byte[] bytes=ts.getScreenshotAs(OutputType.BYTES);
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);

        try{
            FileUtils.copyFile(sourceFile, new File(Constants.SCREENSHOT_FILEPATH + filename + getTimeStamp("yyyy-MM-dd-HH-mm-ss")+".png"));
        }catch(IOException e){
            e.printStackTrace();
        }
        return bytes;
    }
    public static String getTextFromElement(WebElement e){
        return e.getText();
    }

    /**
     * This method will click on radiobutton or checkbox by the given list of elements and the value
     * @param radioCheckboxes
     * @param value
     */
    public static void clickRadioorCheckbox(List<WebElement> radioCheckboxes, String value){
        for (WebElement radioorCheckbox:radioCheckboxes){
            String actual =radioorCheckbox.getAttribute("value").trim();
            if(radioorCheckbox.isEnabled()&&actual.equals(value)){
                jsClick(radioorCheckbox);
                break;
            }
        }
    }

    /**
     * This method will click on radiobutton or checkbox by the given list of elements and the value
     * @param radioCheckboxes
     * @param value
     */
    public static void clickRadioorCheckboxbyText(List<WebElement> radioCheckboxes, String value){
        for (WebElement radioorCheckbox:radioCheckboxes){
            String actual =radioorCheckbox.getText().trim();
            if(radioorCheckbox.isEnabled()&&actual.equals(value)){
                click(radioorCheckbox);
                break;
            }
        }
    }

    /**
     * this metod will select given value from dropdown by visible text
     * @param DD
     * @param visibleText
     */
    public static void selectDropDownValue(WebElement DD,String visibleText){

        try{
            Select select=new Select(DD);
            List<WebElement>options=select.getOptions();
            for (WebElement option:options){
                if(option.getText().trim().equals(visibleText)){
                    select.selectByVisibleText(visibleText);
                }
            }
        }catch (UnexpectedTagNameException e){
            e.printStackTrace();
        }

    }

    /**
     * this method will select given value from dropdown by index
     * @param DD
     * @param index
     */
    public static void selectDropDownValue(WebElement DD,int index){
       try{
           Select select=new Select(DD);
           List<WebElement>options=select.getOptions();
           int DDSize= options.size();

           if(DDSize>index){
               select.selectByIndex(index);
           }
       }catch (UnexpectedTagNameException e){
           e.printStackTrace();
       }

    }
    /**
     * this metod will select given value from dropdown by value
     * @param DD
     * @param value
     */
    public static void selectDropDownValue(String value,WebElement DD){

        try{
            Select select=new Select(DD);
            List<WebElement>options=select.getOptions();
            for (WebElement option:options){
                if(option.getAttribute("value").equals(value)){
                    select.selectByValue(value);
                }
            }
        }catch (UnexpectedTagNameException e){
            e.printStackTrace();
        }

    }


    /**
     * this method will switch to frame by index
     * @param frameIndex
     */
    public static void switchToFrame(int frameIndex){
        try{
            driver.switchTo().frame(frameIndex);
        }catch(NoSuchFrameException e){
            e.printStackTrace();
        }

    }

    /**
     * this method will switch to frame by Name or ID
     * @param nameOrID
     */
    public static void switchToFrame(String nameOrID){
        try{
            driver.switchTo().frame(nameOrID);
        }catch(NoSuchFrameException e){
            e.printStackTrace();
        }

    }

    /**
     * this method will switch to a frame by the given webElement
     * @param webElement
     */
    public static void switchToFrame(WebElement webElement){
        try {
            driver.switchTo().frame(webElement);
        }catch (NoSuchFrameException e){
            e.printStackTrace();
        }
    }

    /**
     * switches to child window
     */
    public static void switchToChildWindow(){
        String main= driver.getWindowHandle();
        Set<String> allWindows= driver.getWindowHandles();
        for (String window:allWindows){
            if(window.equals(main)){
                driver.switchTo().window(window);
                break;
            }
        }
    }
    /**
     *
     */
    public static List<String> getDDValuesAndStoreInList(WebElement DD, String firstOption){
        Select select = new Select(DD);
        List<WebElement> DDoptions= select.getOptions();
        List<String> DDValues= new LinkedList<>();
        for (int i=1; i<DDoptions.size(); i++){
            DDValues.add(DDoptions.get(i).getText());
        }
        return DDValues;
    }
    public static String parsingMethod(String path) throws FileNotFoundException {
        File input= new File(path);
        JsonElement fileElement= JsonParser.parseReader(new FileReader(input));
        JsonObject empStatusList = fileElement.getAsJsonObject();




        return empStatusList.toString();
    }


}
