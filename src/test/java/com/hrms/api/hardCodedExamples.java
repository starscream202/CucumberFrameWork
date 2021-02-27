package com.hrms.api;

import com.hrms.Utils.GlobalVariables;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;

import static io.restassured.RestAssured.*;

public class hardCodedExamples {
    public static String URI=GlobalVariables.baseURI;
    @Test
    public void sampleTest(){
        RestAssured.baseURI="http://3.237.189.167/syntaxapi/api";
        String token="Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2MTQxMjY1NTYsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTYxNDE2OTc1NiwidXNlcklkIjoiMjM5MCJ9.QIkM76dVQ9PpUG1I5QuRiZGOawuaPEOW0dx9NFmdwDM";
        //preparing request to get one employee
        RequestSpecification getOneEmployeeRequest=given().header("Authorization",token).header("Content-Type","Application/json")
        .queryParam("employee_id","20001.0");
        Response getOneEmployeeResponse = getOneEmployeeRequest.when().get("/getOneEmployee.php");
        System.out.println(getOneEmployeeResponse.asString());
        getOneEmployeeResponse.then().assertThat().statusCode(200);
        getOneEmployeeResponse.prettyPrint();

    }
    @Test
    public void aPostCreateEmployee(){
        String uri=GlobalVariables.baseURI;
        RequestSpecification createEmployeRequest=given().header("Authorization", GlobalVariables.token).header("Content-Type","Application/json").body("{\n" +
                "  \"emp_firstname\": \"Nagato\",\n" +
                "  \"emp_lastname\": \"Pain\",\n" +
                "  \"emp_middle_name\": null,\n" +
                "  \"emp_gender\": \"M\",\n" +
                "  \"emp_birthday\": \"2021-02-11\",\n" +
                "  \"emp_status\": \"employee\",\n" +
                "  \"emp_job_title\": \"IT Analyst\"\n" +
                "}");
        Response createEmployeeResponse= createEmployeRequest.when().post("/createEmployee.php");
        createEmployeeResponse.prettyPrint();
        createEmployeeResponse.then().assertThat().statusCode(201);
        JsonPath r=createEmployeeResponse.jsonPath();
        r.prettyPrint();
        String id=createEmployeeResponse.jsonPath().getString("Employee[0].employee_id");
        System.out.println(id);
        createEmployeeResponse.then().assertThat().body("Message",equalTo("Entry Created"));
    }
    @Test
    public void aPutUpdateEmployee(){
        String uri=GlobalVariables.baseURI;
        JSONObject requestParams = new JSONObject();
        requestParams.put("employee_id", "13927"); // Cast
        requestParams.put("emp_middle_name", "NineTailedFox");
        requestParams.put("emp_gender","M");
        RequestSpecification updateEmployeeRequest=given().header("Authorization",GlobalVariables.token).header("Content_Type","Application/json").body(requestParams.toJSONString());

        Response updateEmployeeResponse=updateEmployeeRequest.when().put("/updatePartialEmplyeesDetails.php");
        updateEmployeeResponse.prettyPrint();
    }
    @Test
    public void getCreatedEmployee(){
        //created string for base URI
        String uri=GlobalVariables.baseURI;
       //creating request
        RequestSpecification getCreatedEmployeeRequest= given().header("Authorization", GlobalVariables.token).header("Content-Type","Application/json").queryParam("employee_id","13933");
       //creating response
        Response getCreatedEmployeeResponse=getCreatedEmployeeRequest.when().get("/getOneEmployee.php");
       //asserting using then()
        getCreatedEmployeeResponse.then().assertThat().body("employee[0].emp_firstname",equalTo("Madara"));
       getCreatedEmployeeResponse.prettyPrint();
       String id =getCreatedEmployeeResponse.body().jsonPath().getString("employee[0].employee_id");
       //asserting with boolean
       boolean verifyingID=id.equalsIgnoreCase("13933");
        Assert.assertTrue(verifyingID);
    }

    @Test
    public void getAllEmployees(){//playing around

        RequestSpecification getAllEmployeesRequest= given().header("Authorization",GlobalVariables.token).header("Content-Type","Application/json");
        Response getAllEmployeesResponse=getAllEmployeesRequest.when().get("/getAllEmployees.php");
        int intStatusCode=getAllEmployeesResponse.statusCode();
        getAllEmployeesResponse.then().assertThat().statusCode(200).equals(intStatusCode);
        getAllEmployeesResponse.prettyPrint();

    }
}

