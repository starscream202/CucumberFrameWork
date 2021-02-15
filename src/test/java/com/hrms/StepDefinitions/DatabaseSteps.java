package com.hrms.StepDefinitions;

import com.google.common.base.Strings;
import com.hrms.TestBase.PageInitializer;
import com.hrms.Utils.CommonMethods;
import com.hrms.Utils.GlobalVariables;
import com.hrms.Utils.db_Utils;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.*;

import static com.hrms.TestBase.PageInitializer.empList;
import static com.hrms.Utils.CommonMethods.getDDValuesAndStoreInList;

public class DatabaseSteps {
    @Then("collect data from database")
    public void collect_data_from_database() {
        String query="select emp_firstname,emp_lastname from hs_hr_employees where emp_number ='"+ GlobalVariables.emp_Id+"'";
        GlobalVariables.dblist=db_Utils.getDBDataIntoList(query);
    }

    @Then("all job title from db is displayed")
    public void all_job_title_from_db_is_displayed() {
        List<Map<String,String>> DBListofJobs= db_Utils.getDBDataIntoList("select  distinct job_title from ohrm_job_title order by job_title;");
        List<String> DBlistValues= new LinkedList<>();
        for(int i=0; i<DBListofJobs.size(); i++){
            DBlistValues.add(DBListofJobs.get(i).toString());
        }

    }
    @Then("verify data is matched")
    public void verify_data_is_matched() {
        List<String> DBList= db_Utils.getDBDataIntoListofString("select  distinct job_title from ohrm_job_title where job_title !='Sales&Marketing Manager' order by job_title;");

        List<String> DDelements=getDDValuesAndStoreInList(empList.jobTitleDD,"LOL");
        System.out.println(DBList);
        System.out.println(DDelements);
        Assert.assertEquals("Verifying DB and front end match",DBList,DDelements);

    }


}
