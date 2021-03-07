package com.hrms.TestBase;

import com.hrms.Utils.ConfigReader;
import com.hrms.Utils.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BaseClass {

    public static WebDriver driver;

    /**
     * This wil open browser and navigate to url.
     */
    public static void setUp(){
        ConfigReader.readProperties(Constants.CONFIGURATION_FILEPATH);
        switch (ConfigReader.getPropertyValue("browser").toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions=new ChromeOptions();
                chromeOptions.setHeadless(true);

                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Invalid Browser");
        }
        driver.get(ConfigReader.getPropertyValue("url").toLowerCase());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
        PageInitializer.initializePageObjects();
    }

    /**
     * This will close browser
     */

    public static void tearDown(){

        if(driver!=null){
            driver.quit();
        }

    }

    /**
     * this will navigate by specific url
     * @param url
     */
    public static void setUpChromeBrowser(String url){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get(url);
    }

    /**
     * set up firefox browser
     * @param url
     */
    public static void setUpFirefoxBrowser(String url){
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
        driver.get(url);
    }

}
