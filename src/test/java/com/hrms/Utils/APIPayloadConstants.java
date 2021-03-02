package com.hrms.Utils;

import com.hrms.api.apiTestingFinalSteps;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;

public class APIPayloadConstants {
    //trying to make id updatable
    /*public RequestSpecification request;
    public static Response response;
    public static String id;

    public static String returnID(){
        id=response.jsonPath().getString("employee[0].employee_id");
        return id;
    }
*/


    public static String createEmployeeBody() {
        JSONObject obj=new JSONObject();
        obj.put("emp_firstname","Sarada");
        obj.put("emp_lastname","Sasuke");
        obj.put("emp_middle_name","Uchiha");
        obj.put("emp_gender","F");
        obj.put("emp_birthday","2000-02-07");
        obj.put("emp_status","Employee");
        obj.put("emp_job_title","CEO");
        return obj.toString();
    }
     public static String updateEmployee(){
        JSONObject obj=new JSONObject();
        obj.put("employee_id", apiTestingFinalSteps.id);
        obj.put("emp_middle_name","Boruto");
        obj.put("emp_lastname","Uchiha");
        return  obj.toString();
     }
     public static String update_Employee(){
         JSONObject obj=new JSONObject();
         obj.put("employee_id", apiTestingFinalSteps.id);
         obj.put("emp_firstname","Sarada");
         obj.put("emp_middle_name","Boruto");
         obj.put("emp_lastname","Uchiha");
         obj.put("emp_gender","F");
         obj.put("emp_birthday","1987-02-21");
         obj.put("emp_status","Employee");
         obj.put("emp_job_title","Hokage");

         return  obj.toString();
     }

}
