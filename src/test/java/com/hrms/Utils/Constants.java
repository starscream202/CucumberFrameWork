package com.hrms.Utils;

import com.hrms.TestBase.BaseClass;

public class Constants {

    public static final String CONFIGURATION_FILEPATH=System.getProperty("user.dir")+"\\src\\test\\resources\\configurations.properties";

    public static final String TESTDATA_FILEPATH="C:\\Users\\stars\\OneDrive\\Documents\\EmployeeData.xlsx";

    public static final String SCREENSHOT_FILEPATH=System.getProperty("user.dir")+"\\screenshots\\";

    public static final int IMPLICIT_WAIT_TIME=10;

    public static final int EXPLICIT_WAIT_TIME=20;

    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));

    }

}
