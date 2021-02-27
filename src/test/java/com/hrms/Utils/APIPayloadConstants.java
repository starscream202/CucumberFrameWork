package com.hrms.Utils;

import net.minidev.json.JSONObject;

public class APIPayloadConstants {

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

}
