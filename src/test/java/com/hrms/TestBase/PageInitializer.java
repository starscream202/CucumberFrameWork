package com.hrms.TestBase;

import com.hrms.Pages.*;
import org.openqa.selenium.WebDriver;

public class PageInitializer extends BaseClass{

    public static LoginPage loginPage;

    public static DashBoardPage dbPage;

    public static EmployeeList empList;

    public static AddEmployeePage addEmpPage;

    public static PersonalDetailsPage pdPage;

    public static ConfigurationPage configPage;

    public static LeaveListPage LLPage;

    public static google googlePage;






    public static void initializePageObjects(){

        loginPage=new LoginPage();
        dbPage=new DashBoardPage();
        empList=new EmployeeList();
        addEmpPage=new AddEmployeePage();
        pdPage=new PersonalDetailsPage();
        configPage=new ConfigurationPage();
        LLPage=new LeaveListPage();
        googlePage=new google();



    }

    public static void main(String[] args) {

    }

}
