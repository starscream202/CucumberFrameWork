package com.hrms.StepDefinitions;

import com.google.common.base.Strings;
import com.hrms.Utils.GlobalVariables;
import com.hrms.Utils.db_Utils;
import io.cucumber.java.en.Then;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DatabaseSteps {
    @Then("collect data from database")
    public void collect_data_from_database() {
        String query="select emp_firstname,emp_lastname from hs_hr_employees where emp_number ='"+ GlobalVariables.emp_Id+"'";
        GlobalVariables.dblist=db_Utils.getDBDataIntoList(query);
    }

    @Then("all job title from db is displayed")
    public void all_job_title_from_db_is_displayed() {
        List<Map<String,String>> DBListofJobs= db_Utils.getDBDataIntoList("select  distinct job_title from ohrm_job_title order by job_title;;");
        List<String> DBlistValues= new LinkedList<>();
        for(int i=0; i<DBListofJobs.size(); i++){
            DBlistValues.add(DBListofJobs.get(i).toString());
        }
        System.out.println(DBlistValues);
    }


}
