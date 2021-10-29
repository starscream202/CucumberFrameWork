package com.hrms.StepDefinitions;

import com.hrms.TestBase.BaseClass;
import com.hrms.Utils.CommonMethods;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
    //Helps us run code that we will use alot like before and after in testNG

//    @Before
//    public void startTest(){
//        BaseClass.setUp();
//    }
//    @After
//    public void endTest(Scenario scenario){
//        byte[] screenshot;
//        if(scenario.isFailed()){
//            screenshot=CommonMethods.takeScreenshot("Failed/"+scenario.getName());
//        }else{
//            screenshot=CommonMethods.takeScreenshot("Passed/"+scenario.getName());
//        }
//
//        scenario.attach(screenshot, "image/png",scenario.getName());
//
//        BaseClass.tearDown();
//    }

}
