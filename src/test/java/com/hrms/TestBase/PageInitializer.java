package com.hrms.TestBase;

import com.hrms.Pages.*;

public class PageInitializer extends BaseClass{

    public static LoginPage loginPage;

    public static DashBoardPage dbPage;

    public static EmployeeList empList;

    public static AddEmployeePage addEmpPage;

    public static PersonalDetailsPage pdPage;

    public static ConfigurationPage configPage;

    public static LeaveListPage LLPage;




    public static void initializePageObjects(){

        loginPage=new LoginPage();
        dbPage=new DashBoardPage();
        empList=new EmployeeList();
        addEmpPage=new AddEmployeePage();
        pdPage=new PersonalDetailsPage();
        configPage=new ConfigurationPage();
        LLPage=new LeaveListPage();


    }

}
